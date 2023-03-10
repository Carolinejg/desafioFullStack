package com.rns.testes.java.services;

import java.util.Date;
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
			throw new DatabaseException("Violação de integridade do banco");
		}
		

		
	}
	
	
	
}
