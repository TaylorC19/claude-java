package com.example.claude_java.controller;

import com.example.claude_java.db.DbAgent;
import com.example.claude_java.model.FormSubmission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class HomeController {
    
    @Autowired
    private DbAgent dbAgent;
    
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("formSubmission", new FormSubmission());
        model.addAttribute("submissions", dbAgent.findAll());
        model.addAttribute("pageTitle", "Contact Form Demo");
        model.addAttribute("totalSubmissions", dbAgent.count());
        return "index";
    }
    
    @PostMapping("/submit")
    public String submitForm(@ModelAttribute FormSubmission formSubmission, Model model) {
        dbAgent.save(formSubmission);
        
        model.addAttribute("formSubmission", new FormSubmission());
        model.addAttribute("submissions", dbAgent.findAll());
        model.addAttribute("pageTitle", "Contact Form Demo");
        model.addAttribute("totalSubmissions", dbAgent.count());
        model.addAttribute("successMessage", "Form submitted successfully!");
        
        return "index";
    }
}