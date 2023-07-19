package com.curso.service.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.service.entidades.Curso;
import com.curso.service.repositorio.CursoRepository;

@Service
public class CursoService {

	@Autowired
	private CursoRepository cursoRepository;
	
	public List<Curso> getAll(){
		return cursoRepository.findAll();
	}
	
	public Curso getCursoById(int id) {
		return cursoRepository.findById(id).orElse(null);
	}
	
	public Curso save(Curso curso) {
		Curso nuevoCurso = cursoRepository.save(curso);
		return nuevoCurso;
	}
	
	public List<Curso> byEstudianteId(int estudianteId){
		return cursoRepository.findByEstudianteId(estudianteId);
	}
}
