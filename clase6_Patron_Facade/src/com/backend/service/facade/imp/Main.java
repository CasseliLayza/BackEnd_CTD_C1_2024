package com.backend.service.facade.imp;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        LocalDate fechaBusqueda = LocalDate.of(2024, 5, 10);
        LocalDate fechaReservada = LocalDate.of(2024, 5, 11);
        String disponibilidad = "";
        disponibilidad = (fechaBusqueda.isBefore(fechaReservada)||fechaBusqueda.isAfter(fechaReservada))?"SI":"NO";

        System.out.println("disponibilidad = " + disponibilidad);


    }
}
