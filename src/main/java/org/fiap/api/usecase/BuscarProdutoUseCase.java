package org.fiap.api.usecase;

import lombok.RequiredArgsConstructor;
import org.fiap.api.domain.Produto;
import org.fiap.api.gateway.ProdutoGateway;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class BuscarProdutoUseCase {
    private final ProdutoGateway produtoGateway;

// Sei que seria um UseCase pra cada, mas reduzi por serem buscas simples

    public List<Produto> listarTodosProdutos(){
        return produtoGateway.listarTodos();
    }

    public Optional<Produto> buscarProdutoSku(String sku){
        return produtoGateway.buscarPorSku(sku);
    }

    public Optional<Produto> buscarProdutoId(Long id){
        return produtoGateway.buscarPorId(id);
    }
}
