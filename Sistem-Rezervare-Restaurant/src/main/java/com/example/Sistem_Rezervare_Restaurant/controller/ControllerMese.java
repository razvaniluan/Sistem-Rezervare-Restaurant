package com.example.Sistem_Rezervare_Restaurant.controller;

import com.example.Sistem_Rezervare_Restaurant.app.Mese;
import com.example.Sistem_Rezervare_Restaurant.service.ServiceMese;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mese")
public class ControllerMese {

    private final ServiceMese serviceMese;

    @Autowired
    public ControllerMese (ServiceMese serviceMese) {
        this.serviceMese = serviceMese;
    }
    @GetMapping
    public List<Mese> getMese() {
        return serviceMese.returneazaToateMesele();
    }

    @GetMapping("/{id}")
    public Mese getMasaDupaId(@PathVariable Long id) {
        return serviceMese.getMasaDupaId(id);
    }

    @PostMapping
    public Mese creareMasa(@RequestBody Mese table) {
        return serviceMese.creareMasa(table);
    }

    @DeleteMapping("/{id}")
    public void stergereMasa(@PathVariable Long id) {
        serviceMese.stergeMasa(id);
    }
}
