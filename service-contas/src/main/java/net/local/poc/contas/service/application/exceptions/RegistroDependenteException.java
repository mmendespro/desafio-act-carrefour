package net.local.poc.contas.service.application.exceptions;

public class RegistroDependenteException extends RuntimeException {

    public RegistroDependenteException() {
        super("Existem registros que dependem desta conta");
    }
    
}
