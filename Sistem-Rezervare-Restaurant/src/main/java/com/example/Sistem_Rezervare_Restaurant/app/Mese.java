package com.example.Sistem_Rezervare_Restaurant.app;

import jakarta.persistence.*;

@Entity
@Table(name="mese")
public class Mese {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_masa")
	private Long id;
	
	@Column(name="capacitate", nullable = false)
	private int capacitate;
	
	@Column(name="disponibilitate",nullable = false)
	private boolean disponibilitate;
	
	public Mese() {}
	
	public Long getId_masa() {
		return id;
	}
	public void setId_masa(Long id) {
		this.id = id;
	}
	public int getCapacitate() {
		return capacitate;
	}
	public void setCapacitate(int capacitate) {
		this.capacitate = capacitate;
	}
	public boolean getDisponibilitate() {
		return disponibilitate;
	}
	public void setDisponibilitate(Boolean disponibilitate) {
		this.disponibilitate = disponibilitate;
	}
}
