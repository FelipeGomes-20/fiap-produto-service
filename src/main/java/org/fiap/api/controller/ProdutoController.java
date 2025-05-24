package org.fiap.api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.fiap.api.controller.json.ProdutoJson;
import org.fiap.api.domain.Produto;
import org.fiap.api.usecase.CadastrarProdutoUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final CadastrarProdutoUseCase cadastrarProduto;

    @PostMapping
    public ResponseEntity<Produto> cadastrarCliente(@Valid @RequestBody ProdutoJson produtoJson) {
        Produto produtoSalvo = cadastrarProduto.cadastrarProduto(mapToDomain(produtoJson));
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvo);
    }

    private Produto mapToDomain(ProdutoJson json) {
        return new Produto(
                null,
                json.getNome(),
                json.getSku(),
                json.getPreco()
        );
    }

    private ProdutoJson mapToJson(Produto produto) {
        return new ProdutoJson(
                produto.getNome(),
                produto.getSku(),
                produto.getPreco()
        );
    }

}
