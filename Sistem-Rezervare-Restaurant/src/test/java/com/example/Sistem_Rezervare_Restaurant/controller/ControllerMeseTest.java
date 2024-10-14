package com.example.Sistem_Rezervare_Restaurant.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.Sistem_Rezervare_Restaurant.app.Mese;
import com.example.Sistem_Rezervare_Restaurant.service.ServiceMese;

public class ControllerMeseTest {

    @Mock
    private ServiceMese serviceMese;

    @InjectMocks
    private ControllerMese controllerMese;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = standaloneSetup(controllerMese).build();
    }

    @Test
    public void testCreareMasa() throws Exception {
        Mese masa = new Mese();
        masa.setId_masa(1L);
        masa.setCapacitate(4);
        masa.setDisponibilitate(true);

        when(serviceMese.creareMasa(any(Mese.class))).thenReturn(masa);

        mockMvc.perform(post("/mese")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"capacitate\":4,\"disponibilitate\":true}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.capacitate").value(4))
                .andExpect(jsonPath("$.disponibilitate").value(true));

        verify(serviceMese, times(1)).creareMasa(any(Mese.class));
    }

    @Test
    public void testGetMese() throws Exception {
        Mese masa = new Mese();
        masa.setId_masa(1L);
        masa.setCapacitate(4);
        masa.setDisponibilitate(true);

        when(serviceMese.returneazaToateMesele()).thenReturn(Arrays.asList(masa));

        mockMvc.perform(get("/mese"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].capacitate").value(4))
                .andExpect(jsonPath("$[0].disponibilitate").value(true));
    }

    @Test
    public void testGetMasaDupaId() throws Exception {
        Mese masa = new Mese();
        masa.setId_masa(1L);
        masa.setCapacitate(4);
        masa.setDisponibilitate(true);

        when(serviceMese.getMasaDupaId(1L)).thenReturn(masa);

        mockMvc.perform(get("/mese/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.capacitate").value(4))
                .andExpect(jsonPath("$.disponibilitate").value(true));
    }

    @Test
    public void testStergereMasa() throws Exception {
        doNothing().when(serviceMese).stergeMasa(1L);

        mockMvc.perform(delete("/mese/{id}", 1L))
                .andExpect(status().isOk());
    }
 }
