package com.rns.testes.java.repositories;

import com.rns.testes.java.enums.EnumTipoFilial;
import com.rns.testes.java.model.Filial;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * Interface representa a camada de persistência da entidade Filial. Deve ser
 * injetada <b>exclusivamente</b> em uma camada service.
 */
public interface FilialRepository extends JpaRepository<Filial, Integer> {
	/*@Query("SELECT f FROM Filial f WHERE f.tipoFilial = :tipoFilial ")
	List<Filial> findAllTipoFilial(@Param("tipoFilial")int tipoFilial);*/
}
