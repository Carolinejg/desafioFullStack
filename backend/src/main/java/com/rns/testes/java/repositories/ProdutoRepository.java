package com.rns.testes.java.repositories;

import com.rns.testes.java.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface representa a camada de persistência da entidade Produto. Deve ser injetada <b>exclusivamente</b> em uma
 * camada service.
 */
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
