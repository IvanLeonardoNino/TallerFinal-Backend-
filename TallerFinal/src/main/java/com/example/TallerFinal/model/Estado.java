package com.example.TallerFinal.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Estado")

public class Estado {
	@Id
	private Long id;
	private String Nombre;
	private String Descripcion;
	
	public Estado() {
	}
	
	public Estado(Long id, String nombre, String descripcion) {
		super();
		this.id = id;
		Nombre = nombre;
		Descripcion = descripcion;
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
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	
	
	
	
	
	
	
}
