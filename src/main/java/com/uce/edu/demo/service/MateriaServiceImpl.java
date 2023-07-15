package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IMateriaRepository;
import com.uce.edu.demo.repository.modelo.Materia;

@Service
public class MateriaServiceImpl implements IMateriaService{

	@Autowired
	private IMateriaRepository iMateriaRepository;
	
	@Override
	public void agregarMateria(Materia materia) {
		// TODO Auto-generated method stub
		this.iMateriaRepository.insertarMateria(materia);
	}

	@Override
	public Materia buscarMateriaPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.iMateriaRepository.buscarMateria(id);
	}

	@Override
	public void actualizarMateria(Materia materia) {
		// TODO Auto-generated method stub
		this.iMateriaRepository.actualizarMateria(materia);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.iMateriaRepository.eliminar(id);
	}

}
