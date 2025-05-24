package org.fiap.api.config;

import org.fiap.api.gateway.ProdutoGateway;
import org.fiap.api.usecase.CadastrarProdutoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProdutoConfig {

    @Bean
    CadastrarProdutoUseCase cadastrarClienteUseCase(ProdutoGateway cliente) {
        return new CadastrarProdutoUseCase(cliente);
    }

}
