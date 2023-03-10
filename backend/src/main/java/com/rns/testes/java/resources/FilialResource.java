package com.rns.testes.java.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rns.testes.java.dto.FilialDTO;
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
				.buildAndExpand(dto.getId()).toUri(); //inserindo e repondendo no cabeçalho de resposta
		return ResponseEntity.created(uri).body(dto);
		
	}
}
