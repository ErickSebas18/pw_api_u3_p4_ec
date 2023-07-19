package com.uce.edu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IHorarioRepository;
import com.uce.edu.demo.repository.modelo.Horario;

@Service
public class HorarioServiceImpl implements IHorarioService{

	@Autowired
	private IHorarioRepository horarioRepository;
	
	@Override
	public void insertarHorario(Horario horario) {
		// TODO Auto-generated method stub
		this.horarioRepository.insertarHorario(horario);
	}

	@Override
	public Horario seleccionarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.horarioRepository.seleccionarPorId(id);
	}

	@Override
	public void actualizar(Horario horario) {
		// TODO Auto-generated method stub
		this.horarioRepository.actualizar(horario);
	}

	@Override
	public void actualizarParcial(String codigoAntiguo, String codigoNuevo) {
		// TODO Auto-generated method stub
		this.horarioRepository.actualizarParcial(codigoAntiguo, codigoNuevo);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.horarioRepository.borrar(id);
	}

}
