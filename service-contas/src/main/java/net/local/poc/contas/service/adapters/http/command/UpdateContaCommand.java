package net.local.poc.contas.service.adapters.http.command;

import javax.validation.constraints.NotBlank;

import net.local.poc.library.cqrs.Command;
import net.local.poc.library.cqrs.validation.SelfValidating;

public class UpdateContaCommand extends SelfValidating<UpdateContaCommand> implements Command {
    
    @NotBlank
    private final String contaId;

    @NotBlank
    private final String contaNome;

    @NotBlank
    private final String tipo;

    private final String contaPai;

    public UpdateContaCommand(String contaId, String contaNome, String tipo, String contaPai) {
        this.contaId = contaId;
        this.contaNome = contaNome;
        this.tipo = tipo;
        this.contaPai = contaPai;
        validateSelf(this);
    }

    public String getContaId() {
        return contaId;
    }

    public String getContaNome() {
        return contaNome;
    }

    public String getTipo() {
        return tipo;
    }

    public String getContaPai() {
        return contaPai;
    }

}
