package com.backend.service;

import com.backend.model.Menu;
import com.backend.model.MenuVegetariano;

public class PreparadorMenuVegetariano extends PreparadorMenu {
    @Override
    protected String armarMenu(Menu menu) {
        return (menu instanceof MenuVegetariano menuVegetariano) ? "Menu Vegetariano, cantidad de salsas vegetarianas " + menuVegetariano.getCantidadSalsaVegetariana() + ", cantidad especias "+ menuVegetariano.getCantidadEspecias(): "No aplica preparado";

    }

    @Override
    protected double calcularPrecioMenu(Menu menu) {
        double precio = 0;
        if (menu instanceof MenuVegetariano menuVegetariano) {
            precio = menuVegetariano.getPrecioBase() + menuVegetariano.getCantidadSalsaVegetariana() * menuVegetariano.getPRECIOSALSA();
            precio += precio * menuVegetariano.getADICIONALPORESPECIE() * menuVegetariano.getCantidadEspecias();
        }
        return precio;
    }
}
