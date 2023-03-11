package com.rns.testes.java.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.rns.testes.java.dto.ControleEstoqueDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tb_controle_estoque")
public class ControleEstoque {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	
	@ManyToOne
	@JoinColumn(nullable = false)
    public Produto produto;
	
	@ManyToOne 
	@JoinColumn(nullable = false)
    public Filial filial;
	
	@Column
	int quantidade;

	
}
