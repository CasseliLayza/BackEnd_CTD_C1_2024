package com.backend.proyectoclinicaodontologica.service;

import com.backend.proyectoclinicaodontologica.dto.entrada.OdontologoDtoInput;
import com.backend.proyectoclinicaodontologica.dto.salida.OdontologoDtoOut;

import java.util.List;

public interface IOdontologoService {
    OdontologoDtoOut registrarOdontologo(OdontologoDtoInput odontologoDtoInput);
    List<OdontologoDtoOut> listarOdontologos();
}
