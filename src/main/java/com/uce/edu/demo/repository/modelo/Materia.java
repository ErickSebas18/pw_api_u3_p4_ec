package com.uce.edu.demo.repository.modelo;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "materia")
public class Materia {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mate_seq_id")
	@SequenceGenerator(name = "mate_seq_id", sequenceName = "mate_seq_id", allocationSize = 1)
	@Column(name = "mate_id")
	private Integer id;
	@Column(name = "mate_nombre")
	private String nombre;
	@Column(name = "mate_creditos")
	private Integer creditos;
	@Column(name = "mate_costo")
	private BigDecimal costo;

	@ManyToOne
	@JoinColumn(name = "mate_id_estu")
	private Estudiante estudiante;

	// GETTERS Y SETTERS
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCreditos() {
		return creditos;
	}

	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}

	public BigDecimal getCosto() {
		return costo;
	}

	public void setCosto(BigDecimal costo) {
		this.costo = costo;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

}
