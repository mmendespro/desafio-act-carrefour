package net.local.poc.lancamentos.service.application.exceptions;

public class ContaNaoEncontradaException extends RuntimeException {

    public ContaNaoEncontradaException() {
        super("Conta não encontrada");
    }
    
}
