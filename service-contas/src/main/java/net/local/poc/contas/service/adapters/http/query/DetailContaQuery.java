package net.local.poc.contas.service.adapters.http.query;

import net.local.poc.contas.service.adapters.http.query.dto.ContaDetailResponse;
import net.local.poc.library.cqrs.Query;

public class DetailContaQuery implements Query {
    
    private final String contaId;
    private ContaDetailResponse response;

    public DetailContaQuery(String contaId) {
        this.contaId = contaId;
    }

    public String getContaId() {
        return contaId;
    }

    public ContaDetailResponse getResponse() {
        return response;
    }

    public void setResponse(ContaDetailResponse response) {
        this.response = response;
    }
}
