package com.uce.edu.demo.repository.modelo;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "estudiante")
public class Estudiante {

	@Id
	@Column(name = "est_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "est_seq_id")
	@SequenceGenerator(name = "est_seq_id", sequenceName = "est_seq_id", allocationSize = 1)
	private Integer id;
	@Column(name = "est_nombre")
	private String nombre;
	@Column(name = "est_apellido")
	private String apellido;
	@Column(name = "est_fecha_nacimiento")
	private LocalDateTime fechaNacimiento;
	@Column(name = "est_cedula")
	private String cedula;

	// Getters y Setters
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

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDateTime getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

}
