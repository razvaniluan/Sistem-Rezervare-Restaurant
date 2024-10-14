# Sistem de Rezervare pentru Restaurant

Acest proiect este o aplicație web de gestionare a rezervărilor pentru restaurante, dezvoltată folosind Java, Spring Boot pentru backend.

## Descriere

Aplicația permite utilizatorilor să efectueze operațiuni CRUD pentru gestionarea clienților și rezervărilor. Utilizatorii pot adăuga, vizualiza, actualiza și șterge informații despre clienți și rezervări.

## Tehnologii Folosite

- **Java**: Limbajul de programare principal
- **Spring Boot**: Framework pentru dezvoltarea aplicațiilor Java
- **MySQL**: SGBD pentru stocarea datelor
- **Hibernate**: ORM pentru gestionarea interacțiunilor cu baza de date
- **Postman**: Instrument pentru testarea API-urilor

## Probleme întâmpinate:

1. Configurarea conexiunii la baza de date:

La început, am întâmpinat probleme cu conexiunea la baza de date din cauza configurării incorecte a fișierului application.properties.
Am corectat setările pentru a include URL-ul corect al bazei de date.

2. Eroarea 500 Intern Server Error:

Am întâmpinat o eroare 500 atunci când am încercat să accesez anumite endpoint-uri ale API-ului.
Aceasta s-a datorat unei coloane lipsă în interogarea SQL.
Am rezolvat problema asigurându-mă că toate coloanele specificate în entități corespund cu cele din baza de date.

3. Testarea API-ului:

Am utilizat Postman pentru a testa endpoint-urile API-ului, dar uneori am avut dificultăți în a primi răspunsuri corecte.
Am ajustat metodele din controller pentru a mă asigura că datele trimise erau corecte.
