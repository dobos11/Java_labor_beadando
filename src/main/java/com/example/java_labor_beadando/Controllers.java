package com.example.java_labor_beadando;

import com.example.java_labor_beadando.kapcsolat.Message;
import com.example.java_labor_beadando.kapcsolat.MessageRepository;
import com.example.java_labor_beadando.modelclasses.Meccsek;
import com.example.java_labor_beadando.securityrole.Role;
import com.example.java_labor_beadando.securityrole.User;
import com.example.java_labor_beadando.securityrole.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.el.MethodNotFoundException;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;



@Controller
public class Controllers  {
    @Autowired
    private com.example.java_labor_beadando.repositories.dataRepository dataRepository;
    @Autowired
    private com.example.java_labor_beadando.repositories.dataIIRepository dataIIRepository;
    @Autowired
    private com.example.java_labor_beadando.repositories.dataIIIRepository dataIIIRepository;



    @GetMapping("/meccseink")
    public String Kezdooldal(Model model) {
        model.addAttribute("meccsek", dataRepository.findAll());
        model.addAttribute("nezok", dataIIRepository.findAll());
        model.addAttribute("belepesek", dataIIIRepository.findAll());

        model.addAttribute("uzenet",model.addAttribute("uzenet"));
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



    @Autowired
    private UserRepository userRepo;
    @PostMapping("/regisztral_feldolgoz")
    public String Regisztr??ci??(@ModelAttribute User user, Model model) {
        for(User felhasznalo2: userRepo.findAll())
            if(felhasznalo2.getEmail().equals(user.getEmail())){
                model.addAttribute("uzenet", "A regisztr??ci??s email m??r foglalt!");
                return "reghiba";
            }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role role = new Role();
// Minden regisztr??ci??kor USER szerepet adunk a felhaszn??l??nak:
        role.setId(2); role.setName("ROLE_USER");
        List<Role> rolelist = new ArrayList<Role>();
        rolelist.add(role);
        user.setRoles(rolelist);
        userRepo.save(user);
        model.addAttribute("id", user.getId());
        return "/Home";
    }

    @Autowired
    private MessageRepository messageRepo;
    //
    @GetMapping("/Kapcsolatok")
    public String ujUzenet(Model model){
        model.addAttribute("message","");
        return "Kapcsolatok";
    }

    @PostMapping(value = "/ment")
    public String uzenetMentese(@Validated @RequestParam String message, HttpServletRequest request){
        Principal userPrincipal= request.getUserPrincipal();
        Message msg= new Message();
        msg.setMessage(message);
        if(userPrincipal!=null){msg.setName(userPrincipal.getName());}
        else{msg.setName("Vend??g");}
        msg.setDate(new Date());
        messageRepo.save(msg);
        return "Home";
    }

    @GetMapping("/uzenetek")
    public String uzenetek(Model model){
        model.addAttribute("messages",messageRepo.findByOrderByDateDesc());
        return "uzenetek";
    }

    //Restful API

    //Add

}
