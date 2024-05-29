package com.backend.proyectoclinicaodontologica.service;

import com.backend.proyectoclinicaodontologica.entity.Paciente;

import java.util.List;

public interface IPacienteService {

    Paciente registrarPaciente(Paciente paciente);
    List<Paciente> listarPacientes();
}
