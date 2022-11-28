package com.tresit.recruitment.service;

import java.util.List;

import com.tresit.recruitment.model.Respuesta;

public interface RespuestaService {
	
	public List<Respuesta> obtenerRespuesta();
	public Respuesta agregarRespuesta(Respuesta respuesta);
	public int eliminarRespuesta(long idrespuesta);
	public Respuesta editarRespuesta(Respuesta respuesta);
	public Respuesta obtenerRespuestaPorId(long idrespuesta);

}
