package com.rns.testes.java.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rns.testes.java.dto.ProdutoDTO;
import com.rns.testes.java.model.Produto;
import com.rns.testes.java.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repository;
	
	@Transactional
	public ProdutoDTO insert(ProdutoDTO dto) {
		Produto entity = new Produto();
		entity.setNome(dto.getNome());
		entity = repository.save(entity);
		
		return new ProdutoDTO(entity);

	}
	
	@Transactional(readOnly=true) //garantia da aplicação das propriedades ACIDE , readOnly nâo trava o banco 
	public List<ProdutoDTO> findAll(){
		List<Produto> list= repository.findAll();
		List<ProdutoDTO>listDto = new ArrayList<>();
		
		for(Produto cob : list) {
			listDto.add(new ProdutoDTO(cob));
		}
		
		return listDto;
	}
}
