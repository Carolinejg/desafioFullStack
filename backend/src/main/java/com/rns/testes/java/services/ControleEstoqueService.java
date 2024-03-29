package com.rns.testes.java.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rns.testes.java.dto.ControleEstoqueDTO;
import com.rns.testes.java.dto.FilialDTO;
import com.rns.testes.java.model.ControleEstoque;
import com.rns.testes.java.model.Filial;
import com.rns.testes.java.repositories.ControleEstoqueRepository;
import com.rns.testes.java.services.exceptions.DatabaseException;
import com.rns.testes.java.services.exceptions.ResourceNotFoundException;


@Service
public class ControleEstoqueService {
	
	@Autowired
	private ControleEstoqueRepository repository;
	
	
	@Transactional
	public ControleEstoqueDTO insert(ControleEstoqueDTO dto) {
		try {
			ControleEstoque entity = new ControleEstoque();
			entity.setFilial(dto.getFilial());
			entity.setProduto(dto.getProduto());
			entity.setQuantidade(dto.getQuantidade());
					
			entity = repository.save(entity);
			
			return new ControleEstoqueDTO(entity);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Viola��o de integridade do banco");
		}
		
	}
	
	@Transactional(readOnly=true) 
	public List<ControleEstoqueDTO> findAll(){
		List<ControleEstoque> list= repository.findAll();
		List<ControleEstoqueDTO>listDto = new ArrayList<>();
		
		for(ControleEstoque cob : list) {
			listDto.add(new ControleEstoqueDTO(cob));
		}
		
		return listDto;
	}
	
	@Transactional
	public ControleEstoqueDTO update(int id,ControleEstoqueDTO dto) {
		try {
			ControleEstoque entity = repository.getOne(id);
			entity.setFilial(dto.getFilial());
			entity = repository.save(entity);
			
			return new ControleEstoqueDTO(entity);
		}catch(EntityNotFoundException e) {
			throw new  ResourceNotFoundException("Id n�o encontrado "+id);
		}
		
	}
	
	
	
	
}
