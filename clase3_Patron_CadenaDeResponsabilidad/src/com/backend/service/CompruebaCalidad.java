package com.backend.service;

import com.backend.model.Articulo;
import com.backend.service.handles.AnalistaDeCalidad;
import com.backend.service.handles.ManejadorEnvase;
import com.backend.service.handles.ManejadorLote;
import com.backend.service.handles.ManejadorPeso;

public class CompruebaCalidad {

    private AnalistaDeCalidad primerManejador;

    public CompruebaCalidad() {
        primerManejador = new ManejadorPeso();

        AnalistaDeCalidad segundoManejador = new ManejadorLote();
        primerManejador.setSiguienteManejador(segundoManejador);

        AnalistaDeCalidad tercerManejador = new ManejadorEnvase();
        segundoManejador.setSiguienteManejador(tercerManejador);

    }

    public String validarCalidadDelProducto(Articulo articulo) {
        primerManejador.validarCalidadDelProducto(articulo);
        return (primerManejador.getCheck() && primerManejador.getSiguienteManejador().getCheck() && primerManejador.getSiguienteManejador().getSiguienteManejador().getCheck()) ? "Aceptado" : "Rechazado";
    }
}
