package com.tutoria.service.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tutoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String nombrecurso;
	private String docente;
	private int estudianteId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombrecurso() {
		return nombrecurso;
	}
	public void setNombrecurso(String nombrecurso) {
		this.nombrecurso = nombrecurso;
	}
	public String getDocente() {
		return docente;
	}
	public void setDocente(String docente) {
		this.docente = docente;
	}
	public int getEstudianteId() {
		return estudianteId;
	}
	public void setEstudianteId(int estudianteId) {
		this.estudianteId = estudianteId;
	}
	public Tutoria() {
		super();
	}
	
}
