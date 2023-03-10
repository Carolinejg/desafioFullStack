package com.rns.testes.java.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@MappedSuperclass
public abstract class GenericEntity implements Serializable{
	private static final long serialVersionUID = 1L;

	
	@Version
	@Column(name = "VERSAO", unique = false, nullable = false, precision = 10)
	protected int versao;
	@Column
	protected Date dataUltAlteracao1;
	
	/*@UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_ULT_ALTERACAO", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    protected Date dataUltAlteracao;*/
}
