package net.local.poc.contas.service.adapters.http.command;

import org.springframework.stereotype.Component;

import net.local.poc.contas.service.application.ports.usecases.DeleteContaUseCase;
import net.local.poc.library.cqrs.Handler;

@Component
public class DeleteContaHandler implements Handler<DeleteContaCommand> {
    
    private final DeleteContaUseCase deleteContaUseCase;

    public DeleteContaHandler(DeleteContaUseCase deleteContaUseCase) {
        this.deleteContaUseCase = deleteContaUseCase;
    }

    @Override
    public void handle(DeleteContaCommand command) {
        deleteContaUseCase.delete(command.getContaId());
    }
}
