package com.backend.service;

import com.backend.model.Articulo;

public class Main {
    public static void main(String[] args) {

        CompruebaCalidad compruebaCalidad = new CompruebaCalidad();

        System.out.println( "Producto => " +compruebaCalidad.validarCalidadDelProducto(new Articulo("Motor",1000,1200,"sano")));

    }
}
