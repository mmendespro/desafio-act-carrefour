package net.local.poc.lancamentos.service.adapters.http.command;

import org.springframework.stereotype.Component;

import net.local.poc.lancamentos.service.application.ports.usecases.DeleteLancamentoUseCase;
import net.local.poc.library.cqrs.Handler;

@Component
public class DeleteLancamentoHandler implements Handler<DeleteLancamentoCommand> {
    
    private final DeleteLancamentoUseCase deleteLancamentoUseCase;

    public DeleteLancamentoHandler(DeleteLancamentoUseCase deleteLancamentoUseCase) {
        this.deleteLancamentoUseCase = deleteLancamentoUseCase;
    }

    @Override
    public void handle(DeleteLancamentoCommand command) {
        deleteLancamentoUseCase.delete(command.getLancamentoId());
    }
}
