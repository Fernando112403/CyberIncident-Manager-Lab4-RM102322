package com.CyberIncidentManager.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CyberIncidentManager.models.Incidente;
import com.CyberIncidentManager.repositories.IncidenteRepository;
import com.CyberIncidentManager.service.IIncidenteService;

@Service
public class IncidenteServiceImpl implements IIncidenteService {

    @Autowired
    private IncidenteRepository incidenteRepository;

    @Override
    public List<Incidente> listarTodos() {
        return incidenteRepository.findAll();
    }

    @Override
    public Optional<Incidente> buscarPorId(Integer id) {
        return incidenteRepository.findById(id);
    }

    @Override
    public Incidente guardar(Incidente incidente) {
        return incidenteRepository.save(incidente);
    }

    @Override
    public void eliminar(Integer id) {
        incidenteRepository.deleteById(id);
    }
}