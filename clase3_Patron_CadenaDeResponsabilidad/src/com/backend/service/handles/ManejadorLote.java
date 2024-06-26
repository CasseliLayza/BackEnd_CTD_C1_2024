package com.backend.service.handles;

import com.backend.model.Articulo;

public class ManejadorLote extends AnalistaDeCalidad {
    @Override
    public String validarCalidadDelProducto(Articulo articulo) {

        super.check = (articulo.getLote() >= 1000 && articulo.getLote() <= 2000);
        System.out.println("Validando lote " + check);
        return getSiguienteManejador().validarCalidadDelProducto(articulo);
    }
}
