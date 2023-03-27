package net.local.poc.contas.service.application.services;

import net.local.poc.contas.service.application.domain.Conta;
import net.local.poc.contas.service.application.domain.Tipo;
import net.local.poc.contas.service.application.exceptions.ContaExistenteException;
import net.local.poc.contas.service.application.exceptions.ContaInexistenteExeption;
import net.local.poc.contas.service.application.exceptions.RegistroDependenteException;
import net.local.poc.contas.service.application.ports.persistence.DeleteContaPort;
import net.local.poc.contas.service.application.ports.persistence.LoadContaPort;
import net.local.poc.contas.service.application.ports.persistence.SaveContaPort;
import net.local.poc.contas.service.application.ports.usecases.CreateContaUseCase;
import net.local.poc.contas.service.application.ports.usecases.DeleteContaUseCase;
import net.local.poc.contas.service.application.ports.usecases.UpdateContaUseCase;

public class ContaManager implements CreateContaUseCase, UpdateContaUseCase, DeleteContaUseCase {
    
    private final LoadContaPort loadContaPort;
    private final SaveContaPort saveContaPort;
    private final DeleteContaPort deleteContaPort;

    public ContaManager(LoadContaPort loadContaPort, SaveContaPort saveContaPort, DeleteContaPort deleteContaPort) {
        this.loadContaPort = loadContaPort;
        this.saveContaPort = saveContaPort;
        this.deleteContaPort = deleteContaPort;
    }

    @Override
    public void create(String contaId, String contaNome, String tipo, String contaPai) {
        loadContaPort.load(contaId).ifPresent(conta -> {throw new ContaExistenteException();});

        var conta = Conta.builder()
                         .contaId(contaId)
                         .contaNome(contaNome)
                         .contaPai(contaPai)
                         .tipo(Tipo.valueOf(tipo))
                         .build();
        
        saveContaPort.save(conta);
    }

    @Override
    public void update(String contaId, String contaNome, String tipo, String contaPai) {
        loadContaPort.load(contaId).orElseThrow(ContaInexistenteExeption::new);

        var conta = Conta.builder()
                         .contaId(contaId)
                         .contaNome(contaNome)
                         .contaPai(contaPai)
                         .tipo(Tipo.valueOf(tipo))
                         .build();
        
        saveContaPort.save(conta);
    }

    @Override
    public void delete(String contaId) {
        loadContaPort.load(contaId).orElseThrow(ContaInexistenteExeption::new);

        if(loadContaPort.loadByContaPai(contaId).size() > 0) {
            throw new RegistroDependenteException();
        }
        
        deleteContaPort.delete(contaId);
    }
}
