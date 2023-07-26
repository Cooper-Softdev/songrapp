package com.songr.songrapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CapitalizeController {
    @GetMapping("/capitalize/{text}")
    public String getCapitalizePage(Model m, @PathVariable String text){
        text = text.toUpperCase();
        m.addAttribute("capitalizedWords", text);
        return "capitalize";
    }
}
