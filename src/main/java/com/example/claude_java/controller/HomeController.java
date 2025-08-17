package com.example.claude_java.controller;

import com.example.claude_java.model.FormSubmission;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    
    private List<FormSubmission> submissions = new ArrayList<>();
    
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("formSubmission", new FormSubmission());
        model.addAttribute("submissions", submissions);
        model.addAttribute("pageTitle", "Contact Form Demo");
        model.addAttribute("totalSubmissions", submissions.size());
        return "index";
    }
    
    @PostMapping("/submit")
    public String submitForm(@ModelAttribute FormSubmission formSubmission, Model model) {
        submissions.add(formSubmission);
        
        model.addAttribute("formSubmission", new FormSubmission());
        model.addAttribute("submissions", submissions);
        model.addAttribute("pageTitle", "Contact Form Demo");
        model.addAttribute("totalSubmissions", submissions.size());
        model.addAttribute("successMessage", "Form submitted successfully!");
        
        return "index";
    }
}