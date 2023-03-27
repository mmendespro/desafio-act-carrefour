package net.local.poc.lancamentos.service.adapters.http.command;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import net.local.poc.library.cqrs.Command;
import net.local.poc.library.cqrs.validation.SelfValidating;

public class CreateLancamentoCommand extends SelfValidating<CreateLancamentoCommand> implements Command {

    @NotBlank
    private final String lancamentoId;

    @NotNull
    private final LocalDate lancamentoData;
    
    @NotBlank
    private String contaId;

    @NotNull
    private final float valor;

    public CreateLancamentoCommand(String lancamentoId, LocalDate lancamentoData, String contaId, float valor) {
        this.lancamentoId = lancamentoId;
        this.lancamentoData = lancamentoData;
        this.contaId = contaId;
        this.valor = valor;
        validateSelf(this);
    }

    public String getLancamentoId() {
        return lancamentoId;
    }

    public LocalDate getLancamentoData() {
        return lancamentoData;
    }

    public String getContaId() {
        return contaId;
    }

    public float getValor() {
        return valor;
    }

}
