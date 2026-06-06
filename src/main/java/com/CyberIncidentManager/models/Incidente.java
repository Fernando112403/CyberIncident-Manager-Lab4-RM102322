package com.CyberIncidentManager.models;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "incidentes")
public class Incidente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titulo;

	private Boolean activo;
    
    private String descripcion;

    public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaReporte;

    private String criticidad;

    private String estado;

    private String usuarioReporta;

    private String equipoAfectado;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public Incidente() {
    }

    public Incidente(Integer id, String titulo, String descripcion, LocalDate fechaReporte, String criticidad,
            String estado, String usuarioReporta, String equipoAfectado, Categoria categoria) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaReporte = fechaReporte;
        this.criticidad = criticidad;
        this.estado = estado;
        this.usuarioReporta = usuarioReporta;
        this.equipoAfectado = equipoAfectado;
        this.categoria = categoria;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaReporte() {
        return fechaReporte;
    }

    public void setFechaReporte(LocalDate fechaReporte) {
        this.fechaReporte = fechaReporte;
    }

    public String getCriticidad() {
        return criticidad;
    }

    public void setCriticidad(String criticidad) {
        this.criticidad = criticidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUsuarioReporta() {
        return usuarioReporta;
    }

    public void setUsuarioReporta(String usuarioReporta) {
        this.usuarioReporta = usuarioReporta;
    }

    public String getEquipoAfectado() {
        return equipoAfectado;
    }

    public void setEquipoAfectado(String equipoAfectado) {
        this.equipoAfectado = equipoAfectado;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}