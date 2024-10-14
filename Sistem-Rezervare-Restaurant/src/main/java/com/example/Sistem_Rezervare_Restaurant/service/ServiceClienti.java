package com.example.Sistem_Rezervare_Restaurant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Sistem_Rezervare_Restaurant.app.Clienti;
import com.example.Sistem_Rezervare_Restaurant.repository.RepositoryClient;

@Service
public class ServiceClienti {
	private final RepositoryClient repositoryClient;
	
	@Autowired
	public ServiceClienti (RepositoryClient repositoryClient) {
		this.repositoryClient = repositoryClient;
	}
	
	public List<Clienti> getClienti(){
		return repositoryClient.findAll();
	}
	public Clienti getClientDupaId(Long id) {
		return repositoryClient.findById(id).orElse(null);
	}
	public Clienti salveazaClient(Clienti clienti) {
	    if (clienti.getEmail() == null) {
	        throw new IllegalArgumentException("Email-ul nu poate fi null");
	    }
	    // Verifică dacă email-ul nu este gol sau null
	    if (clienti.getNume() == null) {
	        throw new IllegalArgumentException("Numele nu poate fi null");
	    }
	    if (clienti.getNumarTelefon() == null) {
	        throw new IllegalArgumentException("Numarul nu poate fi null");
	    }
	    return repositoryClient.save(clienti);
	}
	public Clienti cautaClientDupaEmail(String email) {
	    return repositoryClient.findByEmail(email);
	}
	public void stergereClient(Long id) {
		repositoryClient.deleteById(id);
	}
}
