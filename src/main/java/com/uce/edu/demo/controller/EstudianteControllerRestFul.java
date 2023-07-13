package com.uce.edu.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uce.edu.demo.repository.modelo.Estudiante;
import com.uce.edu.demo.service.IEstudianteService;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteControllerRestFul {

	@Autowired
	private IEstudianteService estudianteService;
	
	@GetMapping(path= "/buscar")
	public Estudiante consultarPorCedula() {
		String cedula = "1724555555";
		return this.estudianteService.seleccionarPorCedula(cedula);
	}
	
	
	@PostMapping(path = "/guardar")
	public void guardar(@RequestBody Estudiante estudiante) {
		this.estudianteService.guardar(estudiante);
	}
	
	@PatchMapping(path = "/actualizarParcial")
	public void actualizarParcial() {
		
	}
	
	@PutMapping(path = "/actualizar")
	public void actualizar() {
		
	}
	
	@DeleteMapping(path = "/borrar")
	public void eliminar() {
		
	}
}
