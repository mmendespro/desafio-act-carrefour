package net.local.poc.contas.service.application.ports.persistence;

import net.local.poc.contas.service.application.domain.Conta;

public interface SaveContaPort {
    void save(Conta conta);
}
