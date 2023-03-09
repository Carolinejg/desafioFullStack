package com.rns.testes.java.dto;

import java.io.Serializable;

import com.rns.testes.java.model.Produto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProdutoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int id;
    private String nome;
    
	
	public ProdutoDTO(Produto entity) {
		
		this.id = entity.getId();
		this.nome = entity.getNome();
	}
    
	
    
}
