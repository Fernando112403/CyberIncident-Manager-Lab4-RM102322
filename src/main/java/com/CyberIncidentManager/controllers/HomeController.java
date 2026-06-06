package com.CyberIncidentManager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.CyberIncidentManager.service.IIncidenteService;

@Controller
public class HomeController {

    @Autowired
    private IIncidenteService incidenteService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("incidentes", incidenteService.listarTodos());
        return "home";
    }
}