package exodia2.web.controllers;

import exodia2.domain.models.view.DocumentHomeViewModel;
import exodia2.service.DocumentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    private final DocumentService documentService;
    private final ModelMapper modelMapper;

    @Autowired
    public HomeController(DocumentService documentService, ModelMapper modelMapper) {
        this.documentService = documentService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/")
    public ModelAndView index(ModelAndView modelAndView, HttpSession httpSession) {


        modelAndView.setViewName(
                httpSession.getAttribute("username") != null
                        ? "redirect:/home" : "index");

        return modelAndView;
    }

    @GetMapping("/home")
    public ModelAndView home(ModelAndView modelAndView, HttpSession httpSession) {
        modelAndView.setViewName(
                httpSession.getAttribute("username") != null
                        ? "home" : "redirect:/");

        List<DocumentHomeViewModel> documents = this.documentService
                .findAllDocuments()
                .stream()
                .map(x -> this.modelMapper.map(x, DocumentHomeViewModel.class))
                .peek(x -> {
                    if (x.getTitle().length() > 12) {
                        x.setTitle(x.getTitle().substring(0, 11) + "...");
                    }
                })
                .collect(Collectors.toList());

        modelAndView.addObject("documents", documents);

        return modelAndView;
    }
}
