package com.uce.edu.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uce.edu.demo.repository.modelo.Estudiante;
import com.uce.edu.demo.service.IEstudianteService;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteControllerRestFul {

	@Autowired
	private IEstudianteService estudianteService;
	
	@GetMapping(path= "/buscar/{cedula}")
	public Estudiante consultarPorCedula(@PathVariable String cedula) {
		return this.estudianteService.seleccionarPorCedula(cedula);
	}
	
	
	@PostMapping(path = "/guardar")
	public void guardar(@RequestBody Estudiante estudiante) {
		this.estudianteService.guardar(estudiante);
	}
	
	@PutMapping(path = "/actualizar/{identificador}")
	public void actualizar(@RequestBody Estudiante estudiante, @PathVariable Integer identificador) {
		estudiante.setId(identificador);
		this.estudianteService.actualizar(estudiante);
	}
	
	@PatchMapping(path = "/actualizarParcial/{identificador}")
	public void actualizarParcial(@RequestBody Estudiante estudiante, @PathVariable Integer identificador) {
		estudiante.setId(identificador);
		String cedula = "1724555555";
		Estudiante estu1 = this.estudianteService.seleccionarPorCedula(cedula);
		estu1.setCedula(estudiante.getCedula());
		this.estudianteService.actualizar(estudiante);
	}
	
	@DeleteMapping(path = "/borrar/{id}")
	public void eliminar(@PathVariable Integer id) {
		this.estudianteService.eliminar(id);
	}
	
	@GetMapping(path = "/buscarTodos")
	public List<Estudiante> buscarTodos(String provincia){
		return this.estudianteService.buscarTodos(provincia);
	}
	
	@GetMapping(path="/buscarProvincia")
	public List<Estudiante> consultarTodos(@RequestParam String provincia){
		return this.estudianteService.buscarTodos(provincia);
	}
}
