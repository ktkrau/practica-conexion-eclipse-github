package com.tresit.recruitment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tresit.recruitment.model.Pregunta;
import com.tresit.recruitment.repository.PreguntaRepository;
import com.tresit.recruitment.service.PreguntaService;

@Service
public class PreguntaServiceImpl implements PreguntaService {
	
	@Autowired
	private PreguntaRepository preguntaRepository;

	@Override
	public List<Pregunta> obtenerPregunta() {
		return preguntaRepository.findAll();
	}

	@Override
	public Pregunta agregarPregunta(Pregunta pregunta) {
		return preguntaRepository.save(pregunta);
	}

	@Override
	public int eliminarPregunta(long idpregunta) {
		int resultado = 0;
		try {
			preguntaRepository.deleteById(idpregunta);
			resultado = 1;
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return resultado;
	}

	@Override
	public Pregunta editarPregunta(Pregunta pregunta) {
		return preguntaRepository.save(pregunta);
	}

	@Override
	public Pregunta obtenerPreguntaPorId(long idpregunta) {
		return preguntaRepository.findById(idpregunta).get();
	}
	
	
}
