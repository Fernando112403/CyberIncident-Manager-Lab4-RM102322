package com.CyberIncidentManager.service;

import java.util.List;
import java.util.Optional;

import com.CyberIncidentManager.models.Categoria;

public interface ICategoriaService {

    List<Categoria> listarTodas();

    Optional<Categoria> buscarPorId(Integer id);

    Categoria guardar(Categoria categoria);

    void eliminar(Integer id);
}