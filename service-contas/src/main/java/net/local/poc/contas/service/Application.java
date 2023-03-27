package net.local.poc.contas.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.local.poc.library.annotations.EnableCqrsLibrary;

@EnableCqrsLibrary
@SpringBootApplication
public class Application {
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }    
}
