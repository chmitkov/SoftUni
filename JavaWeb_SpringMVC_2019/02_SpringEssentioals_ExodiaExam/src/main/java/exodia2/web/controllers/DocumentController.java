package exodia2.web.controllers;

import exodia2.domain.models.binding.DocumentBindingModel;
import exodia2.domain.models.service.DocumentServiceModel;
import exodia2.domain.models.view.DocumentDetailsViewModel;
import exodia2.domain.models.view.DocumentPrintView;
import exodia2.service.DocumentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class DocumentController {

    private final DocumentService documentService;
    private final ModelMapper modelMapper;

    @Autowired
    public DocumentController(DocumentService documentService, ModelMapper modelMapper) {
        this.documentService = documentService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/schedule")
    public ModelAndView schedule(ModelAndView modelAndView, HttpSession httpSession) {
        modelAndView.setViewName(
                httpSession.getAttribute("username") == null
                        ? "redirect:/" : "schedule");

        return modelAndView;
    }

    @PostMapping("/schedule")
    public ModelAndView scheduleConfirm(@ModelAttribute DocumentBindingModel documentBindingModel,
                                        ModelAndView modelAndView) {
        DocumentServiceModel documentServiceModel =
                this.documentService
                        .createDocument(this.modelMapper
                                .map(documentBindingModel, DocumentServiceModel.class));

        modelAndView.setViewName("redirect:/details/" + documentServiceModel.getId());

        return modelAndView;
    }

    @GetMapping("/details/{id}")
    public ModelAndView details(@PathVariable(name = "id") String id,
                                ModelAndView modelAndView) {
        DocumentServiceModel documentServiceModel =
                this.documentService.findById(id);

        if (documentServiceModel == null) {
            throw new IllegalArgumentException("Document not found!");
        }

        modelAndView.addObject("model",
                this.modelMapper.map(documentServiceModel, DocumentDetailsViewModel.class));
        modelAndView.setViewName("/details");

        return modelAndView;
    }


    @GetMapping("/print/{id}")
    public ModelAndView print(@PathVariable(name = "id") String id, ModelAndView modelAndView) {

        DocumentPrintView documentPrintView = this.modelMapper.map(
                this.documentService.findById(id), DocumentPrintView.class);

        modelAndView.addObject("document", documentPrintView);
        modelAndView.setViewName("print");

        return modelAndView;
    }

    @PostMapping("/print/{id}")
    public ModelAndView printConfirm(@PathVariable(name = "id") String id, ModelAndView modelAndView) {
        this.documentService
                .deleteDocument(id);
        modelAndView.setViewName("redirect:/home");

        return modelAndView;
    }
}
