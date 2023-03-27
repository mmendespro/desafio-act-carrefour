package net.local.poc.contas.service.application.exceptions;

public class ContaExistenteException extends RuntimeException {

    public ContaExistenteException() {
        super("Conta já cadastrada");
    }
}
