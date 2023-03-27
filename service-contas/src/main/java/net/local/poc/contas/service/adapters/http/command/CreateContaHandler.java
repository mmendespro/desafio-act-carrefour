package net.local.poc.contas.service.adapters.http.command;

import org.springframework.stereotype.Component;

import net.local.poc.contas.service.application.ports.usecases.CreateContaUseCase;
import net.local.poc.library.cqrs.Handler;

@Component
public class CreateContaHandler implements Handler<CreateContaCommand>{

    private final CreateContaUseCase createContaUseCase;

    public CreateContaHandler(CreateContaUseCase createContaUseCase) {
        this.createContaUseCase = createContaUseCase;
    }

    @Override
    public void handle(CreateContaCommand command) {
        createContaUseCase.create(
            command.getContaId(), 
            command.getContaNome(), 
            command.getTipo(),
            command.getContaPai()
        );
    }
}
