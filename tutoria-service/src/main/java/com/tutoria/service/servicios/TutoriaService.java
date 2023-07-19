package com.tutoria.service.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutoria.service.entidades.Tutoria;
import com.tutoria.service.repositorio.TutoriaRepository;

@Service
public class TutoriaService {
	
	@Autowired
	private TutoriaRepository tutoriaRepository;
	
	public List<Tutoria> getAll(){
		return tutoriaRepository.findAll();
	}
	
	public Tutoria getTutoriaById(int id) {
		return tutoriaRepository.findById(id).orElse(null);
	}
	
	public Tutoria save(Tutoria tutoria) {
		Tutoria nuevoTutoria = tutoriaRepository.save(tutoria);
		return nuevoTutoria;
	}
	
	public List<Tutoria> byEstudianteId(int estudianteId){
		return tutoriaRepository.findByEstudianteId(estudianteId);
	}

}
