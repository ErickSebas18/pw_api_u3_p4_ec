package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Materia;

public interface IMateriaRepository {

	public void insertarMateria(Materia materia);
	public Materia buscarMateria(Integer id);
	public void actualizarMateria(Materia materia);
	public void eliminar(Integer id);
	public List<Materia> buscarCedulaEstudiante(String cedula);
}
