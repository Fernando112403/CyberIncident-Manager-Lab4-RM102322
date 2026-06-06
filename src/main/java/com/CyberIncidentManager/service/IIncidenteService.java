package com.CyberIncidentManager.service;

import java.util.List;
import java.util.Optional;

import com.CyberIncidentManager.models.Incidente;

public interface IIncidenteService {

    List<Incidente> listarTodos();

    Optional<Incidente> buscarPorId(Integer id);

    Incidente guardar(Incidente incidente);

    void eliminar(Integer id);
}