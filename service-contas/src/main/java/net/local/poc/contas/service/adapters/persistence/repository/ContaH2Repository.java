package net.local.poc.contas.service.adapters.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.local.poc.contas.service.adapters.persistence.model.ContaJPA;

public interface ContaH2Repository extends JpaRepository<ContaJPA, String> {
    
    List<ContaJPA> findByContaPai(String contaPai);
}
