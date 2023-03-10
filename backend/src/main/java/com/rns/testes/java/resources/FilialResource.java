package com.rns.testes.java.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.rns.testes.java.dto.FilialDTO;
import com.rns.testes.java.enums.EnumTipoFilial;
import com.rns.testes.java.services.FilialService;

@RestController
@RequestMapping(value = "/filiais")
public class FilialResource {
	@Autowired 
	private FilialService service;
	
	@PostMapping
	public ResponseEntity<FilialDTO> insert(@RequestBody FilialDTO dto){
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri(); 
		return ResponseEntity.created(uri).body(dto);
		
	}
	
	@GetMapping
	public ResponseEntity<List<FilialDTO>>findAll(){
		List<FilialDTO>list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	
	/*@GetMapping(value="tipo/{id}")
	public ResponseEntity<List<FilialDTO>>findByTipoFilial(@PathVariable EnumTipoFilial id){
		List<FilialDTO>list = service.findTipoFilial(id);
		
		return ResponseEntity.ok().body(list);
	}*/

	
	@GetMapping(value="/{id}")
	public ResponseEntity<FilialDTO>findById(@PathVariable int id){
		FilialDTO dto = service.findById(id);
		
		return ResponseEntity.ok().body(dto);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<FilialDTO> update(@PathVariable int id,@RequestBody FilialDTO dto){
		dto = service.update(id,dto);
		return ResponseEntity.ok().body(dto);
		
		
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable int id){
		service.delete(id);
		return ResponseEntity.noContent().build();
		
		
	}
	
	
	
}
