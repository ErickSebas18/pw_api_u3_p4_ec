package com.uce.edu.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uce.edu.demo.repository.modelo.Estudiante;
import com.uce.edu.demo.repository.modelo.Horario;
import com.uce.edu.demo.service.IHorarioService;

@RestController
@RequestMapping("/horarios")
public class HorarioControllerRestFul {

	@Autowired
	private IHorarioService horarioService;
	
	@GetMapping(path= "/{id}")
	public Horario consultarPorId(@PathVariable Integer id) {
		return this.horarioService.seleccionarPorId(id);
	}
	
	
	@PostMapping
	public void guardar(@RequestBody Horario horario) {
		this.horarioService.insertarHorario(horario);
	}
	
	@PutMapping(path = "/{identificador}")
	public void actualizar(@RequestBody Horario horario, @PathVariable Integer identificador) {
		horario.setId(identificador);
		this.horarioService.actualizar(horario);
	}
	
	@PatchMapping(path = "/{identificador}")
	public void actualizarParcial(@PathVariable Integer identificador) {
		Horario horario1 = this.horarioService.seleccionarPorId(identificador);
		String codigoNuevo = "234234";
		horario1.setCodigo(codigoNuevo);
		this.horarioService.actualizar(horario1);
	}
	
	@DeleteMapping(path = "/{id}")
	public void eliminar(@PathVariable Integer id) {
		this.horarioService.borrar(id);
	}
	
}
