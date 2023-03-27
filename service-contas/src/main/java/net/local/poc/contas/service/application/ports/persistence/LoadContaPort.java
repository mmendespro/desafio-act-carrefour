package net.local.poc.contas.service.application.ports.persistence;

import java.util.List;
import java.util.Optional;

import net.local.poc.contas.service.application.domain.Conta;

public interface LoadContaPort {
    Optional<Conta> load(String contaId);
    List<Conta> loadByContaPai(String contaPai);
}
