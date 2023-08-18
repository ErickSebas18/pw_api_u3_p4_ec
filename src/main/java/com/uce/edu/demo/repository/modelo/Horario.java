package com.uce.edu.demo.repository.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "horario")
public class Horario {

	@Id
	@Column(name = "hora_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hora_seq_id")
	@SequenceGenerator(name = "hora_seq_id", sequenceName = "hora_seq_id", allocationSize = 1)
	private Integer id;
	@Column(name = "hora_jornada")
	private String jornada;
	@Column(name = "hora_numero_horas")
	private Integer numeroHoras;
	@Column(name = "hora_profesor")
	private String profesor;
	@Column(name = "hora_codigo")
	private String codigo;
	
	//GETTERS Y SETTERS
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getJornada() {
		return jornada;
	}
	public void setJornada(String jornada) {
		this.jornada = jornada;
	}
	public Integer getNumeroHoras() {
		return numeroHoras;
	}
	public void setNumeroHoras(Integer numeroHoras) {
		this.numeroHoras = numeroHoras;
	}
	public String getProfesor() {
		return profesor;
	}
	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
	
}
