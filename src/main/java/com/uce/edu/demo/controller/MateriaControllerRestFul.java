package com.uce.edu.demo.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
import com.uce.edu.demo.service.to.MateriaTO;

@RestController
@RequestMapping("/materias")
public class MateriaControllerRestFul {

	@Autowired
	private IMateriaService iMateriaService;
	
	@PostMapping(path = "/guardar")
	public void guardarMateria(@RequestBody Materia materia) {
		this.iMateriaService.agregarMateria(materia);
	}
	
	/*@GetMapping(path = "/buscarMateria")
	public Materia buscarPorId() {
		Integer id = 1;
		return this.iMateriaService.buscarMateriaPorId(id);
	}*/
	
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MateriaTO> buscarPorId(@PathVariable Integer id) {
		MateriaTO materia = this.iMateriaService.buscarPorIdMateria(id);
		return new ResponseEntity(materia, null,200);
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
	
	/*@GetMapping(path = "/{id}")
	public ResponseEntity<MateriaTO> buscarMateria(@PathVariable Integer id) {
		MateriaTO m = this.iMateriaService.buscarPorIdMateria(id);
		Link link = linkTo(methodOn(MateriaControllerRestFul.class).iMateriaService.buscarMateriaPorId(m.getId())).withSelfRel();
		m.add(link);
		return new ResponseEntity(m,null,200);
	}*/
}
