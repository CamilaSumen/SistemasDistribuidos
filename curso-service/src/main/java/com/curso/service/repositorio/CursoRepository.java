package com.curso.service.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curso.service.entidades.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer>{
	List<Curso> findByEstudianteId(int estudianteId);
}
