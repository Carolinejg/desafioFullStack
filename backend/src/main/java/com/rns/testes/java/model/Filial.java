package com.rns.testes.java.model;

import com.rns.testes.java.enums.EnumTipoFilial;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.validator.constraints.br.CNPJ;

import java.io.Serializable;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tb_filial")
public class Filial extends GenericEntity{
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String razaoSocial;

    @CNPJ
    @Column
    private String cnpj;

    @Column
    private String endereco;

    @Column
    private EnumTipoFilial tipoFilial;

}
