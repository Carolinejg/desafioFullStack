package com.rns.testes.java.resources;

import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rns.testes.java.dto.ProdutoDTO;
import com.rns.testes.java.services.ProdutoService;

import java.util.List;



@RestController
@RequestMapping(value = "/produtos")//a classe repsonde nessa rota
public class ProdutoResource {
	
	@Autowired //injetando
	private ProdutoService service;
	
	
	@GetMapping
	public ResponseEntity<List<ProdutoDTO>>findAll(){
		List<ProdutoDTO>list = service.findAll();
		
		return ResponseEntity.ok().body(list);//resposta 200 ou seja foi com sucesso
	}
	
	@PostMapping
	public ResponseEntity<ProdutoDTO> insert(@RequestBody ProdutoDTO dto){
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri(); //inserindo e repondendo no cabeçalho de resposta
		return ResponseEntity.created(uri).body(dto);
		
	}
	
	

}
