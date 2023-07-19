package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.Horario;

public interface IHorarioRepository {

	public void insertarHorario(Horario horario);
	public Horario seleccionarPorId(Integer id);
	public void actualizar(Horario horario);
	public void actualizarParcial(String codigoAntiguo, String codigoNuevo);
	public void borrar(Integer id);
}
