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

import com.example.TallerFinal.model.Estado;
import com.example.TallerFinal.service.EstadoService;

@RestController
@RequestMapping("/estado/")
public class EstadoRest {

	@Autowired
	private EstadoService estadoService;
	
	@GetMapping
	private ResponseEntity<List<Estado>> getAllEstado(){
		return ResponseEntity.ok(estadoService.findAll());	
	}
	
	@PostMapping
	private ResponseEntity<Estado> saveEstado (@RequestBody Estado estado){
		try {
			Estado EstadoGuardado=estadoService.save(estado);
			return ResponseEntity.created(new URI("/estado/"+EstadoGuardado.getId())).body(EstadoGuardado);
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@DeleteMapping (value = "delete/{id}")
	private ResponseEntity<Boolean> deleteMateria(@PathVariable ("id") Long id){
		estadoService.deleteById(id);
		return ResponseEntity.ok(!(estadoService.findById(id)!=null));
	}
	
}
