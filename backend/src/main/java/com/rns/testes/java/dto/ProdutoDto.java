package com.rns.testes.java.dto;

import java.io.Serializable;
import java.util.Date;

import com.rns.testes.java.model.Produto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProdutoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int id;
    private String nome;
    private int versao;
    private Date date;
	
	public ProdutoDTO(Produto entity) {
		
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.versao = entity.getVersao();
		this.date = entity.getDataUltAlteracao1();
		
	}
    
	
    
}
