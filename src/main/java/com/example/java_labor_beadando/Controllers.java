package com.example.java_labor_beadando;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class Controllers  {

    @GetMapping("/Home")
    public String home(){
        return ("Home");
    }

}
