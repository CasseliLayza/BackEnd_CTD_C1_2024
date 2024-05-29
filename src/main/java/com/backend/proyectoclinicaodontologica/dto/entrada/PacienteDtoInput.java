package com.backend.proyectoclinicaodontologica.dto.entrada;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.time.LocalDate;

public class PacienteDtoInput {

    @NotBlank(message = "The value nombre should not empty" )
    @Size(max = 50,message = "The value nombre should has max 50 characters")
    private String nombre;
    @NotBlank(message = "The value apellido should not empty")
    @Size(max = 50,message = "The value apellido should has max 50 characters")
    private String apellido;
    @Positive(message = "The value dni should not null or less than zero")
    private int dni;
    @FutureOrPresent(message = " The value date should not be before to today")
    @NotNull(message = "should has a value")
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    private LocalDate fechaIngreso;

    @NotNull(message = "El domicilio of customer not has to be empty")
    @Valid
    private DomicilioDtoInput domicilioDtoInput;

    public PacienteDtoInput(String nombre, String apellido, int dni, LocalDate fechaIngreso, DomicilioDtoInput domicilioDtoInput) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.domicilioDtoInput = domicilioDtoInput;
    }

    public PacienteDtoInput() {
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

    public DomicilioDtoInput getDomicilioInputDto() {
        return domicilioDtoInput;
    }

    public void setDomicilioInputDto(DomicilioDtoInput domicilioDtoInput) {
        this.domicilioDtoInput = domicilioDtoInput;
    }
}
