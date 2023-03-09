package com.rns.testes.java.dto;

import java.io.Serializable;

import com.rns.testes.java.enums.EnumTipoFilial;

public class FilialDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
    private String razaoSocial;
    private String cnpj;
    private String endereco;
    private EnumTipoFilial tipoFilial;
    
    
	public FilialDTO() {
		super();
	}
    
    
    

}
