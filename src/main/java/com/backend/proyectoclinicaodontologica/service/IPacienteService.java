package com.backend.proyectoclinicaodontologica.service;

import com.backend.proyectoclinicaodontologica.dto.entrada.PacienteDtoInput;
import com.backend.proyectoclinicaodontologica.dto.salida.PacienteDtoOut;

import java.util.List;

public interface IPacienteService {

    PacienteDtoOut registrarPaciente(PacienteDtoInput pacienteDtoInput);
    List<PacienteDtoOut> listarPacientes();
}
