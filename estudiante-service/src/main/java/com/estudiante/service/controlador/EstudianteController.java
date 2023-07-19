package com.estudiante.service.controlador;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudiante.service.entidades.Estudiante;
import com.estudiante.service.modelos.Curso;
import com.estudiante.service.modelos.Tutoria;
import com.estudiante.service.servicio.EstudianteService;

@RestController
@RequestMapping("/estudiante")
public class EstudianteController {
	
	@Autowired
	private EstudianteService estudianteService;
	
	@GetMapping
	public ResponseEntity<List<Estudiante>> listarEstudiantes(){
		List<Estudiante> estudiantes = estudianteService.getAll();
		if(estudiantes.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(estudiantes);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Estudiante> obtenerEstudiante(@PathVariable("id") int id){
		Estudiante estudiante = estudianteService.getEstudianteById(id);
		if (estudiante == null) {
			return ResponseEntity.notFound().build();
		}
		return  ResponseEntity.ok(estudiante);
	}
	
	@PostMapping
	public ResponseEntity<Estudiante> guardarEstudiante(@RequestBody Estudiante estudiante){
		Estudiante nuevoEstudiante = estudianteService.save(estudiante);
		return ResponseEntity.ok(nuevoEstudiante);
	}
	
	@PostMapping("/curso/{estudianteId}")
	public ResponseEntity<Curso> guardarCurso(@PathVariable("estudianteId") int estudianteId, @RequestBody Curso curso){
		Curso nuevoCurso = estudianteService.saveCurso(estudianteId, curso);
		return ResponseEntity.ok(nuevoCurso);
	}
	
	@PostMapping("/tutoria/{estudianteId}")
	public ResponseEntity<Tutoria> guardarTutoria(@PathVariable("estudianteId") int estudianteId,@RequestBody Tutoria tutoria){
		Tutoria nuevoTutoria = estudianteService.saveTutoria(estudianteId, tutoria);
		return ResponseEntity.ok(nuevoTutoria);
	}
	
	@GetMapping("/todos/{estudianteId}")
	public ResponseEntity<Map<String, Object>> listarTodosLosEstudios(@PathVariable("estudianteId") int estudianteId){
		Map<String, Object> resultado = estudianteService.getEstudianteAndEstudios(estudianteId);
		return ResponseEntity.ok(resultado);
	}
	
}
