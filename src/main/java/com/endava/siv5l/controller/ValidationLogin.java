package com.endava.siv5l.controller;

import com.endava.siv5l.service.validation.LoginValidation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by siv5l on 4/12/16.
 */
@Controller
public class ValidationLogin {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String checkLogging(@Valid @ModelAttribute("loginValidation")LoginValidation loginValidation, BindingResult result,ModelMap model){

        if(result.hasErrors()){
            model.addAttribute(result);
            return "log/unlogged";
        }
            return "log/logged";
    }
}
