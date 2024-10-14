package com.example.Sistem_Rezervare_Restaurant.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.Sistem_Rezervare_Restaurant.app.Mese;
import com.example.Sistem_Rezervare_Restaurant.repository.RepositoryMese;

public class ServiceMeseTest {

    @Mock
    private RepositoryMese repositoryMese;

    @InjectMocks
    private ServiceMese serviceMese;

    private Mese masa;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        masa = new Mese();
        masa.setId_masa(1L);
        masa.setCapacitate(4);
        masa.setDisponibilitate(true);
    }

    @Test
    public void testSalveazaMasa() {
        when(repositoryMese.save(any(Mese.class))).thenReturn(masa);

        Mese savedMasa = serviceMese.creareMasa(masa);
        assertEquals(masa.getId_masa(), savedMasa.getId_masa());
        assertEquals(masa.getCapacitate(), savedMasa.getCapacitate());
        assertEquals(masa.getDisponibilitate(), savedMasa.getDisponibilitate());
        
        verify(repositoryMese, times(1)).save(masa);
    }

    @Test
    public void testGetMese() {
        when(repositoryMese.findAll()).thenReturn(Arrays.asList(masa));

        assertEquals(1, serviceMese.returneazaToateMesele().size());
        assertEquals(masa, serviceMese.returneazaToateMesele().get(0));
    }

    @Test
    public void testGetMasaDupaId() {
        when(repositoryMese.findById(1L)).thenReturn(Optional.of(masa));

        Mese foundMasa = serviceMese.getMasaDupaId(1L);
        assertEquals(masa, foundMasa);
    }

    @Test
    public void testStergereMasa() {
        doNothing().when(repositoryMese).deleteById(1L);
        assertDoesNotThrow(() -> serviceMese.stergeMasa(1L));
        
        verify(repositoryMese, times(1)).deleteById(1L);
    }
}
