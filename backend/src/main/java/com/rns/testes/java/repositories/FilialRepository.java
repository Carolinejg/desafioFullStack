package com.rns.testes.java.repositories;

import com.rns.testes.java.enums.EnumTipoFilial;
import com.rns.testes.java.model.Filial;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface representa a camada de persistência da entidade Filial. Deve ser injetada <b>exclusivamente</b> em uma
 * camada service.
 */
public interface FilialRepository extends JpaRepository<Filial, Integer> {
	/*@Query("FROM tb_filial obj where obj.tipoFilial=:id")
	List<Filial> findAll(EnumTipoFilial id);*/
}
