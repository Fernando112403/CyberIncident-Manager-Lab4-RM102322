package com.CyberIncidentManager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.CyberIncidentManager.models.Incidente;
import com.CyberIncidentManager.service.ICategoriaService;
import com.CyberIncidentManager.service.IIncidenteService;

@Controller
public class IncidenteController {

    @Autowired
    private IIncidenteService incidenteService;

    @Autowired
    private ICategoriaService categoriaService;

    @GetMapping("/incidentes")
    public String listarIncidentes(Model model) {
        model.addAttribute("incidentes", incidenteService.listarTodos());
        return "incidentes/index";
    }

    @GetMapping("/incidentes/crear")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("incidente", new Incidente());
        model.addAttribute("categorias", categoriaService.listarTodas());
        return "incidentes/crear";
    }

    @PostMapping("/incidentes/guardar")
    public String guardarIncidente(Incidente incidente) {
        incidenteService.guardar(incidente);
        return "redirect:/incidentes";
    }

    @GetMapping("/incidentes/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Integer id, Model model) {
        Incidente incidente = incidenteService.buscarPorId(id).orElse(null);

        if (incidente == null) {
            return "redirect:/incidentes";
        }

        model.addAttribute("incidente", incidente);
        model.addAttribute("categorias", categoriaService.listarTodas());
        return "incidentes/editar";
    }

    @GetMapping("/incidentes/eliminar/{id}")
    public String eliminarIncidente(@PathVariable Integer id) {
        incidenteService.eliminar(id);
        return "redirect:/incidentes";
    }
}