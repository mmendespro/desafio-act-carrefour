package net.local.poc.contas.service.adapters.http.api;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.local.poc.contas.service.adapters.http.query.DetailContaQuery;
import net.local.poc.contas.service.adapters.http.query.dto.ContaDetailResponse;
import net.local.poc.library.cqrs.ServiceBus;

@RestController
@RequestMapping("/v1/contas")
@ConditionalOnProperty(prefix = "cqrs", name = "read", havingValue = "true")
public class ContaReadController {
    
    private final ServiceBus serviceBus;

    public ContaReadController(ServiceBus serviceBus) {
        this.serviceBus = serviceBus;
    }

    @GetMapping(path = "/{contaId}")
    public ResponseEntity<ContaDetailResponse> detail(@Valid @NotNull @PathVariable(name = "contaId") String contaId) {
        var query = new DetailContaQuery(contaId);
        serviceBus.execute(query);
        return ResponseEntity.ok(query.getResponse());
    }

}
