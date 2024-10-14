package com.example.Sistem_Rezervare_Restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.Sistem_Rezervare_Restaurant.app.Clienti;
import com.example.Sistem_Rezervare_Restaurant.service.ServiceClienti;

@RestController
@RequestMapping("/clienti")
public class ControllerClienti {
	private final ServiceClienti serviceClienti;
	
	@Autowired
	public ControllerClienti(ServiceClienti serviceClienti) {
		this.serviceClienti = serviceClienti;
	}
	
	@GetMapping
	public List<Clienti> getClienti(){
		return serviceClienti.getClienti();
	}
	
	@GetMapping("/{id}")
	public Clienti getClientDupaId(@PathVariable Long id) {
		return serviceClienti.getClientDupaId(id);
	}
	
	@PostMapping
	public Clienti salveazaClient(@RequestBody Clienti clienti) {
		return serviceClienti.salveazaClient(clienti);
	}
	@DeleteMapping("/{id}")
	public void stergereClient(@PathVariable Long id) {
		serviceClienti.stergereClient(id);
	}
}
