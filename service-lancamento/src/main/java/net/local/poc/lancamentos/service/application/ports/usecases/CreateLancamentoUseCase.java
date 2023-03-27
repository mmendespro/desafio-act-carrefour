package net.local.poc.lancamentos.service.application.ports.usecases;

import java.time.LocalDate;

public interface CreateLancamentoUseCase {
    void create(String lancamentoId, LocalDate lancamentoData, String contaId, float valor);
}
