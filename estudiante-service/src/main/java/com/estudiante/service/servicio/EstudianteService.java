package com.estudiante.service.servicio;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudiante.service.entidades.Estudiante;
import com.estudiante.service.feignclients.CursoFeignClient;
import com.estudiante.service.feignclients.TutoriaFeignClient;
import com.estudiante.service.modelos.Curso;
import com.estudiante.service.modelos.Tutoria;
import com.estudiante.service.repositorios.EstudianteRepository;

@Service
public class EstudianteService {

	@Autowired
	private EstudianteRepository estudianteRepository;

	@Autowired
	private CursoFeignClient cursoFeignClient;

	@Autowired
	private TutoriaFeignClient tutoriaFeignClient;

	public List<Estudiante> getAll() {
		return estudianteRepository.findAll();
	}

	public Estudiante getEstudianteById(int id) {
		return estudianteRepository.findById(id).orElse(null);
	}

	public Estudiante save(Estudiante estudiante) {
		Estudiante nuevoEstudiante = estudianteRepository.save(estudiante);
		return nuevoEstudiante;
	}

	public Curso saveCurso(int estudianteId, Curso curso) {
		curso.setEstudianteId(estudianteId);
		Curso nuevoCurso = cursoFeignClient.save(curso);
		return nuevoCurso;
	}

	public Tutoria saveTutoria(int estudianteId, Tutoria tutoria) {
		tutoria.setEstudianteId(estudianteId);
		Tutoria nuevoTutoria = tutoriaFeignClient.save(tutoria);
		return nuevoTutoria;
	}

	public Map<String, Object> getEstudianteAndEstudios(int estudianteId) {
		Map<String, Object> resultado = new HashMap<>();
		Estudiante estudiante = estudianteRepository.findById(estudianteId).orElse(null);
		if (estudiante == null) {
			resultado.put("Mensaje", "El estudiante no existe");
			return resultado;
		}

		resultado.put("Estudiante", estudiante);
		List<Curso> cursos = cursoFeignClient.getCursos(estudianteId);

		if (cursos.isEmpty()) {
			resultado.put("Cursos", "El estudiante no tiene cursos");
		} else {
			resultado.put("Cursos", cursos);
		}

		List<Tutoria> tutorias = tutoriaFeignClient.getTutorias(estudianteId);

		if (tutorias.isEmpty()) {
			resultado.put("Tutorias", "El estudiante no tiene tutorias");
		} else {
			resultado.put("Tutorias", tutorias);
		}
		return resultado;
	}

}
