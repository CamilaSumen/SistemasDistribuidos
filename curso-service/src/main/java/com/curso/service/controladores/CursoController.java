package com.curso.service.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.service.entidades.Curso;
import com.curso.service.servicios.CursoService;

@RestController
@RequestMapping("/curso")
public class CursoController {
	
	@Autowired
	private CursoService cursoService;
	
	@GetMapping
	public ResponseEntity<List<Curso>> listarCursos(){
		List<Curso> cursos = cursoService.getAll();
		if(cursos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(cursos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Curso> obtenerCurso(@PathVariable("id") int id){
		Curso curso = cursoService.getCursoById(id);
		if (curso == null) {
			return ResponseEntity.notFound().build();
		}
		return  ResponseEntity.ok(curso);
	}
	
	@PostMapping
	public ResponseEntity<Curso> guardarCurso(@RequestBody Curso curso){
		Curso nuevoCurso = cursoService.save(curso);
		return ResponseEntity.ok(nuevoCurso);
	}
	
	@GetMapping("/estudiante/{estudianteId}")
	public ResponseEntity<List<Curso>> listarCursosPorEstudianteId(@PathVariable("estudianteId") int id){
		List<Curso> cursos = cursoService.byEstudianteId(id);
		if(cursos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(cursos);
	}
}
