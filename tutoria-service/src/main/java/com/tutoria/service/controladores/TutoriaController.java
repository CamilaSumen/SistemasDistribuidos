package com.tutoria.service.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutoria.service.entidades.Tutoria;
import com.tutoria.service.servicios.TutoriaService;

@RestController
@RequestMapping("/tutoria")
public class TutoriaController {
	
	@Autowired
	private TutoriaService tutoriaService;
	
	@GetMapping
	public ResponseEntity<List<Tutoria>> listarTutorias(){
		List<Tutoria> tutorias = tutoriaService.getAll();
		if(tutorias.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(tutorias);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Tutoria> obtenerTutoria(@PathVariable("id") int id){
		Tutoria tutoria = tutoriaService.getTutoriaById(id);
		if (tutoria == null) {
			return ResponseEntity.notFound().build();
		}
		return  ResponseEntity.ok(tutoria);
	}
	
	@PostMapping
	public ResponseEntity<Tutoria> guardarTutoria(@RequestBody Tutoria tutoria){
		Tutoria nuevoTutoria = tutoriaService.save(tutoria);
		return ResponseEntity.ok(nuevoTutoria);
	}
	
	@GetMapping("/estudiante/{estudianteId}")
	public ResponseEntity<List<Tutoria>> listarTutoriasPorEstudianteId(@PathVariable("estudianteId") int id){
		List<Tutoria> tutorias = tutoriaService.byEstudianteId(id);
		if(tutorias.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(tutorias);
	}
}
