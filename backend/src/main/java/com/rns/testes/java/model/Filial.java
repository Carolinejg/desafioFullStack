package com.rns.testes.java.model;

import com.rns.testes.java.enums.EnumTipoFilial;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tb_filial")
public class Filial extends GenericEntity{
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String razaoSocial;

    
    @Column
    private String cnpj;

    @Column
    private String endereco;

    @Column
    private EnumTipoFilial tipoFilial;

}
