package net.local.poc.lancamentos.service.application.services;

import java.time.LocalDate;

import net.local.poc.lancamentos.service.application.domain.Lancamento;
import net.local.poc.lancamentos.service.application.exceptions.ContaNaoEncontradaException;
import net.local.poc.lancamentos.service.application.exceptions.LancamentoExistenteException;
import net.local.poc.lancamentos.service.application.exceptions.LancamentoNaoEncontradoException;
import net.local.poc.lancamentos.service.application.ports.client.LoadContaPort;
import net.local.poc.lancamentos.service.application.ports.persistence.DeleteLancamentoPort;
import net.local.poc.lancamentos.service.application.ports.persistence.LoadLancamentoPort;
import net.local.poc.lancamentos.service.application.ports.persistence.SaveLancamentoPort;
import net.local.poc.lancamentos.service.application.ports.usecases.CreateLancamentoUseCase;
import net.local.poc.lancamentos.service.application.ports.usecases.DeleteLancamentoUseCase;

public class LancamentoService implements CreateLancamentoUseCase, DeleteLancamentoUseCase {
    
    private final LoadContaPort loadContaPort;
    private final LoadLancamentoPort loadLancamentoPort;
    private final SaveLancamentoPort saveLancamentoPort;
    private final DeleteLancamentoPort deleteLancamentoPort;

    public LancamentoService(LoadContaPort loadContaPort, LoadLancamentoPort loadLancamentoPort, SaveLancamentoPort saveLancamentoPort, DeleteLancamentoPort deleteLancamentoPort) {
        this.loadContaPort = loadContaPort;
        this.loadLancamentoPort = loadLancamentoPort;
        this.saveLancamentoPort = saveLancamentoPort;
        this.deleteLancamentoPort = deleteLancamentoPort;
    }

    @Override
    public void create(String lancamentoId, LocalDate lancamentoData, String contaId, float valor) {
        loadLancamentoPort.load(lancamentoId).ifPresent(lanc -> { throw new LancamentoExistenteException(); });

        var conta = loadContaPort.load(contaId).orElseThrow(ContaNaoEncontradaException::new);

        var lancamento = Lancamento.builder()
                                   .lancamentoId(lancamentoId)
                                   .lancamentoData(lancamentoData)
                                   .tipo(conta.getTipo())
                                   .contaId(conta.getContaId())
                                   .valor(valor).build();

        saveLancamentoPort.save(lancamento);
    }

    @Override
    public void delete(String lancamentoId) {
        loadLancamentoPort.load(lancamentoId).orElseThrow(LancamentoNaoEncontradoException::new);

        deleteLancamentoPort.delete(lancamentoId);
    }
}
