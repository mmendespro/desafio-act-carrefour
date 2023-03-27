package net.local.poc.lancamentos.service.application.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Conta {
    private String contaId;
    private String contaNome;
    private Tipo tipo;
    private String contaPai;
    private List<Conta> subcontas;
}
