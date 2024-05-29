package com.backend.proyectoclinicaodontologica;

import com.backend.proyectoclinicaodontologica.entity.Domicilio;
import com.backend.proyectoclinicaodontologica.entity.Paciente;
import com.backend.proyectoclinicaodontologica.repository.impl.PacienteDaoH2;
import com.backend.proyectoclinicaodontologica.service.impl.PacienteService;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PacienteServiceTest {

    private PacienteService pacienteService;

    @Test
    void deberiaRegistrarseUnPacienteYObtenerElIdCorrespondienteParaPacienteYDomicilioEnH2(){

        pacienteService = new PacienteService(new PacienteDaoH2());
        Paciente paciente = new Paciente("Nombre", "Apellido", 123456, LocalDate.of(2023, 05, 02), new Domicilio("Calle", 13, "Localidad", "Provincia"));

        Paciente pacienteRegistrado = pacienteService.registrarPaciente(paciente);

        assertNotNull(pacienteRegistrado.getDomicilio().getId());
        assertNotNull(pacienteRegistrado.getId());

    }


    @Test
    void deberiaRetornarseUnaListaNoVaciaDePacientesEnH2(){
        pacienteService = new PacienteService(new PacienteDaoH2());
        assertFalse(pacienteService.listarPacientes().isEmpty());
    }

}