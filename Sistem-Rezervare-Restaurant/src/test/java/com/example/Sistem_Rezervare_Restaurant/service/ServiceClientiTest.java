package com.example.Sistem_Rezervare_Restaurant.service;

import com.example.Sistem_Rezervare_Restaurant.app.Clienti;
import com.example.Sistem_Rezervare_Restaurant.repository.RepositoryClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ServiceClientiTest {

    @InjectMocks
    private ServiceClienti serviceClienti;

    @Mock
    private RepositoryClient clientiRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetClienti() {
        Clienti client = new Clienti();
        client.setId(1L);
        client.setNume("Ion");

        when(clientiRepository.findAll()).thenReturn(Collections.singletonList(client));

        List<Clienti> clienti = serviceClienti.getClienti();

        assertEquals(1, clienti.size());
        assertEquals("Ion", clienti.get(0).getNume());
    }

    @Test
    void testGetClientDupaId() {
        Clienti client = new Clienti();
        client.setId(1L);
        client.setNume("Ion");

        when(clientiRepository.findById(1L)).thenReturn(Optional.of(client));

        Clienti foundClient = serviceClienti.getClientDupaId(1L);

        assertNotNull(foundClient);
        assertEquals("Ion", foundClient.getNume());
    }
    @Test
    void testSalveazaClient() {
        Clienti client = new Clienti();
        client.setNume("Ion");
        client.setEmail("client@gmail.com");
        client.setNumarTelefon("0123456789");

        when(clientiRepository.save(any(Clienti.class))).thenReturn(client);

        Clienti savedClient = serviceClienti.salveazaClient(client);

        assertNotNull(savedClient);
        assertEquals("Ion", savedClient.getNume());
        assertEquals("client@gmail.com", savedClient.getEmail());
        assertEquals("0123456789", savedClient.getNumarTelefon());
        
        verify(clientiRepository, times(1)).save(client);
    }

    @Test
    void testStergereClient() {
        Long clientId = 1L;

        doNothing().when(clientiRepository).deleteById(clientId);

        assertDoesNotThrow(() -> serviceClienti.stergereClient(clientId));

        verify(clientiRepository, times(1)).deleteById(clientId);
    }

}