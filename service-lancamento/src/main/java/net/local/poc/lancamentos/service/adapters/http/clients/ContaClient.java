package net.local.poc.lancamentos.service.adapters.http.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import net.local.poc.lancamentos.service.application.domain.Conta;

@FeignClient(name = "service-conta", url = "${client.contas.baseUrl}")
public interface ContaClient {
    
    @GetMapping( "/v1/contas/{contaId}")
    ResponseEntity<Conta> buscar(@PathVariable String contaId);
}
