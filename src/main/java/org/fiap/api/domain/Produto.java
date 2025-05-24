package org.fiap.api.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class Produto {
    private Long id;
    private String nome;
    private String sku;
    private float preco;
}
