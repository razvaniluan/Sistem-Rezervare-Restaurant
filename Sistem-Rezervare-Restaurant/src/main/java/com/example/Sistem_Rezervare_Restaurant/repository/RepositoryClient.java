package com.example.Sistem_Rezervare_Restaurant.repository;

import com.example.Sistem_Rezervare_Restaurant.app.Clienti;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryClient extends JpaRepository<Clienti, Long>{
		Clienti findByEmail(String email);
}
