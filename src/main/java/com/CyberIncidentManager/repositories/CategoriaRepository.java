package com.CyberIncidentManager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CyberIncidentManager.models.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}