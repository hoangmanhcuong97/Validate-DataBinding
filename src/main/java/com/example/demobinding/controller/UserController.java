package com.example.demobinding.controller;

import com.example.demobinding.model.User;
import lombok.var;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Comparator;
import java.util.stream.Stream;

@Controller
public class UserController {
    @GetMapping("/getForm")
    public String getForm(Model model){
        model.addAttribute("user", new User());
        return "form";
    }

    @PostMapping("/submit")
    public String submit(@Valid User user, BindingResult bindingResult){
        System.out.println(user);
        if (bindingResult.hasErrors()) {
            Stream<ObjectError> errorStream = bindingResult.getAllErrors().stream();
            errorStream.sorted(Comparator.comparing(ObjectError::getDefaultMessage));
            return "form";
        }
        return "information";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        System.out.println("A binder for object: " + binder.getObjectName());
    }
}
