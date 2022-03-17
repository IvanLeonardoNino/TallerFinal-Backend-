package com.example.TallerFinal.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TallerFinal.model.Actividad;
import com.example.TallerFinal.service.ActividadService;

@RestController
@RequestMapping("/actividad/")
public class ActividadRest {

	@Autowired
	private ActividadService actividadService;
	
	@GetMapping
	private ResponseEntity<List<Actividad>> getAllActividad(){
		return ResponseEntity.ok(actividadService.findAll());	
	}
	
	@PostMapping
	private ResponseEntity<Actividad> saveActividad (@RequestBody Actividad actividad){
		try {
			Actividad ActividadGuardada=actividadService.save(actividad);
			return ResponseEntity.created(new URI("/actividad/"+ActividadGuardada.getId())).body(ActividadGuardada);
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@DeleteMapping (value = "delete/{id}")
	private ResponseEntity<Boolean> deleteActividad(@PathVariable ("id") Long id){
		actividadService.deleteById(id);
		return ResponseEntity.ok(!(actividadService.findById(id)!=null));
		
	}
}
