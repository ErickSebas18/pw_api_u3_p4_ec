package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Materia;
import com.uce.edu.demo.service.to.MateriaTO;

public interface IMateriaService {

	public void agregarMateria(Materia materia);
	public Materia buscarMateriaPorId(Integer id);
	public void actualizarMateria(Materia materia);
	public void eliminar(Integer id);
	public List<MateriaTO> buscarPorCedula(String cedula);
	public MateriaTO buscarPorIdMateria(Integer id);
}
