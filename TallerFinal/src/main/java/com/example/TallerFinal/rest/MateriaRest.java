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

import com.example.TallerFinal.model.Materia;
import com.example.TallerFinal.service.MateriaService;

@RestController
@RequestMapping("/materia/")
public class MateriaRest {

	@Autowired
	private MateriaService materiaService;
	
	@GetMapping
	private ResponseEntity<List<Materia>> getAllMateria(){
		return ResponseEntity.ok(materiaService.findAll());	
	}
	
	@PostMapping
	private ResponseEntity<Materia> saveMateria (@RequestBody Materia materia){
		try {
			Materia MateriaGuardada=materiaService.save(materia);
			return ResponseEntity.created(new URI("/materia/"+MateriaGuardada.getId())).body(MateriaGuardada);
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@DeleteMapping (value = "delete/{id}")
	private ResponseEntity<Boolean> deleteActividad(@PathVariable ("id") Long id){
		materiaService.deleteById(id);
		return ResponseEntity.ok(!(materiaService.findById(id)!=null));
		
	}
}
