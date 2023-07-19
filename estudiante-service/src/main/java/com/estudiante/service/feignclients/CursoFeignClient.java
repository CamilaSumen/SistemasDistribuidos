package com.estudiante.service.feignclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.estudiante.service.modelos.Curso;

@FeignClient(name = "curso-service",url = "http://localhost:8002")

public interface CursoFeignClient {
	
	@PostMapping("/curso")
	public Curso save(@RequestBody Curso curso);
	
	@GetMapping("/curso/estudiante/{estudianteId}")
	public List<Curso> getCursos(@PathVariable("estudianteId") int estudianteId);
}
