package net.local.poc.lancamentos.service.adapters.http.clients;

import java.util.Optional;

import org.springframework.stereotype.Component;

import net.local.poc.lancamentos.service.application.domain.Conta;
import net.local.poc.lancamentos.service.application.ports.client.LoadContaPort;

@Component
public class LoadContaPortImpl implements LoadContaPort {

    private final ContaClient client;

    public LoadContaPortImpl(ContaClient client) {
        this.client = client;
    }

    @Override
    public Optional<Conta> load(String contaId) {
        var result = client.buscar(contaId);
        return Optional.ofNullable(result.getBody());
    }
}
