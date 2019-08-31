package exodia2.web.controllers;

import exodia2.domain.entities.User;
import exodia2.domain.models.binding.UserLoginBindingModel;
import exodia2.domain.models.binding.UserRegisterBindingModel;
import exodia2.domain.models.service.UserServiceModel;
import exodia2.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/register")
    public ModelAndView register(ModelAndView modelAndView, HttpSession httpSession) {

        modelAndView.setViewName(
                httpSession.getAttribute("username") != null
                        ? "redirect:/login" : "register");

        return modelAndView;
    }


    @PostMapping("/register")
    public ModelAndView registerConfirm(@ModelAttribute UserRegisterBindingModel userRegisterBindingModel,
                                        ModelAndView modelAndView) {

        if (!userRegisterBindingModel.getPassword()
                .equals(userRegisterBindingModel.getConfirmPassword())) {
            throw new IllegalArgumentException("Passwords don't match!");
        }

        if (!this.userService
                .registerUser(this.modelMapper.map(
                        userRegisterBindingModel, UserServiceModel.class))) {
            throw new IllegalArgumentException("Registration failed!");
        }

        modelAndView.setViewName("redirect:/login");

        return modelAndView;
    }

    @GetMapping("/login")
    public ModelAndView login(ModelAndView modelAndView, HttpSession httpSession) {

        modelAndView.setViewName(
                httpSession.getAttribute("username") != null
                        ? "redirect:/home" : "login");

        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView loginConfirm(@ModelAttribute UserLoginBindingModel userLoginBindingModel,
                                     HttpSession httpSession, ModelAndView modelAndView) {

        UserServiceModel user = this.userService
                .loginUser(this.modelMapper.map(userLoginBindingModel, UserServiceModel.class));

        if (user == null) {
            throw new IllegalArgumentException("Login Failed!");
        }

        httpSession.setAttribute("username", user.getUsername());
        httpSession.setAttribute("userId", user.getId());

        modelAndView.setViewName("redirect:/home");

        return modelAndView;
    }

    @GetMapping("/logout")
    public ModelAndView logout(ModelAndView modelAndView, HttpSession httpSession) {
        httpSession.invalidate();

        modelAndView.setViewName("redirect:/");

        return modelAndView;
    }
}
