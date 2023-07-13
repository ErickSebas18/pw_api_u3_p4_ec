package com.uce.edu.demo.repository;

import java.time.LocalDateTime;

import com.uce.edu.demo.repository.modelo.Estudiante;

public interface IEstudianteRepository {

	public void insertarEstudiante(Estudiante estudiante);
	public Estudiante seleccionarPorCedula(String cedula);
}
