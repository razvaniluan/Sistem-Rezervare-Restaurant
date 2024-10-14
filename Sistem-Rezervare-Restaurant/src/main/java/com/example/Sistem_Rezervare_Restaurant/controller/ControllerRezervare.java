package com.example.Sistem_Rezervare_Restaurant.controller;

import com.example.Sistem_Rezervare_Restaurant.app.Rezervare;
import com.example.Sistem_Rezervare_Restaurant.service.ServiceRezervare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rezervari")
public class ControllerRezervare {

    private final ServiceRezervare serviceRezervare;

    @Autowired
    public ControllerRezervare(ServiceRezervare serviceRezervare) {
        this.serviceRezervare = serviceRezervare;
    }

    @GetMapping
    public List<Rezervare> getRezervari() {
        return serviceRezervare.getRezervari();
    }

    @GetMapping("/{id}")
    public Rezervare getRezervareDupaId(@PathVariable Long id) {
        return serviceRezervare.getRezervareDupaId(id);
    }

    @PostMapping
    public Rezervare creareRezervare(@RequestBody Rezervare reservation) {
        return serviceRezervare.creareRezervare(reservation);
    }

    @DeleteMapping("/{id}")
    public void stergereRezervare(@PathVariable Long id) {
        serviceRezervare.stergereRezervare(id);
    }
}
