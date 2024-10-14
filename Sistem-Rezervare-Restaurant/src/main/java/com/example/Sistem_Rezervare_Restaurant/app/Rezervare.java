package com.example.Sistem_Rezervare_Restaurant.app;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;

@Entity
@Table(name="rezervari")
public class Rezervare {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_rezervare")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="id_client", nullable = false)
	private Clienti client;
	
	@ManyToOne
	@JoinColumn(name="id_masa", nullable = false)
	private Mese masa;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name="data_rezervare",nullable = false)
	private LocalDate dataRezervare;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	@Column(name="ora_rezervare",nullable = false)
	private LocalTime oraRezervare;
	
	public Rezervare() {};
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id=id;
	}
	public Clienti getClient() {
		return client;
	}
	public void setClient(Clienti client) {
		this.client=client;
	} 
	public Mese getMasa() {
		return masa;
	}
	public void setMasa(Mese masa) {
		this.masa=masa;
	}
	public LocalDate getDataRezervare() {
		return dataRezervare;
	}
	public void setDataRezervare(LocalDate dataRezervare) {
		this.dataRezervare=dataRezervare;
	}
	public LocalTime getOraRezervare() {
		return oraRezervare;
	}
	public void setOraRezervare(LocalTime oraRezervare) {
		this.oraRezervare=oraRezervare;
	}
}
