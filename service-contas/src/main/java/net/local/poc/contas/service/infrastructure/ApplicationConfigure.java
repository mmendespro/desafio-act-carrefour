package net.local.poc.contas.service.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.local.poc.contas.service.adapters.persistence.repository.ContaH2Repository;
import net.local.poc.contas.service.adapters.persistence.repository.ContaRepository;
import net.local.poc.contas.service.application.ports.persistence.DeleteContaPort;
import net.local.poc.contas.service.application.ports.persistence.LoadContaPort;
import net.local.poc.contas.service.application.ports.persistence.SaveContaPort;
import net.local.poc.contas.service.application.services.ContaManager;

@Configuration
public class ApplicationConfigure {
    
    @Bean
    public ContaRepository repository(ContaH2Repository repo) {
        return new ContaRepository(repo);
    }

    @Bean
    public ContaManager manager(LoadContaPort loadContaPort, SaveContaPort saveContaPort, DeleteContaPort deleteContaPort) {
        return new ContaManager(loadContaPort, saveContaPort, deleteContaPort);
    }
}
