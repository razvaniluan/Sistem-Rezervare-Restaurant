package com.example.Sistem_Rezervare_Restaurant.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.Sistem_Rezervare_Restaurant.app.Rezervare;
import com.example.Sistem_Rezervare_Restaurant.repository.RepositoryRezervare;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ServiceRezervareTest {
    
    @InjectMocks
    private ServiceRezervare serviceRezervare;

    @Mock
    private RepositoryRezervare repositoryRezervare;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testReturneazaToateRezervarile() {
 
        Rezervare rezervare1 = new Rezervare();
        rezervare1.setDataRezervare(LocalDate.parse("2024-10-15"));
        rezervare1.setOraRezervare(LocalTime.parse("18:00"));
        
        Rezervare rezervare2 = new Rezervare();
        rezervare2.setDataRezervare(LocalDate.parse("2024-10-16"));
        rezervare2.setOraRezervare(LocalTime.parse("19:30"));

        when(repositoryRezervare.findAll()).thenReturn(Arrays.asList(rezervare1, rezervare2));

        List<Rezervare> rezervari = serviceRezervare.getRezervari();

        assertEquals(2, rezervari.size());
        assertEquals(LocalDate.parse("2024-10-15"), rezervari.get(0).getDataRezervare());
        assertEquals(LocalDate.parse("2024-10-16"), rezervari.get(1).getDataRezervare());
    }
    
    @Test
    public void testGetRezervareDupaId() {
        Rezervare rezervare = new Rezervare();
        rezervare.setDataRezervare(LocalDate.parse("2024-10-15"));
        rezervare.setOraRezervare(LocalTime.parse("18:00")); 

        when(repositoryRezervare.findById(1L)).thenReturn(Optional.of(rezervare));

        Rezervare rezultat = serviceRezervare.getRezervareDupaId(1L);

        assertNotNull(rezervare);
        assertEquals(LocalDate.parse("2024-10-15"), rezultat.getDataRezervare());
        assertEquals(LocalTime.parse("18:00"), rezultat.getOraRezervare());
    }


    @Test
    public void testCreareRezervare() {
    	
        Rezervare rezervare = new Rezervare();
        rezervare.setDataRezervare(LocalDate.parse("2024-10-15"));
        rezervare.setOraRezervare(LocalTime.parse("18:00"));

        when(repositoryRezervare.save(any(Rezervare.class))).thenReturn(rezervare);

        Rezervare rezultat = serviceRezervare.creareRezervare(rezervare);

        assertNotNull(rezervare);
        assertEquals(LocalDate.parse("2024-10-15"), rezultat.getDataRezervare());
        assertEquals(LocalTime.parse("18:00"), rezultat.getOraRezervare());
    }
    
    @Test
    public void testStergeRezervare() {
        doNothing().when(repositoryRezervare).deleteById(1L);

        serviceRezervare.stergereRezervare(1L);

        verify(repositoryRezervare, times(1)).deleteById(1L);
    }
}
