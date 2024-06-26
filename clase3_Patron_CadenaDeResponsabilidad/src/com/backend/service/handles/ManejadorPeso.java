package com.backend.service.handles;

import com.backend.model.Articulo;

public class ManejadorPeso extends AnalistaDeCalidad {
    @Override
    public String validarCalidadDelProducto(Articulo articulo) {

        super.check = (articulo.getPeso() >= 1200 && articulo.getPeso() <= 1300);
        System.out.println("Validando peso " + check);
        return getSiguienteManejador().validarCalidadDelProducto(articulo);
    }
}
