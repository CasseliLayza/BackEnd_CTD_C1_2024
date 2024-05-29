package com.backend.proyectoclinicaodontologica.dto.salida;

import java.time.LocalDateTime;

public class TurnDtoOut {
    private LocalDateTime fechaYHora;
    private OdontologoDtoOut odontologoDtoOut;
    private PacienteDtoOut pacienteDtoOut;


    public TurnDtoOut() {
    }

    public TurnDtoOut(LocalDateTime fechaYHora, OdontologoDtoOut odontologoDtoOut, PacienteDtoOut pacienteDtoOut) {
        this.fechaYHora = fechaYHora;
        this.odontologoDtoOut = odontologoDtoOut;
        this.pacienteDtoOut = pacienteDtoOut;
    }

    public LocalDateTime getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(LocalDateTime fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    public OdontologoDtoOut getOdontologoDtoOut() {
        return odontologoDtoOut;
    }

    public void setOdontologoDtoOut(OdontologoDtoOut odontologoDtoOut) {
        this.odontologoDtoOut = odontologoDtoOut;
    }

    public PacienteDtoOut getPacienteDtoOut() {
        return pacienteDtoOut;
    }

    public void setPacienteDtoOut(PacienteDtoOut pacienteDtoOut) {
        this.pacienteDtoOut = pacienteDtoOut;
    }
}
