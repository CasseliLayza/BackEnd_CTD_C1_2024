package com.backend.proyectoclinicaodontologica.service.impl;

import com.backend.proyectoclinicaodontologica.entity.Paciente;
import com.backend.proyectoclinicaodontologica.repository.IDao;
import com.backend.proyectoclinicaodontologica.service.IPacienteService;

import java.util.List;

public class PacienteService implements IPacienteService {

    private IDao<Paciente> pacienteIDao;

    public PacienteService(IDao<Paciente> pacienteIDao) {
        this.pacienteIDao = pacienteIDao;
    }

    @Override
    public Paciente registrarPaciente(Paciente paciente) {
        return pacienteIDao.registrar(paciente);
    }

    @Override
    public List<Paciente> listarPacientes() {
        return pacienteIDao.listarTodos();
    }
}
