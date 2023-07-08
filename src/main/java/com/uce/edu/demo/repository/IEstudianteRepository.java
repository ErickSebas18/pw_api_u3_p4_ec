package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.Estudiante;

public interface IEstudianteRepository {

	public Estudiante seleccionarPorCedula(String cedula);
}
