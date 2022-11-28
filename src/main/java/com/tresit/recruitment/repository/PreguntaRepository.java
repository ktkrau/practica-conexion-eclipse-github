package com.tresit.recruitment.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import com.tresit.recruitment.model.Pregunta;


public interface PreguntaRepository extends JpaRepository<Pregunta, Long>{
	
}
