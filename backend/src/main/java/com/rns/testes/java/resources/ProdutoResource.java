package com.rns.testes.java.resources;

import java.net.URI;
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

import com.rns.testes.java.dto.ProdutoDTO;
import com.rns.testes.java.services.ProdutoService;

import java.util.List;



@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {
	
	@Autowired 
	private ProdutoService service;
	
	
	@GetMapping
	public ResponseEntity<List<ProdutoDTO>>findAll(){
		List<ProdutoDTO>list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<ProdutoDTO> insert(@RequestBody ProdutoDTO dto){
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri(); 
		return ResponseEntity.created(uri).body(dto);
		
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<ProdutoDTO>findById(@PathVariable int id){
		ProdutoDTO dto = service.findById(id);
		
		return ResponseEntity.ok().body(dto);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<ProdutoDTO> update(@PathVariable int id,@RequestBody ProdutoDTO dto){
		dto = service.update(id,dto);
		return ResponseEntity.ok().body(dto);
		
		
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable int id){
		service.delete(id);
		return ResponseEntity.noContent().build();
		
		
	}
	

}
