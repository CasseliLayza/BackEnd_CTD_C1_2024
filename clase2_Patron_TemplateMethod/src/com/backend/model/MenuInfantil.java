package com.backend.model;

public class MenuInfantil extends Menu {
    private int cantidadJuguetes;
    private final double PRECIOJUGUETE = 3.0;

    public MenuInfantil(double precioBase, int cantidadJuguetes) {
        super(precioBase);
        this.cantidadJuguetes = cantidadJuguetes;
    }

    public int getCantidadJuguetes() {
        return cantidadJuguetes;
    }


    public double getPRECIOJUGUETE() {
        return PRECIOJUGUETE;
    }
}
