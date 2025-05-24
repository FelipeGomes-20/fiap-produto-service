package org.fiap.api.gateway.database;

import lombok.RequiredArgsConstructor;
import org.fiap.api.domain.Produto;
import org.fiap.api.gateway.ProdutoGateway;
import org.fiap.api.gateway.database.entity.ProdutoEntity;
import org.fiap.api.gateway.database.repository.ProdutoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProdutoJpaGateway implements ProdutoGateway {

    private final ProdutoRepository produtoRepository;


    @Override
    public Produto salvar(Produto produto) {
        ProdutoEntity entity = toEntity(produto);
        ProdutoEntity saved = produtoRepository.save(entity);
        return toDomain(saved);
    }

    @Override
    public Produto atualizar(Produto produto) {
        ProdutoEntity entity = toEntity(produto);
        ProdutoEntity saved = produtoRepository.save(entity);
        return toDomain(saved);
    }

    @Override
    public void excluir(Long id) {
        produtoRepository.deleteById(id);
    }

    @Override
    public List<Produto> listarTodos() {
        //return produtoRepository.findAll().stream().map(this::toDomain);
        return null;
    }

    @Override
    public Optional<Produto> buscarPorSku(String sku) {
        return produtoRepository.findBySku(sku).map(this::toDomain);
    }

    @Override
    public Optional<Produto> buscarPorId(Long id) {
        return produtoRepository.findById(id).map(this::toDomain);
    }

    private ProdutoEntity toEntity(Produto produto) {
        ProdutoEntity entity = ProdutoEntity.builder()
                .id(produto.getId())
                .nome(produto.getNome())
                .sku(produto.getSku())
                .preco(produto.getPreco())
                .build();
        return entity;
    }

    private Produto toDomain(ProdutoEntity entity) {
        return new Produto(entity.getId(), entity.getNome(), entity.getSku(), entity.getPreco());
    }
}
