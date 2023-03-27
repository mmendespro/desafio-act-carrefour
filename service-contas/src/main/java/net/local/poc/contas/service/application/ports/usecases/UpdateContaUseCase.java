package net.local.poc.contas.service.application.ports.usecases;

public interface UpdateContaUseCase {
    void update(String contaId, String contaNome, String tipo, String contaPai);
}
