package net.local.poc.lancamentos.service.application.domain;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Lancamento {
    private String lancamentoId;
    private LocalDate lancamentoData;
    private Tipo tipo;
    private String contaId;
    private float valor;
}
