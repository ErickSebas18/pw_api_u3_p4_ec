package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Estudiante;

public interface IEstudianteRepository {

	public void insertarEstudiante(Estudiante estudiante);
	public Estudiante seleccionarPorCedula(String cedula);
	public void actualizar(Estudiante estudiante);
	public void actualizarParcial(String cedulaActual, String cedulaNueva);
	public void borrar(Integer id);
	public List<Estudiante> buscarTodos(String provincia);
	public void insertar2(Estudiante estudiante);
	public List<Estudiante> buscarEstudiantes();
}
