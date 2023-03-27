package net.local.poc.contas.service.adapters.http.api;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.local.poc.contas.service.adapters.http.command.CreateContaCommand;
import net.local.poc.contas.service.adapters.http.command.DeleteContaCommand;
import net.local.poc.contas.service.adapters.http.command.UpdateContaCommand;
import net.local.poc.library.cqrs.ServiceBus;

@RestController
@RequestMapping("/v1/contas")
@ConditionalOnProperty(prefix = "cqrs", name = "write", havingValue = "true")
public class ContaWriteController {
    
    private final ServiceBus serviceBus;

    public ContaWriteController(ServiceBus serviceBus) {
        this.serviceBus = serviceBus;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody CreateContaCommand command) {
        serviceBus.execute(command);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping(path = "/{contaId}")
    public ResponseEntity<String> update(@Valid @NotNull @PathVariable(name = "contaId") String contaId, @RequestBody UpdateContaCommand command) {
        serviceBus.execute(command);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path = "/{contaId}")
    public ResponseEntity<String> delete(@Valid @NotNull @PathVariable(name = "contaId") String contaId) {
        serviceBus.execute(new DeleteContaCommand(contaId));
        return ResponseEntity.noContent().build();
    }
}
