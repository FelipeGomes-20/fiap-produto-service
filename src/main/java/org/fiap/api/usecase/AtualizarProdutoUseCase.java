package org.fiap.api.usecase;

import lombok.RequiredArgsConstructor;
import org.fiap.api.domain.Produto;
import org.fiap.api.gateway.ProdutoGateway;

@RequiredArgsConstructor
public class AtualizarProdutoUseCase {
    private final ProdutoGateway produtoGateway;

    public Produto atualizarCliente(Produto produto) {
        return produtoGateway.atualizar(produto);
    }
}
