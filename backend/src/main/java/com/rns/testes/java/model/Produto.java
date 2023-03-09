package com.rns.testes.java.model;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tb_produto")
public class Produto extends GenericEntity{
	private static final long serialVersionUID = 1L;
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//para ser auto incremento
    private int id;

    @Column
    private String nome;
    

}
