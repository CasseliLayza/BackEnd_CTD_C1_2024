package com.backend.proyectoclinicaodontologica.controller;

import com.backend.proyectoclinicaodontologica.dto.entrada.PacienteDtoInput;
import com.backend.proyectoclinicaodontologica.dto.salida.PacienteDtoOut;
import com.backend.proyectoclinicaodontologica.service.impl.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @PostMapping("/registar")
    public PacienteDtoOut registerPaciente(@RequestBody PacienteDtoInput pacienteDtoInput){
        return pacienteService.registrarPaciente(pacienteDtoInput);
    }

    @GetMapping("/listar")
    public List<PacienteDtoOut> listaPacientes(){
        return pacienteService.listarPacientes();
    }





}
