package net.local.poc.lancamentos.service.adapters.http.command;

import org.springframework.stereotype.Component;

import net.local.poc.lancamentos.service.application.ports.usecases.CreateLancamentoUseCase;
import net.local.poc.library.cqrs.Handler;

@Component
public class CreateLancamentoHandler implements Handler<CreateLancamentoCommand> {

    private final CreateLancamentoUseCase createLancamentoUseCase;

    public CreateLancamentoHandler(CreateLancamentoUseCase createLancamentoUseCase) {
        this.createLancamentoUseCase = createLancamentoUseCase;
    }

    @Override
    public void handle(CreateLancamentoCommand command) {
        createLancamentoUseCase.create(
            command.getLancamentoId(), 
            command.getLancamentoData(), 
            command.getContaId(), 
            command.getValor()
        );
    }
    
}
