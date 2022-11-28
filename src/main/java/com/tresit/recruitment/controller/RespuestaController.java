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

import com.tresit.recruitment.model.Respuesta;
import com.tresit.recruitment.service.RespuestaService;

@RestController
@RequestMapping("/api/v1/respuestas")
public class RespuestaController {

	
	@Autowired
	private RespuestaService respuestaService;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Respuesta> listado(){
		System.out.println("Listado de respuestas");
		return respuestaService.obtenerRespuesta();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public Respuesta agregar(@RequestBody Respuesta respuesta) {
		return respuestaService.agregarRespuesta(respuesta);
		
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Respuesta obtenerPorId(@PathVariable Long id) {
		return respuestaService.obtenerRespuestaPorId(id);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Respuesta editar(@RequestBody Respuesta respuestaModificada, @PathVariable Long id) {
		Respuesta answer = respuestaService.obtenerRespuestaPorId(id);
		answer.setDetalle(respuestaModificada.getDetalle());
		answer.setPuntaje(respuestaModificada.getPuntaje());
		return respuestaService.agregarRespuesta(answer);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void eliminar(@PathVariable Long id) {
		respuestaService.eliminarRespuesta(id);
	}
}
