package net.local.poc.lancamentos.service.adapters.http.query;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import net.local.poc.lancamentos.service.adapters.http.query.dto.ContaResponse;
import net.local.poc.lancamentos.service.adapters.http.query.dto.LancamentoResponse;
import net.local.poc.lancamentos.service.adapters.http.query.dto.ReportDiarioResponse;
import net.local.poc.lancamentos.service.adapters.persistence.model.LancamentoJPA;
import net.local.poc.lancamentos.service.adapters.persistence.repository.LancamentoJpaRepository;
import net.local.poc.lancamentos.service.application.ports.client.LoadContaPort;
import net.local.poc.library.cqrs.Resolver;

@Component
public class ReportDiarioResolver implements Resolver<ReportDiarioQuery> {
    
    private final LoadContaPort loadContaPort;
    private final LancamentoJpaRepository repo;

    public ReportDiarioResolver(LoadContaPort loadContaPort, LancamentoJpaRepository repo) {
        this.repo = repo;
        this.loadContaPort = loadContaPort;
    }

    @Override
    public void resolve(ReportDiarioQuery query) {
        List<LancamentoJPA> lancamentos = repo.findAllByLancamentoDataBetween(query.getDiaReport(), query.getDiaReport());
        var saldoAnteriror = calculaSaldoAnterior(query.getDiaReport());
        var totalDiario = calcularTotalDiario(lancamentos);
        var report = ReportDiarioResponse.builder()
                                         .diaReport(query.getDiaReport())
                                         .totalDiario(totalDiario)
                                         .saldoAnterior(saldoAnteriror)
                                         .totalReport(totalDiario + saldoAnteriror)
                                         .lancamentos(mapToLancamentoResponse(lancamentos)).build();
        query.setResult(report);               
    }
    
    private float calcularTotalDiario(List<LancamentoJPA> lancamentos) {
        float result = 0;
        for (LancamentoJPA lancamento : lancamentos) {
            result += (lancamento.getTipo().equals("DEBITO")) ? (lancamento.getValor() * (-1)) : lancamento.getValor();
        }
        return result;
    }

    private float calculaSaldoAnterior(LocalDate dataLancamento) {
        List<LancamentoJPA> lancamentos = repo.findAllByLancamentoDataBetween(dataLancamento.minusDays(1L), dataLancamento.minusDays(1L));
        var saldoAnterior = calcularTotalDiario(lancamentos);
        return saldoAnterior;
    }

    private List<LancamentoResponse> mapToLancamentoResponse(List<LancamentoJPA> lancamentos) {
        var colResult = new ArrayList<LancamentoResponse>();
        
        for (LancamentoJPA lancamento : lancamentos) {
            var lresp = LancamentoResponse.builder()
                                          .lancamentoId(lancamento.getLancamentoId())
                                          .lancamentoData(lancamento.getLancamentoData())
                                          .tipo(lancamento.getTipo())
                                          .valor(lancamento.getValor())
                                          .conta(mapToContaResponse(lancamento.getContaId())).build();
            colResult.add(lresp);
        }

        return colResult;
    }

    private ContaResponse mapToContaResponse(String contaId) {
        var contaOPT = loadContaPort.load(contaId);
        if(contaOPT.isPresent()) {
            return ContaResponse.builder()
                                .contaNome(contaOPT.get().getContaNome())
                                .tipo(contaOPT.get().getTipo().name())
                                .build();
        }
        return null;
    }
}
