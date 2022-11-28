package com.tresit.recruitment.service;

import java.util.List;

import com.tresit.recruitment.model.Pregunta;


public interface PreguntaService {
	
	public List<Pregunta> obtenerPregunta();
	public Pregunta agregarPregunta(Pregunta pregunta);
	public int eliminarPregunta(long idpregunta);
	public Pregunta editarPregunta(Pregunta pregunta);
	public Pregunta obtenerPreguntaPorId(long idpregunta);

}
