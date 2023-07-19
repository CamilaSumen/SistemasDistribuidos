package com.estudiante.service.feignclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.estudiante.service.modelos.Tutoria;


@FeignClient(name = "tutoria-service",url = "http://localhost:8003")
public interface TutoriaFeignClient {
	
	@PostMapping("/tutoria")
	public Tutoria save(@RequestBody Tutoria tutoria);
	
	@GetMapping("/tutoria/estudiante/{estudianteId}")
	public List<Tutoria> getTutorias(@PathVariable("estudianteId") int estudianteId);
}
