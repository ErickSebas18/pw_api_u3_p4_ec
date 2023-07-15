package com.uce.edu.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uce.edu.demo.repository.modelo.Materia;
import com.uce.edu.demo.service.IMateriaService;

@RestController
@RequestMapping("/materias")
public class MateriaControllerRestFul {

	@Autowired
	private IMateriaService iMateriaService;
	
	@PostMapping(path = "/guardar")
	public void guardarMateria(@RequestBody Materia materia) {
		this.iMateriaService.agregarMateria(materia);
	}
	
	@GetMapping(path = "/buscarMateria")
	public Materia buscarPorId() {
		Integer id = 1;
		return this.iMateriaService.buscarMateriaPorId(id);
	}
	
	@PutMapping(path = "/actualizarMateria/{identificador}")
	public void actualizar(@RequestBody Materia materia, @PathVariable Integer identificador) {
		materia.setId(identificador);
		this.iMateriaService.actualizarMateria(materia);
	}
	
	@DeleteMapping(path = "/borrarMateria/{id}")
	public void eliminar(@PathVariable Integer id) {
		this.iMateriaService.eliminar(id);
	}
}
