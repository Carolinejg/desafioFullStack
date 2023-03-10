package com.rns.testes.java.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.rns.testes.java.dto.ProdutoDTO;
import com.rns.testes.java.model.Produto;
import com.rns.testes.java.repositories.ProdutoRepository;
import com.rns.testes.java.services.exceptions.ResourceNotFoundException;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repository;
	
	
	
	@Transactional
	public ProdutoDTO insert(ProdutoDTO dto) {
		Produto entity = new Produto();
		entity.setNome(dto.getNome());
		Date date = new Date();
		entity.setDataUltAlteracao1(date);
		entity = repository.save(entity);
		
		return new ProdutoDTO(entity);

	}
	
	@Transactional(readOnly=true) 
	public List<ProdutoDTO> findAll(){
		List<Produto> list= repository.findAll();
		List<ProdutoDTO>listDto = new ArrayList<>();
		
		for(Produto cob : list) {
			listDto.add(new ProdutoDTO(cob));
		}
		
		return listDto;
	}
	
	@Transactional(readOnly=true)
	public ProdutoDTO findById(int id) {
		Optional<Produto>obj = repository.findById(id);
		Produto entity = obj.orElseThrow(()->new ResourceNotFoundException("Entidade não encontrada"));
		 
		return new ProdutoDTO(entity);
	}
	
	@Transactional
	public ProdutoDTO update(int id,ProdutoDTO dto) {
		try {
			Produto entity = repository.getOne(id);
			entity.setNome(dto.getNome());
			Date date = new Date();
			entity.setDataUltAlteracao1(date);
			entity = repository.save(entity);
			
			return new ProdutoDTO(entity);
		}catch(EntityNotFoundException e) {
			throw new  ResourceNotFoundException("Id não encontrado "+id);
		}
		
	}

	
}
