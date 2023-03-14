package com.rns.testes.java.dto;

import java.io.Serializable;
import java.util.Date;

import com.rns.testes.java.enums.EnumTipoFilial;
import com.rns.testes.java.model.Filial;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public class FilialDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int id;
    private String razaoSocial;
    private String cnpj;
    private String endereco;
    private EnumTipoFilial tipoFilial;
    private int versao;
    private Date date;
    
    
	public FilialDTO(Filial entity) {
		this.id = entity.getId();
		this.razaoSocial = entity.getRazaoSocial();
		this.cnpj = entity.getCnpj();
		this.endereco = entity.getEndereco();
		this.tipoFilial = entity.getTipoFilial();
		this.versao =  entity.getVersao();
		this.date = entity.getDataUltAlteracao1();
			
	}    
    
    

}
