package net.local.poc.lancamentos.service.adapters.http.api;

import java.time.LocalDate;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.local.poc.lancamentos.service.adapters.http.query.ReportDiarioQuery;
import net.local.poc.lancamentos.service.adapters.http.query.dto.ReportDiarioResponse;
import net.local.poc.library.cqrs.ServiceBus;

@RestController
@RequestMapping("v1/lancamentos")
public class LancamentoReadController {
    
    private ServiceBus serviceBus;

    public LancamentoReadController(ServiceBus serviceBus) {
        this.serviceBus = serviceBus;
    }

    @GetMapping(path = "/{dataLancamento}")
    public ResponseEntity<ReportDiarioResponse> detail(@Valid @NotNull @PathVariable(name = "dataLancamento") String dataLancamento) {
        var dateParts = dataLancamento.split("-");
        var query = new ReportDiarioQuery(LocalDate.of(Integer.valueOf(dateParts[0]), Integer.valueOf(dateParts[1]), Integer.valueOf(dateParts[2])));
        serviceBus.execute(query);
        return ResponseEntity.ok(query.getResult());
    }
}