package net.local.poc.contas.service.adapters.http.query.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ContaDetailResponse {
    private String contaId;
    private String contaNome;
    private String tipo;
    private List<ContaDetailResponse> subcontas;
}
