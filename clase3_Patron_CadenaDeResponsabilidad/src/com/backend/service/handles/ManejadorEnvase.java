package com.backend.service.handles;

import com.backend.model.Articulo;

public class ManejadorEnvase extends AnalistaDeCalidad {
    @Override
    public String validarCalidadDelProducto(Articulo articulo) {

        super.check = (articulo.getEnvasado().equals("sano") || articulo.getEnvasado().equals("casi sano"));
        System.out.println("Validado envase " + check);
        return "Fin";
    }
}
