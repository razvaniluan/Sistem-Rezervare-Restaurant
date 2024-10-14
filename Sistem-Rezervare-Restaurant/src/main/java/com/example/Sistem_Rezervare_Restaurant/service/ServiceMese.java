package com.example.Sistem_Rezervare_Restaurant.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Sistem_Rezervare_Restaurant.app.Mese;
import com.example.Sistem_Rezervare_Restaurant.repository.RepositoryMese;

@Service
public class ServiceMese {
	public final RepositoryMese repositoryMese;
	
	public ServiceMese(RepositoryMese repositoryMese){
		this.repositoryMese = repositoryMese;
	}
	
	public List<Mese> returneazaToateMesele(){
		return repositoryMese.findAll();
	}
	public Mese getMasaDupaId(Long id) {
		return repositoryMese.findById(id).orElse(null);
	}
	
	public Mese creareMasa(Mese masa) {
		return repositoryMese.save(masa);
	}
	
	public void stergeMasa(Long id) {
		repositoryMese.deleteById(id);
	}
}
