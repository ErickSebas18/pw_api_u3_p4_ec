package com.uce.edu.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IEstudianteRepository;
import com.uce.edu.demo.repository.modelo.Estudiante;
import com.uce.edu.demo.service.to.EstudianteTO;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

	@Autowired
	private IEstudianteRepository estudianteRepository;

	@Override
	public Estudiante seleccionarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.estudianteRepository.seleccionarPorCedula(cedula);
	}

	@Override
	public void guardar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepository.insertarEstudiante(estudiante);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepository.actualizar(estudiante);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.estudianteRepository.borrar(id);
	}

	@Override
	public List<Estudiante> buscarTodos(String provincia) {
		// TODO Auto-generated method stub
		return this.estudianteRepository.buscarTodos(provincia);
	}

	@Override
	public Integer estudianteId(Estudiante estudiante) {
		// TODO Auto-generated method stub
		this.estudianteRepository.insertar2(estudiante);
		Estudiante identificador = this.seleccionarPorCedula(estudiante.getCedula());
		return identificador.getId();
	}

	@Override
	public List<EstudianteTO> buscarEstudiantes() {
		// TODO Auto-generated method stub
		List<Estudiante> lista = this.estudianteRepository.buscarEstudiantes();
		List<EstudianteTO> listaTO = lista.stream().map(e ->  this.convertir(e)).collect(Collectors.toList());
		return listaTO;
	}

	private EstudianteTO convertir(Estudiante estudiante) {
		EstudianteTO estu = new EstudianteTO();
		estu.setId(estudiante.getId());
		estu.setNombre(estudiante.getNombre());
		estu.setApellido(estudiante.getApellido());
		estu.setCedula(estudiante.getCedula());
		estu.setFechaNacimiento(estudiante.getFechaNacimiento());
		estu.setProvincia(estudiante.getProvincia());
		return estu;
	}
	
	

}
