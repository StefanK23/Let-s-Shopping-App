package com.example.Let.sShopping.Web;


import com.example.Let.sShopping.Services.UserService;
import com.example.Let.sShopping.models.bindings.UserRegisterBindingModel;
import com.example.Let.sShopping.models.serviceModels.UserServiceModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserRegisterController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserRegisterController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/register")
    public String registerUser(Model model){
        if(!model.containsAttribute("userRegister")){
            model.addAttribute("userRegister", new UserRegisterBindingModel());
        }
        return "register";
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid @ModelAttribute UserRegisterBindingModel userRegister,
                                  BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("userRegister", userRegister);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegister",
                    bindingResult);
            return "redirect:register";
        }
        if(!userRegister.getConfirmPassword().equals(userRegister.getPassword())){
            return "redirect:register";
        }
        UserServiceModel   userServiceModel = modelMapper.map(userRegister, UserServiceModel.class);
        userService.registerUser(userServiceModel);
        return "redirect:login";
    }
}
