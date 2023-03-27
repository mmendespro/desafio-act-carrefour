package net.local.poc.contas.service.application.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Conta {
    private String contaId;
    private String contaNome;
    private Tipo tipo;
    private String contaPai;
}
