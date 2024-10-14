package com.example.Sistem_Rezervare_Restaurant.controller;

import com.example.Sistem_Rezervare_Restaurant.app.Clienti;
import com.example.Sistem_Rezervare_Restaurant.service.ServiceClienti;
import com.example.Sistem_Rezervare_Restaurant.controller.ControllerClientiTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
public class ControllerClientiTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private ServiceClienti serviceClienti;

    @InjectMocks
    private ControllerClienti controllerClienti;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetClienti() throws Exception {
        Clienti client = new Clienti();
        client.setId(1L);
        client.setNume("Ion");

        when(serviceClienti.getClienti()).thenReturn(Collections.singletonList(client));

        mockMvc.perform(get("/clienti"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].nume").value("Razvan Iluan"));
    }

    @Test
    void testGetClientDupaId() throws Exception {
        Clienti client = new Clienti();
        client.setId(1L);
        client.setNume("Ion");

        when(serviceClienti.getClientDupaId(1L)).thenReturn(client);

        mockMvc.perform(get("/clienti/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nume").value("Razvan Iluan"));
    }

    @Test
    public void testSalveazaClient() throws Exception {

        Clienti client = new Clienti();
        client.setEmail("client@example.com");
        client.setNume("Ion");
        client.setNumarTelefon("0743256789");


        when(serviceClienti.salveazaClient(any(Clienti.class))).thenReturn(client);


        mockMvc.perform(post("/clienti")
        	    .contentType(MediaType.APPLICATION_JSON)
        	    .content("{\"email\":\"client@example.com\", \"nume\":\"Ion\", \"numarTelefon\":\"0743256789\"}"))
        	    .andExpect(status().isOk())
        	    .andExpect(jsonPath("$.email").value("client@example.com"))
        	    .andExpect(jsonPath("$.nume").value("Ion"))
        	    .andExpect(jsonPath("$.numarTelefon").value("0743256789"));


        verify(serviceClienti, times(1)).salveazaClient(any(Clienti.class));
    }


    @Test
    void testStergereClient() throws Exception {
        Long idClient = 1L;


        doNothing().when(serviceClienti).stergereClient(idClient);


        mockMvc.perform(delete("/clienti/{id}", idClient))
                .andExpect(status().isOk());


        verify(serviceClienti, times(1)).stergereClient(idClient);
    }
}
