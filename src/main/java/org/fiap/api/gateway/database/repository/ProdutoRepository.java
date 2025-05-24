package org.fiap.api.gateway.database.repository;

import org.fiap.api.gateway.database.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {
    Optional<ProdutoEntity> findBySku(String sku);
}
