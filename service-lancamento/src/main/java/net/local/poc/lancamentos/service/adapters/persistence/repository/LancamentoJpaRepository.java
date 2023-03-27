package net.local.poc.lancamentos.service.adapters.persistence.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.local.poc.lancamentos.service.adapters.persistence.model.LancamentoJPA;

public interface LancamentoJpaRepository extends JpaRepository<LancamentoJPA, String> {   
    
    List<LancamentoJPA> findAllByLancamentoDataBetween(LocalDate startDate, LocalDate endDate);
}
