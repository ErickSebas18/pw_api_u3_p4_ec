package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.Horario;

public interface IHorarioService {

	public void insertarHorario(Horario horario);
	public Horario seleccionarPorId(Integer id);
	public void actualizar(Horario horario);
	public void actualizarParcial(String codigoAntiguo, String codigoNuevo);
	public void borrar(Integer id);
}
