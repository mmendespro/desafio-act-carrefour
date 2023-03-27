package net.local.poc.contas.service.adapters.http.command;

import org.springframework.stereotype.Component;

import net.local.poc.contas.service.application.ports.usecases.UpdateContaUseCase;
import net.local.poc.library.cqrs.Handler;

@Component
public class UpdateContaHandler implements Handler<UpdateContaCommand> {
    
    private final UpdateContaUseCase updateContaUseCase;

    public UpdateContaHandler(UpdateContaUseCase updateContaUseCase) {
        this.updateContaUseCase = updateContaUseCase;
    }

    @Override
    public void handle(UpdateContaCommand command) {
        updateContaUseCase.update(
            command.getContaId(), 
            command.getContaNome(), 
            command.getTipo(),
            command.getContaPai()
        );
    }
}
