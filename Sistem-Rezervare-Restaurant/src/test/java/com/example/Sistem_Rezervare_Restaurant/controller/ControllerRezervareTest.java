package com.example.Sistem_Rezervare_Restaurant.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.Sistem_Rezervare_Restaurant.app.Rezervare;
import com.example.Sistem_Rezervare_Restaurant.service.ServiceRezervare;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

public class ControllerRezervareTest {

    @InjectMocks
    private ControllerRezervare controllerRezervari;

    @Mock
    private ServiceRezervare serviceRezervare;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controllerRezervari).build();
    }

    @Test
    public void testGetRezervare() throws Exception {
        // Setup
        Rezervare rezervare1 = new Rezervare();
        rezervare1.setDataRezervare(LocalDate.parse("2024-10-15"));
        rezervare1.setOraRezervare(LocalTime.parse("18:00"));

        Rezervare rezervare2 = new Rezervare();
        rezervare2.setDataRezervare(LocalDate.parse("2024-10-16"));
        rezervare2.setOraRezervare(LocalTime.parse("19:30"));

        List<Rezervare> rezervari = Arrays.asList(rezervare1, rezervare2);
        when(serviceRezervare.getRezervari()).thenReturn(rezervari);

        // Executie
        mockMvc.perform(get("/rezervari"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].dataRezervare").value("2024-10-15")) // Verificăm data primei rezervări
                .andExpect(jsonPath("$[0].oraRezervare").value("18:00")) // Verificăm ora primei rezervări
                .andExpect(jsonPath("$[1].dataRezervare").value("2024-10-16")) // Verificăm data celei de-a doua rezervări
                .andExpect(jsonPath("$[1].oraRezervare").value("19:30")); // Verificăm ora celei de-a doua rezervări
    }


    @Test
    public void testCreareRezervare() throws Exception {
        // Setup
        Rezervare rezervare = new Rezervare();
        rezervare.setDataRezervare(LocalDate.parse("2024-10-15"));
        rezervare.setOraRezervare(LocalTime.parse("18:00"));

        when(serviceRezervare.creareRezervare(any(Rezervare.class))).thenReturn(rezervare);

        // Executie
        mockMvc.perform(post("/rezervari")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"dataRezervare\":\"2024-10-15\", \"oraRezervare\":\"18:00\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.dataRezervare").value("2024-10-15")) // Verificăm data primei rezervări
                .andExpect(jsonPath("$.oraRezervare").value("18:00")); // Verificăm ora primei rezervări
    }

    @Test
    public void testGetRezervareDupaId() throws Exception {
        // Setup
        Rezervare rezervare = new Rezervare();
        rezervare.setDataRezervare(LocalDate.parse("2024-10-15"));
        rezervare.setOraRezervare(LocalTime.parse("18:00"));

        when(serviceRezervare.getRezervareDupaId(1L)).thenReturn(rezervare);

        // Executie
        mockMvc.perform(get("/rezervari/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.dataRezervare").value("2024-10-15")) // Verificăm data primei rezervări
                .andExpect(jsonPath("$.oraRezervare").value("18:00")); // Verificăm ora primei rezervări
    }
    
    @Test
    public void testStergereRezervare() throws Exception {
        // Executie
        mockMvc.perform(delete("/rezervari/1"))
                .andExpect(status().isOk());

        // Verificare
        Mockito.verify(serviceRezervare, Mockito.times(1)).stergereRezervare(1L);
    }
}
