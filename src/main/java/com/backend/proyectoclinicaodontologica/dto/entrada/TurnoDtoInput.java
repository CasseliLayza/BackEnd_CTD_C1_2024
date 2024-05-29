package com.backend.proyectoclinicaodontologica.dto.entrada;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class TurnoDtoInput {

    @NotNull(message = "should has a value")
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd-HH-mm")
    private LocalDateTime fechaYHora;
    @NotNull(message = "Odontologo not has to be empty")
    @Valid
    private OdontologoDtoInput odontologoDtoInput;
    @NotNull(message = "Paciente not has to be empty")
    @Valid
    private PacienteDtoInput pacienteDtoInput;


    public TurnoDtoInput() {
    }

    public TurnoDtoInput(LocalDateTime fechaYHora, OdontologoDtoInput odontologoDtoInput, PacienteDtoInput pacienteDtoInput) {
        this.fechaYHora = fechaYHora;
        this.odontologoDtoInput = odontologoDtoInput;
        this.pacienteDtoInput = pacienteDtoInput;
    }

    public LocalDateTime getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(LocalDateTime fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    public OdontologoDtoInput getOdontologoDtoInput() {
        return odontologoDtoInput;
    }

    public void setOdontologoDtoInput(OdontologoDtoInput odontologoDtoInput) {
        this.odontologoDtoInput = odontologoDtoInput;
    }

    public PacienteDtoInput getPacienteDtoInput() {
        return pacienteDtoInput;
    }

    public void setPacienteDtoInput(PacienteDtoInput pacienteDtoInput) {
        this.pacienteDtoInput = pacienteDtoInput;
    }
}
