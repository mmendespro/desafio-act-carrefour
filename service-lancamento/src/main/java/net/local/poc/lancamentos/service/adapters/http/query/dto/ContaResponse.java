package net.local.poc.lancamentos.service.adapters.http.query.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContaResponse {
    private String contaNome;
    private String tipo;
}
