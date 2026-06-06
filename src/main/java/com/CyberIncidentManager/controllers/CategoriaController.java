package com.CyberIncidentManager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.CyberIncidentManager.models.Categoria;
import com.CyberIncidentManager.service.ICategoriaService;

@Controller
public class CategoriaController {

    @Autowired
    private ICategoriaService categoriaService;

    @GetMapping("/categorias")
    public String listarCategorias(Model model) {
        model.addAttribute("categorias", categoriaService.listarTodas());
        return "categorias/index";
    }

    @GetMapping("/categorias/crear")
    public String mostrarFormularioCrear(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "categorias/crear";
    }

    @PostMapping("/categorias/guardar")
    public String guardarCategoria(Categoria categoria) {
        categoriaService.guardar(categoria);
        return "redirect:/categorias";
    }

    @GetMapping("/categorias/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Integer id, Model model) {
        Categoria categoria = categoriaService.buscarPorId(id).orElse(null);

        if (categoria == null) {
            return "redirect:/categorias";
        }

        model.addAttribute("categoria", categoria);
        return "categorias/editar";
    }

    @GetMapping("/categorias/eliminar/{id}")
    public String eliminarCategoria(@PathVariable Integer id) {
        categoriaService.eliminar(id);
        return "redirect:/categorias";
    }
}