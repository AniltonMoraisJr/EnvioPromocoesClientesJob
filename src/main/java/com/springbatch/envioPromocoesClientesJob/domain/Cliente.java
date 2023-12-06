package com.springbatch.envioPromocoesClientesJob.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Cliente {
    private int id;
    private String nome;
    private String email;
}
