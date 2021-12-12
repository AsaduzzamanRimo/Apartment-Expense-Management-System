package edu.diu.finalproject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppControlar {
	@RequestMapping("/")
    public String viewHomePage(Model model) {
        
         
        return "home";
    }
}
