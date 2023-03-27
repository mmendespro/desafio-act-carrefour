package net.local.poc.contas.service.adapters.persistence.mappers;

import net.local.poc.contas.service.adapters.persistence.model.ContaJPA;
import net.local.poc.contas.service.application.domain.Conta;
import net.local.poc.contas.service.application.domain.Tipo;

public class ContaMapper {
    
    public static Conta mapToDomain(ContaJPA contaJPA) {
        return Conta.builder()
                    .contaId(contaJPA.getContaId())
                    .contaNome(contaJPA.getContaNome())
                    .contaPai(contaJPA.getContaPai())
                    .tipo(Tipo.valueOf(contaJPA.getTipo()))
                    .build();
    }

    public static ContaJPA mapToJPA(Conta conta) {
        return ContaJPA.builder()
                       .contaId(conta.getContaId())
                       .contaNome(conta.getContaNome())
                       .contaPai(conta.getContaPai())
                       .tipo(conta.getTipo().name())
                       .build();
    }
}
