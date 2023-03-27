package net.local.poc.lancamentos.service.application.ports.client;

import java.util.Optional;

import net.local.poc.lancamentos.service.application.domain.Conta;

public interface LoadContaPort {
    Optional<Conta> load(String contaId);
}
