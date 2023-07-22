package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Estudiante;

public interface IEstudianteService {

	public Estudiante seleccionarPorCedula(String cedula);
	public void guardar(Estudiante estudiante);
	public void actualizar(Estudiante estudiante);
	public void eliminar(Integer id);
	public List<Estudiante> buscarTodos(String provincia);
	public Integer estudianteId(Estudiante estudiante);
}
