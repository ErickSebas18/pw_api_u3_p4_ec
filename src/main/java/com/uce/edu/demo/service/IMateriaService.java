package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.Materia;

public interface IMateriaService {

	public void agregarMateria(Materia materia);
	public Materia buscarMateriaPorId(Integer id);
	public void actualizarMateria(Materia materia);
	public void eliminar(Integer id);
}
