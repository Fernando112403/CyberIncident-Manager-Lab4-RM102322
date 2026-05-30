package com.CyberIncidentManager.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CyberIncidentManager.models.Incidente;

@Repository
public interface IncidenteRepository extends JpaRepository<Incidente, Integer> {

}