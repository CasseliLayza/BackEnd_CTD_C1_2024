package com.backend.proyectoclinicaodontologica.dto.entrada;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class DomicilioDtoInput {
    //@NotNull(message = "The value calle should not null or empty")
    @NotBlank(message = "The value calle should not empty" )
    private String calle;
    @Positive(message = "The value numero should not null or less than zero")
    @Digits(integer = 8,fraction = 0,message = "The value numero should has max 8 digits")
    private int numero;

    //@NotNull(message = "The value calle should not null or empty")
    @NotBlank(message = "The value calle should not empty" )
    private String localidad;

    //@NotNull(message = "The value calle should not null or empty")
    @NotBlank(message = "The value calle should not empty" )
    private String provincia;

    public DomicilioDtoInput(String calle, int numero, String localidad, String provincia) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public DomicilioDtoInput() {
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
}
