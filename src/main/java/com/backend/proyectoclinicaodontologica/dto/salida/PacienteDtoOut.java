package com.backend.proyectoclinicaodontologica.dto.salida;

import java.time.LocalDate;

public class PacienteDtoOut {
    private String nombre;
    private String apellido;
    private int dni;
    private LocalDate fechaIngreso;
    private DomicilioDtoOut domicilioDtoDtoOut;

    public PacienteDtoOut(String nombre, String apellido, int dni, LocalDate fechaIngreso, DomicilioDtoOut domicilioDtoDtoOut) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.domicilioDtoDtoOut = domicilioDtoDtoOut;
    }

    public PacienteDtoOut() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public DomicilioDtoOut getDomicilioOutDtoDto() {
        return domicilioDtoDtoOut;
    }

    public void setDomicilioOutDtoDto(DomicilioDtoOut domicilioDtoDtoOut) {
        this.domicilioDtoDtoOut = domicilioDtoDtoOut;
    }
}
