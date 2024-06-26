package com.backend.service.handles;

import com.backend.model.Articulo;

public abstract class AnalistaDeCalidad {
    private AnalistaDeCalidad siguienteManejador;
    protected boolean check;

    public AnalistaDeCalidad getSiguienteManejador() {
        return siguienteManejador;
    }

    public void setSiguienteManejador(AnalistaDeCalidad siguienteManejador) {
        this.siguienteManejador = siguienteManejador;
    }

    public abstract String validarCalidadDelProducto(Articulo articulo);


    public boolean getCheck() {
        return check;
    }
}