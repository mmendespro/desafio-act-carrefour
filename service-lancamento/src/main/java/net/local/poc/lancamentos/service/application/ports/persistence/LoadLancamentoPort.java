package net.local.poc.lancamentos.service.application.ports.persistence;

import java.util.Optional;

import net.local.poc.lancamentos.service.application.domain.Lancamento;

public interface LoadLancamentoPort {
    Optional<Lancamento> load(String lancamentoId);
}
