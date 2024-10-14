package com.example.Sistem_Rezervare_Restaurant.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Sistem_Rezervare_Restaurant.app.Rezervare;
import com.example.Sistem_Rezervare_Restaurant.repository.RepositoryRezervare;

@Service
public class ServiceRezervare {
	private final RepositoryRezervare repositoryRezervare;
	
	public ServiceRezervare(RepositoryRezervare repositoryRezervare) {
		this.repositoryRezervare = repositoryRezervare;
	}
	
	public List<Rezervare> getRezervari(){
		return repositoryRezervare.findAll();
	}
	public Rezervare getRezervareDupaId(Long id) {
		return repositoryRezervare.findById(id).orElse(null);
	}
	public Rezervare creareRezervare(Rezervare rezervare) {
		return repositoryRezervare.save(rezervare);
	}
	public void stergereRezervare(Long id) {
		repositoryRezervare.deleteById(id);
	}
}
