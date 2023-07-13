package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.Estudiante;

public interface IEstudianteService {

	public Estudiante seleccionarPorCedula(String cedula);
	public void guardar(Estudiante estudiante);
}
