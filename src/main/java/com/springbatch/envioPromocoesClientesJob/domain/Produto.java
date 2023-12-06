package com.springbatch.envioPromocoesClientesJob.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Produto {
    private int id;
    private String nome;
    private String descricao;
    private Double preco;
}
