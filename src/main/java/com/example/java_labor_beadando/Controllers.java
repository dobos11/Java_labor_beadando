package com.example.java_labor_beadando;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class Controllers  {
    @Autowired
    private AdatokRepository adatokRepository;


    @GetMapping("/teszt")
    public String Kezdooldal(Model model, String uzenet) {
        model.addAttribute("meccsek", adatokRepository.findAll());
        model.addAttribute("uzenet", model.getAttribute("uzenet"));
        return "Meccseink";
    }


    /*@GetMapping("/Home")
    public String home(){
        return ("Home");
    } */


}
