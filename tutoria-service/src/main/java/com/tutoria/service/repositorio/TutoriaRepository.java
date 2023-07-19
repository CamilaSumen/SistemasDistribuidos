package com.tutoria.service.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutoria.service.entidades.Tutoria;

@Repository
public interface TutoriaRepository extends JpaRepository<Tutoria, Integer> {
	List<Tutoria> findByEstudianteId(int estudianteId);
}
