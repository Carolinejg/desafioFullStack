package com.rns.testes.java.dto;

import java.io.Serializable;


import com.rns.testes.java.model.ControleEstoque;
import com.rns.testes.java.model.Filial;
import com.rns.testes.java.model.Produto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ControleEstoqueDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public int id;
	public Produto produto;
	public Filial filial;
	int quantidade;
	
	public ControleEstoqueDTO(ControleEstoque entity) {
		this.id = entity.getId();
		this.produto = entity.getProduto();
		this.filial = entity.getFilial();
		this.quantidade = entity.getQuantidade();
		
		
	}

}
