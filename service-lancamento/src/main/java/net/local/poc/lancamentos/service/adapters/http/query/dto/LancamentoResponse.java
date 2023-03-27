package net.local.poc.lancamentos.service.adapters.http.query.dto;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LancamentoResponse {
    private String lancamentoId;
    private LocalDate lancamentoData;
    private String tipo;
    private ContaResponse conta;
    private float valor;
}
