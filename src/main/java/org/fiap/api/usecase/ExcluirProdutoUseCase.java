package org.fiap.api.usecase;

import lombok.RequiredArgsConstructor;
import org.fiap.api.gateway.ProdutoGateway;

@RequiredArgsConstructor
public class ExcluirProdutoUseCase {
    private final ProdutoGateway produtoGateway;

    public void excluirProduto(Long id) {
        produtoGateway.excluir(id);
    }
}
