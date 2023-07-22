package com.uce.edu.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uce.edu.demo.repository.modelo.Estudiante;
import com.uce.edu.demo.service.IEstudianteService;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteControllerRestFul {

	@Autowired
	private IEstudianteService estudianteService;
	
	@GetMapping(path= "/{cedula}")
	public ResponseEntity<Estudiante> consultarPorCedula(@PathVariable String cedula) {
		//return this.estudianteService.seleccionarPorCedula(cedula);
		return ResponseEntity.status(227).body(this.estudianteService.seleccionarPorCedula(cedula));
	}
	
	@GetMapping(path= "/status2/{cedula}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.CONFLICT)
	public Estudiante consultarPorCedula2(@PathVariable String cedula) {
		return this.estudianteService.seleccionarPorCedula(cedula);
	}
	
	@PostMapping(consumes = "application/xml")
	public void guardar(@RequestBody Estudiante estudiante) {
		this.estudianteService.guardar(estudiante);
	}
	
	@PutMapping(path = "/{identificador}")
	public void actualizar(@RequestBody Estudiante estudiante, @PathVariable Integer identificador) {
		estudiante.setId(identificador);
		this.estudianteService.actualizar(estudiante);
	}
	
	@PatchMapping(path = "/{identificador}")
	public void actualizarParcial(@RequestBody Estudiante estudiante, @PathVariable Integer identificador) {
		estudiante.setId(identificador);
		String cedula = "465121654";
		Estudiante estu1 = this.estudianteService.seleccionarPorCedula(cedula);
		estu1.setCedula(estudiante.getCedula());
		this.estudianteService.actualizar(estudiante);
	}
	
	@DeleteMapping(path = "/{id}")
	public void eliminar(@PathVariable Integer id) {
		this.estudianteService.eliminar(id);
	}
	
	/*@GetMapping
	public List<Estudiante> buscarTodos(String provincia){
		return this.estudianteService.buscarTodos(provincia);
	}*/
	
	@GetMapping
	public ResponseEntity<List<Estudiante>> consultarTodos(@RequestParam String provincia){
		//return this.estudianteService.buscarTodos(provincia);
		List<Estudiante> lista = this.estudianteService.buscarTodos(provincia);
		HttpHeaders cabeceras = new HttpHeaders();
		cabeceras.add("detalleMensaje", "Estudiantes encontrados");
		cabeceras.add("valorAPI", "Incalculable");
		return new ResponseEntity<List<Estudiante>>(lista, cabeceras,227);
	}
	
	@PostMapping(path="/status",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
	public Integer identificador(@RequestBody Estudiante estudiante) {
		return this.estudianteService.estudianteId(estudiante);
	}
}
