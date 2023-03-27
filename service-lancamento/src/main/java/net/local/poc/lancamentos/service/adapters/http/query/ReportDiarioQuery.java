package net.local.poc.lancamentos.service.adapters.http.query;

import java.time.LocalDate;

import net.local.poc.lancamentos.service.adapters.http.query.dto.ReportDiarioResponse;
import net.local.poc.library.cqrs.Query;

public class ReportDiarioQuery implements Query {
    
    private final LocalDate diaReport;
    private ReportDiarioResponse result;

    public ReportDiarioQuery(LocalDate diaReport) {
        this.diaReport = diaReport;
    }

    public LocalDate getDiaReport() {
        return diaReport;
    }

    public ReportDiarioResponse getResult() {
        return result;
    }

    public void setResult(ReportDiarioResponse result) {
        this.result = result;
    }

}
