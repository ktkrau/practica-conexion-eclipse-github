package com.tresit.recruitment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tresit.recruitment.model.Pregunta;
import com.tresit.recruitment.service.PreguntaService;

@RestController
@RequestMapping("/api/v1/preguntas")
public class PreguntaController {
	
	@Autowired
	private PreguntaService preguntaService;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Pregunta> listado(){
		System.out.println("Listado de preguntas");
		return preguntaService.obtenerPregunta();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public Pregunta agregar(@RequestBody Pregunta pregunta) {
		return preguntaService.agregarPregunta(pregunta);
		
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Pregunta obtenerPorId(@PathVariable Long id) {
		return preguntaService.obtenerPreguntaPorId(id);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Pregunta editar(@RequestBody Pregunta preguntaModificada, @PathVariable Long id) {
		Pregunta question = preguntaService.obtenerPreguntaPorId(id);
		question.setDetalle(preguntaModificada.getDetalle());
		question.setActivo(preguntaModificada.isActivo());
		return preguntaService.agregarPregunta(question);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void eliminar(@PathVariable Long id) {
		preguntaService.eliminarPregunta(id);
	}
}
