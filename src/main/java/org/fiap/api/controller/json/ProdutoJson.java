package org.fiap.api.controller.json;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoJson {

    @NotBlank(message = "Nome é obrigatório.")
    private String nome;

    @NotBlank(message = "SKU é obrigatório.")
    private String sku;

    @NotNull(message = "Preço é obrigatório.")
    private float preco;
}
