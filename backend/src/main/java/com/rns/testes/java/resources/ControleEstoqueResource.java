package com.rns.testes.java.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rns.testes.java.dto.ControleEstoqueDTO;
import com.rns.testes.java.dto.FilialDTO;
import com.rns.testes.java.dto.ProdutoDTO;
import com.rns.testes.java.model.ControleEstoque;
import com.rns.testes.java.repositories.ControleEstoqueRepository;
import com.rns.testes.java.repositories.ProdutoRepository;
import com.rns.testes.java.services.ControleEstoqueService;
import com.rns.testes.java.services.ProdutoService;

@RestController
@RequestMapping(value = "/estoque")
public class ControleEstoqueResource {
	
	@Autowired 
	private ControleEstoqueService service;
	
	
	
	@PostMapping
	public ResponseEntity<ControleEstoqueDTO> insert(@RequestBody ControleEstoqueDTO dto){
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri(); 
		return ResponseEntity.created(uri).body(dto);
		
	}
	
	@GetMapping
	public ResponseEntity<List<ControleEstoqueDTO>>findAll(){
		List<ControleEstoqueDTO>list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}

}
