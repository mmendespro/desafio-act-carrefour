package net.local.poc.contas.service.adapters.http.query;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import net.local.poc.contas.service.adapters.http.query.dto.ContaDetailResponse;
import net.local.poc.contas.service.application.domain.Conta;
import net.local.poc.contas.service.application.exceptions.ContaInexistenteExeption;
import net.local.poc.contas.service.application.ports.persistence.LoadContaPort;
import net.local.poc.library.cqrs.Resolver;

@Component
public class DetailContaResolver implements Resolver<DetailContaQuery> {

    private final LoadContaPort loadContaPort;

    public DetailContaResolver(LoadContaPort loadContaPort) {
        this.loadContaPort = loadContaPort;
    }

    @Override
    public void resolve(DetailContaQuery query) {
        var conta = loadContaPort.load(query.getContaId()).orElseThrow(ContaInexistenteExeption::new);
        var subcontas = loadContaPort.loadByContaPai(query.getContaId());
        
        var response = mapToResponse(conta, subcontas);
        
        query.setResponse(response);
    }

    private ContaDetailResponse mapToResponse(Conta conta, List<Conta> subContas) {
        return ContaDetailResponse.builder()
                                  .contaId(conta.getContaId())
                                  .contaNome(conta.getContaNome())
                                  .tipo(conta.getTipo().name())
                                  .subcontas(subContas.stream().map(sub -> mapToResponse(sub, loadContaPort.loadByContaPai(sub.getContaId()))).collect(Collectors.toList()))
                                  .build();
    }
}
