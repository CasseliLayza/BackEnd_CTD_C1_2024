package com.backend.proyectoclinicaodontologica.service.impl;

import com.backend.proyectoclinicaodontologica.dto.entrada.DomicilioDtoInput;
import com.backend.proyectoclinicaodontologica.dto.entrada.PacienteDtoInput;
import com.backend.proyectoclinicaodontologica.dto.salida.DomicilioDtoOut;
import com.backend.proyectoclinicaodontologica.dto.salida.PacienteDtoOut;
import com.backend.proyectoclinicaodontologica.entity.Domicilio;
import com.backend.proyectoclinicaodontologica.entity.Paciente;
import com.backend.proyectoclinicaodontologica.repository.IDao;
import com.backend.proyectoclinicaodontologica.service.IPacienteService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PacienteService implements IPacienteService {

    private IDao<Paciente> pacienteIDao;

    public PacienteService(IDao<Paciente> pacienteIDao) {
        this.pacienteIDao = pacienteIDao;
    }

    @Override
    public PacienteDtoOut registrarPaciente(PacienteDtoInput pacienteDtoInput) {
        DomicilioDtoInput domicilioDtoInput = pacienteDtoInput.getDomicilioInputDto();
        Domicilio registedDomicilio = new Domicilio(domicilioDtoInput.getCalle(), domicilioDtoInput.getNumero(), domicilioDtoInput.getLocalidad(), domicilioDtoInput.getProvincia());
        Paciente registedPaciente = new Paciente(pacienteDtoInput.getNombre(), pacienteDtoInput.getApellido(), pacienteDtoInput.getDni(), pacienteDtoInput.getFechaIngreso(), registedDomicilio);
        pacienteIDao.registrar(registedPaciente);
        DomicilioDtoOut domicilioDtoOut = new DomicilioDtoOut(registedPaciente.getDomicilio().getCalle(), registedPaciente.getDomicilio().getNumero(), registedPaciente.getDomicilio().getLocalidad(), registedPaciente.getDomicilio().getProvincia());
        return new PacienteDtoOut(registedPaciente.getNombre(), registedPaciente.getApellido(), registedPaciente.getDni(), registedPaciente.getFechaIngreso(), domicilioDtoOut);
    }

    @Override
    public List<PacienteDtoOut> listarPacientes() {

        List<Paciente> pacientes = pacienteIDao.listarTodos();
        List<PacienteDtoOut> pacienteDtoOuts = new ArrayList<>();
        for (Paciente paciente: pacientes) {
            DomicilioDtoOut domicilioDtoOut = new DomicilioDtoOut(paciente.getDomicilio().getCalle(), paciente.getDomicilio().getNumero(), paciente.getDomicilio().getLocalidad(), paciente.getDomicilio().getProvincia());
            pacienteDtoOuts.add(new PacienteDtoOut(paciente.getNombre(),paciente.getApellido(),paciente.getDni(),paciente.getFechaIngreso(),domicilioDtoOut));
        }

        return pacienteDtoOuts;
    }

}
