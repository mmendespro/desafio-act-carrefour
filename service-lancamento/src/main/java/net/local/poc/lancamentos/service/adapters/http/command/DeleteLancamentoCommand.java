package net.local.poc.lancamentos.service.adapters.http.command;

import javax.validation.constraints.NotBlank;

import net.local.poc.library.cqrs.Command;
import net.local.poc.library.cqrs.validation.SelfValidating;

public class DeleteLancamentoCommand extends SelfValidating<DeleteLancamentoCommand> implements Command {
    
    @NotBlank
    private final String lancamentoId;

    public DeleteLancamentoCommand(String lancamentoId) {
        this.lancamentoId = lancamentoId;
    }

    public String getLancamentoId() {
        return lancamentoId;
    }

}
