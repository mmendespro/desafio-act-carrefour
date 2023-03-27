package net.local.poc.lancamentos.service.adapters.persistence.repository;

import java.util.Optional;

import org.springframework.stereotype.Component;

import net.local.poc.lancamentos.service.adapters.persistence.mappers.LancamentoMapper;
import net.local.poc.lancamentos.service.application.domain.Lancamento;
import net.local.poc.lancamentos.service.application.ports.persistence.DeleteLancamentoPort;
import net.local.poc.lancamentos.service.application.ports.persistence.LoadLancamentoPort;
import net.local.poc.lancamentos.service.application.ports.persistence.SaveLancamentoPort;

@Component
public class LancamentoRepository implements LoadLancamentoPort, SaveLancamentoPort, DeleteLancamentoPort {

    private final LancamentoJpaRepository repo;

    public LancamentoRepository(LancamentoJpaRepository repo) {
        this.repo = repo;
    }

    @Override
    public Optional<Lancamento> load(String lancamentoId) {
        var lancamentoOPT = repo.findById(lancamentoId);
        if(lancamentoOPT.isPresent()) {
            return Optional.ofNullable(LancamentoMapper.mapToDomain(lancamentoOPT.get()));
        }
        return Optional.empty();
    }

    @Override
    public void save(Lancamento lancamento) {
        repo.save(LancamentoMapper.mapToEntity(lancamento));
    }
        
    @Override
    public void delete(String lancamentoId) {
        repo.deleteById(lancamentoId);
    }
}
