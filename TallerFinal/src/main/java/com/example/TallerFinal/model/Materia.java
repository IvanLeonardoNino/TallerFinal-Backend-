package com.example.TallerFinal.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Materia")

public class Materia {
	@Id
	private Long id;
	private String Nombre;
	
	public Materia() {
	}
	
	public Materia(Long id, String nombre) {
		super();
		this.id = id;
		Nombre = nombre;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	
	
	
	
}
