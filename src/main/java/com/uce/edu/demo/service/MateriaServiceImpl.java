package com.uce.edu.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IMateriaRepository;
import com.uce.edu.demo.repository.modelo.Materia;
import com.uce.edu.demo.service.to.MateriaTO;

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

	@Override
	public List<MateriaTO> buscarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		List<Materia> materia = this.iMateriaRepository.buscarCedulaEstudiante(cedula);
		List<MateriaTO> lista = materia.stream().map(e -> this.convertir(e)).collect(Collectors.toList());
		return lista;
	}

	private MateriaTO convertir(Materia materia){
		MateriaTO mat = new MateriaTO();
		mat.setCosto(materia.getCosto());
		mat.setCreditos(materia.getCreditos());
		mat.setId(materia.getId());
		mat.setNombre(materia.getNombre());
		return mat;
	}

	@Override
	public MateriaTO buscarPorIdMateria(Integer id) {
		// TODO Auto-generated method stub
		Materia m= this.iMateriaRepository.buscarMateria(id);
		return this.convertir(m);
	}
}
