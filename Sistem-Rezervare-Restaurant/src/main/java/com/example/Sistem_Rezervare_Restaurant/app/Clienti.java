package com.example.Sistem_Rezervare_Restaurant.app;

import jakarta.persistence.*;

@Entity
@Table(name = "clienti")
public class Clienti {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id_client")
	private Long id;
	
	@Column(name="nume", nullable = false)
	private String nume;
	
	@Column(name="telefon", nullable = false)
	private String telefon;
	
	@Column(name="email", nullable = false)
	private String email;
	
	public Clienti() {}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume=nume;
	}
	public String getNumarTelefon() {
		return telefon;
	}
	public void setNumarTelefon(String telefon) {
		this.telefon=telefon;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email=email;
	}
    @Override
    public String toString() {
        return "Clienti{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", telefon='" + telefon + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
