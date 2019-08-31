package realestateapplication.web.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import realestateapplication.domain.models.binding.OfferRegisterBindingModel;
import realestateapplication.domain.models.service.OfferServiceModel;
import realestateapplication.service.OfferService;

@Controller
public class OfferController {

    private final OfferService offerService;
    private final ModelMapper modelMapper;

    @Autowired
    public OfferController(OfferService offerService, ModelMapper modelMapper) {
        this.offerService = offerService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/register")
    public String register() {
        return "register.html";
    }

    @PostMapping("/register")
    public String registerConfirm(@ModelAttribute(name = "model") OfferRegisterBindingModel model) {
        try {
            this.offerService
                    .registerOffer(this.modelMapper.map(model, OfferServiceModel.class));
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());

            return "redirect:/register";
        }

        return "redirect:/";
    }

    @GetMapping("/find")
    public String find() {
        return "find.html";
    }
}

