package org.fiap.api.gateway;

import org.fiap.api.domain.Produto;

import java.util.List;
import java.util.Optional;

public interface ProdutoGateway {
    Produto salvar(Produto produto);
    Produto atualizar(Produto produto);
    void excluir(Long id);
    List<Produto> listarTodos();
    Optional<Produto> buscarPorSku(String sku);
    Optional<Produto> buscarPorId(Long id);
}
