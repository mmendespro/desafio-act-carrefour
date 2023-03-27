package net.local.poc.contas.service.application.ports.usecases;

public interface CreateContaUseCase {
    void create(String contaId, String contaNome, String tipo, String contaPai);
}
