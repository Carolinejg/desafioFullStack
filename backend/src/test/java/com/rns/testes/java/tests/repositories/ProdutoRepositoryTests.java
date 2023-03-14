package com.rns.testes.java.tests.repositories;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

import com.rns.testes.java.model.Produto;
import com.rns.testes.java.repositories.ProdutoRepository;

@DataJpaTest
public class ProdutoRepositoryTests {
	
	@Autowired
	private ProdutoRepository repository;
	
	private int existingId;
	private int nonExistingId;
	
	
	@BeforeEach
	void setUp() throws Exception{
		existingId = 1;
		nonExistingId = 1000;
		
	}
	
	
	@Test
	public void deleteShouldThrowsExceptionWhenIdDoesNotExist() { //deleta se o id existe
		Assertions.assertThrows(EmptyResultDataAccessException.class,() ->{
			repository.deleteById(nonExistingId);
		});
		
		
	}
	
	
	@Test
	public void deleteShouldDeleteObjectWhenIdExists() { //lança uma exception se o id nâo existe 
		repository.deleteById(existingId);
		Optional<Produto> result = repository.findById(existingId);
		
		Assertions.assertFalse(result.isPresent());
	}
	

}
