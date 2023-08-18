package com.uce.edu.demo.repository.modelo;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "estudiante")
@JsonIgnoreProperties(value = "materias")
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
	@Column(name = "est_provincia")
	private String provincia;

	@OneToMany(mappedBy = "estudiante")
	private List<Materia> materias;
	
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

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public List<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}

	
}
