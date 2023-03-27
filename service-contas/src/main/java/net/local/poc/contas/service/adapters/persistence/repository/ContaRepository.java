package net.local.poc.contas.service.adapters.persistence.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import net.local.poc.contas.service.adapters.persistence.mappers.ContaMapper;
import net.local.poc.contas.service.application.domain.Conta;
import net.local.poc.contas.service.application.ports.persistence.DeleteContaPort;
import net.local.poc.contas.service.application.ports.persistence.LoadContaPort;
import net.local.poc.contas.service.application.ports.persistence.SaveContaPort;

public class ContaRepository implements LoadContaPort, SaveContaPort, DeleteContaPort {

    private final ContaH2Repository repository;

    public ContaRepository(ContaH2Repository repo) {
        this.repository = repo;
    }

    @Override
    public Optional<Conta> load(String contaId) {
        var contaJPA = repository.findById(contaId);
        if(contaJPA.isPresent()) {
            return Optional.of(ContaMapper.mapToDomain(contaJPA.get()));
        }
        return Optional.empty();
    }

    @Override
    public List<Conta> loadByContaPai(String contaPai) {
        return repository.findByContaPai(contaPai).stream().map(contaJPA -> ContaMapper.mapToDomain(contaJPA)).collect(Collectors.toList());
    }

    @Override
    public void save(Conta conta) {
        repository.save(ContaMapper.mapToJPA(conta));
    }

    @Override
    public void delete(String contaId) {
        repository.deleteById(contaId);
    }
}
