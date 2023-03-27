package net.local.poc.contas.service.adapters.http.command;

import javax.validation.constraints.NotBlank;

import net.local.poc.library.cqrs.Command;
import net.local.poc.library.cqrs.validation.SelfValidating;

public class DeleteContaCommand extends SelfValidating<DeleteContaCommand> implements Command {
    
    @NotBlank
    private final String contaId;

    public DeleteContaCommand(String contaId) {
        this.contaId = contaId;
        validateSelf(this);
    }

    public String getContaId() {
        return contaId;
    }

}
