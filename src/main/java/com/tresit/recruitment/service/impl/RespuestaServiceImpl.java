package com.tresit.recruitment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tresit.recruitment.model.Respuesta;
import com.tresit.recruitment.repository.RespuestaRepository;
import com.tresit.recruitment.service.RespuestaService;

@Service
public class RespuestaServiceImpl implements RespuestaService {
	
	@Autowired
	private RespuestaRepository respuestaRepository;

	@Override
	public List<Respuesta> obtenerRespuesta() {
		return respuestaRepository.findAll();
	}

	@Override
	public Respuesta agregarRespuesta(Respuesta respuesta) {
		return respuestaRepository.save(respuesta);
	}

	@Override
	public int eliminarRespuesta(long idrespuesta) {
		int resultado = 0;
		try {
			respuestaRepository.deleteById(idrespuesta);
			resultado = 1;
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return resultado;
	}

	@Override
	public Respuesta editarRespuesta(Respuesta respuesta) {
		return respuestaRepository.save(respuesta);
	}

	@Override
	public Respuesta obtenerRespuestaPorId(long idrespuesta) {
		return respuestaRepository.findById(idrespuesta).get();
	}
	

}
