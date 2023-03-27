package net.local.poc.lancamentos.service.application.ports.persistence;

import net.local.poc.lancamentos.service.application.domain.Lancamento;

public interface SaveLancamentoPort {
    void save(Lancamento lancamento);
}
