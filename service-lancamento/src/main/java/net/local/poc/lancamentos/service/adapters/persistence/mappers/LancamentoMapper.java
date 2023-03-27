package net.local.poc.lancamentos.service.adapters.persistence.mappers;

import net.local.poc.lancamentos.service.adapters.persistence.model.LancamentoJPA;
import net.local.poc.lancamentos.service.application.domain.Lancamento;
import net.local.poc.lancamentos.service.application.domain.Tipo;

public class LancamentoMapper {
    
    public static Lancamento mapToDomain(LancamentoJPA lancamentoJPA) {
        if(lancamentoJPA == null) {
            return null;
        }
        return Lancamento.builder()
                         .lancamentoId(lancamentoJPA.getLancamentoId())
                         .lancamentoData(lancamentoJPA.getLancamentoData())
                         .tipo(Tipo.valueOf(lancamentoJPA.getTipo()))
                         .valor(lancamentoJPA.getValor())
                         .contaId(lancamentoJPA.getContaId()).build();
    }

    public static LancamentoJPA mapToEntity(Lancamento lancamento) {
        if(lancamento == null) {
            return null;
        }
        return LancamentoJPA.builder()
                            .lancamentoId(lancamento.getLancamentoId())
                            .lancamentoData(lancamento.getLancamentoData())
                            .tipo(lancamento.getTipo().name())
                            .valor(lancamento.getValor())
                            .contaId(lancamento.getContaId()).build();
    }
}
