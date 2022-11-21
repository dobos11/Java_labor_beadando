package com.example.java_labor_beadando;

import com.example.java_labor_beadando.kapcsolat.MessageRepository;
import com.example.java_labor_beadando.securityrole.Role;
import com.example.java_labor_beadando.securityrole.User;
import com.example.java_labor_beadando.securityrole.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;


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



    @GetMapping("/")
    public String index(){
        return ("Home");
    }


    @GetMapping("/Regisztracio")
    public String register(Model model) {
        model.addAttribute("reg", new User());
        return "Regisztracio";
    }

    @GetMapping("/Kapcsolatok")
    public String kapcsolat(){
        return "Kapcsolatok";
    }
    @Autowired
    private UserRepository userRepo;
    @PostMapping("/regisztral_feldolgoz")
    public String Regisztráció(@ModelAttribute User user, Model model) {
        for(User felhasznalo2: userRepo.findAll())
            if(felhasznalo2.getEmail().equals(user.getEmail())){
                model.addAttribute("uzenet", "A regisztrációs email már foglalt!");
                return "reghiba";
            }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role role = new Role();
// Minden regisztrációkor USER szerepet adunk a felhasználónak:
        role.setId(2); role.setName("ROLE_USER");
        List<Role> rolelist = new ArrayList<Role>();
        rolelist.add(role);
        user.setRoles(rolelist);
        userRepo.save(user);
        model.addAttribute("id", user.getId());
        return "/";
    }

    @Autowired
    private MessageRepository messageRepo;





}
