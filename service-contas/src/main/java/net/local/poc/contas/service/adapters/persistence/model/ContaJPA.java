package net.local.poc.contas.service.adapters.persistence.model;

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
@Table(name = "contas")
public class ContaJPA {
    
    @Id
    @Column(name = "PK_CONTA", nullable = false)
    private String contaId;

    @Column(name = "DS_CONTA", nullable = false)
    private String contaNome;

    @Column(name = "TP_CONTA", nullable = false)
    private String tipo;

    @Column(name = "FK_CONTA")
    private String contaPai;
}
