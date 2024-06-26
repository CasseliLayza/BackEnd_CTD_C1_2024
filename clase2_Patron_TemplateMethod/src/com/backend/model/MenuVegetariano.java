package com.backend.model;

import com.backend.model.Menu;

public class MenuVegetariano extends Menu {
    private int cantidadEspecias;
    private final double ADICIONALPORESPECIE = 0.1;
    private int cantidadSalsaVegetariana;
    private final double PRECIOSALSA = 2.0;

    public MenuVegetariano(double precioBase, int cantidadEspecias, int cantidadSalsaVegetariana) {
        super(precioBase);
        this.cantidadEspecias = cantidadEspecias;
        this.cantidadSalsaVegetariana = cantidadSalsaVegetariana;
    }

    public double getADICIONALPORESPECIE() {
        return ADICIONALPORESPECIE;
    }

    public int getCantidadSalsaVegetariana() {
        return cantidadSalsaVegetariana;
    }


    public int getCantidadEspecias() {
        return cantidadEspecias;
    }


    public double getPRECIOSALSA() {
        return PRECIOSALSA;
    }
}
