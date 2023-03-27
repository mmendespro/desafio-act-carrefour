package net.local.poc.lancamentos.service.adapters.http.query.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReportDiarioResponse {
    
    private float totalReport;
    private float saldoAnterior;
    private float totalDiario;
    private LocalDate diaReport;
    private List<LancamentoResponse> lancamentos;
}
