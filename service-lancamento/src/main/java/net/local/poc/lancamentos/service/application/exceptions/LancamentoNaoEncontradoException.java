package net.local.poc.lancamentos.service.application.exceptions;

public class LancamentoNaoEncontradoException extends RuntimeException {

    public LancamentoNaoEncontradoException() {
        super("Lancamento não encontrado");
    }
    
}
