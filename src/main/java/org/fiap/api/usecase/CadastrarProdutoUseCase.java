package org.fiap.api.usecase;

import lombok.RequiredArgsConstructor;
import org.fiap.api.domain.Produto;
import org.fiap.api.exception.ProdutoExistenteException;
import org.fiap.api.gateway.ProdutoGateway;

@RequiredArgsConstructor
public class CadastrarProdutoUseCase {

    private final ProdutoGateway produtoGateway;

    public Produto cadastrarProduto(Produto produto) {

        if (produtoGateway.buscarPorSku(produto.getSku()).isPresent()) {
            throw new ProdutoExistenteException("Produto com SKU: "+ produto.getSku() +" já existe.");
        }

        return produtoGateway.salvar(produto);
    }
}
