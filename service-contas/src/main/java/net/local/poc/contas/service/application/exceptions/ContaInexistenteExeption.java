package net.local.poc.contas.service.application.exceptions;

public class ContaInexistenteExeption extends RuntimeException {

    public ContaInexistenteExeption() {
        super("Conta não existe");
    }
    
}
