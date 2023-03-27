package net.local.poc.lancamentos.service.adapters.persistence.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "lancamentos")
public class LancamentoJPA {
    
    @Id
    @Column(name = "PK_LANCAMENTO", nullable = false)
    private String lancamentoId;

    @Column(name = "DT_LANCAMENTO", nullable = false, columnDefinition = "DATE")
    private LocalDate lancamentoData;

    @Column(name = "TP_LANCAMENTO", nullable = false)
    private String tipo;

    @Column(name = "FK_CONTA", nullable = false)
    private String contaId;

    @Column(name = "VL_VALOR", nullable = false, scale = 10, precision = 2)
    private float valor;
}
