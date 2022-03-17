package com.example.TallerFinal.model;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Actividad")
public class Actividad {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String Nombre;
	private String Descripcion;
	private Date Fecha_Inicio;
	private Date Fecha_Final;
	
	@ManyToOne
	@JoinColumn(name="Materia_id")
	private Materia Materia;
	@ManyToOne
	@JoinColumn(name="Importancia_id")
	private Importancia Importancia;
	@ManyToOne
	@JoinColumn(name="Estado_id")
	private Estado Estado;
	
	public Actividad() {
	}
	
	public Actividad(String nombre, String descripcion, Date fecha_Inicio, Date fecha_Final,
			com.example.TallerFinal.model.Materia materia, com.example.TallerFinal.model.Importancia importancia,
			com.example.TallerFinal.model.Estado estado) {
		super();
		Nombre = nombre;
		Descripcion = descripcion;
		Fecha_Inicio = fecha_Inicio;
		Fecha_Final = fecha_Final;
		Materia = materia;
		Importancia = importancia;
		Estado = estado;
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
	public Date getFecha_Inicio() {
		return Fecha_Inicio;
	}
	public void setFecha_Inicio(Date fecha_Inicio) {
		Fecha_Inicio = fecha_Inicio;
	}
	public Date getFecha_Final() {
		return Fecha_Final;
	}
	public void setFecha_Final(Date fecha_Final) {
		Fecha_Final = fecha_Final;
	}
	public Materia getMateria() {
		return Materia;
	}
	public void setMateria(Materia materia) {
		Materia = materia;
	}
	public Importancia getImportancia() {
		return Importancia;
	}
	public void setImportancia(Importancia importancia) {
		Importancia = importancia;
	}
	public Estado getEstado() {
		return Estado;
	}
	public void setEstado(Estado estado) {
		Estado = estado;
	}
	
	
	
}
