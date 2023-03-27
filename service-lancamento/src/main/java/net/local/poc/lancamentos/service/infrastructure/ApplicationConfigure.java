package net.local.poc.lancamentos.service.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import net.local.poc.lancamentos.service.application.ports.client.LoadContaPort;
import net.local.poc.lancamentos.service.application.ports.persistence.DeleteLancamentoPort;
import net.local.poc.lancamentos.service.application.ports.persistence.LoadLancamentoPort;
import net.local.poc.lancamentos.service.application.ports.persistence.SaveLancamentoPort;
import net.local.poc.lancamentos.service.application.services.LancamentoService;

@Configuration
public class ApplicationConfigure {

    @Bean
    public LancamentoService lancamentoService(LoadContaPort loadContaPort, LoadLancamentoPort loadLancamentoPort, SaveLancamentoPort saveLancamentoPort, DeleteLancamentoPort deleteLancamentoPort) {
        return new LancamentoService(loadContaPort, loadLancamentoPort, saveLancamentoPort, deleteLancamentoPort);
    }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper;
    }
}
