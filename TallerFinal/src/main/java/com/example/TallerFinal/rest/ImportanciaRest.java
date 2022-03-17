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

import com.example.TallerFinal.model.Importancia;
import com.example.TallerFinal.service.ImportanciaService;

@RestController
@RequestMapping("/importancia/")
public class ImportanciaRest {
	
	@Autowired
	private ImportanciaService importanciaService;
	
	@GetMapping
	private ResponseEntity<List<Importancia>> getallImportancia(){
		return ResponseEntity.ok(importanciaService.findAll());	
	}
		
	@PostMapping
	private ResponseEntity<Importancia> saveImportancia (@RequestBody Importancia importancia){
		try {
			Importancia ImportanciaGuardada=importanciaService.save(importancia);
			return ResponseEntity.created(new URI("/importancia/"+ImportanciaGuardada.getId())).body(ImportanciaGuardada);
				
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}	
	}
	
	@DeleteMapping (value = "delete/{id}")
	private ResponseEntity<Boolean> deleteActividad(@PathVariable ("id") Long id){
		importanciaService.deleteById(id);
		return ResponseEntity.ok(!(importanciaService.findById(id)!=null));
		
	}
}
	