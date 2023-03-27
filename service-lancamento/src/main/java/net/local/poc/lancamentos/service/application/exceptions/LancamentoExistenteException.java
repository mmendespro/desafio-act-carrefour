package net.local.poc.lancamentos.service.application.exceptions;

public class LancamentoExistenteException extends RuntimeException {

    public LancamentoExistenteException() {
        super("Lancamento ja existe");
    }
    
}
