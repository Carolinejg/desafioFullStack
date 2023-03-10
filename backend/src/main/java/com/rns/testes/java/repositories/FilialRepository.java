package com.rns.testes.java.repositories;

import com.rns.testes.java.model.Filial;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface representa a camada de persistência da entidade Filial. Deve ser injetada <b>exclusivamente</b> em uma
 * camada service.
 */
public interface FilialRepository extends JpaRepository<Filial, Integer> {

}
