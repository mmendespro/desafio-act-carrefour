package net.local.poc.lancamentos.service.adapters.http.api;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.local.poc.lancamentos.service.adapters.http.command.CreateLancamentoCommand;
import net.local.poc.lancamentos.service.adapters.http.command.DeleteLancamentoCommand;
import net.local.poc.library.cqrs.ServiceBus;

@RestController
@RequestMapping("/v1/lancamentos")
@ConditionalOnProperty(prefix = "cqrs", name = "write", havingValue = "true")
public class LancamentoWriteController {
    
    private final ServiceBus serviceBus;

    public LancamentoWriteController(ServiceBus serviceBus) {
        this.serviceBus = serviceBus;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody CreateLancamentoCommand command) {
        serviceBus.execute(command);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping(path = "/{lancamentoId}")
    public ResponseEntity<String> delete(@Valid @NotNull @PathVariable(name = "lancamentoId") String lancamentoId) {
        serviceBus.execute(new DeleteLancamentoCommand(lancamentoId));
        return ResponseEntity.noContent().build();
    }
}
