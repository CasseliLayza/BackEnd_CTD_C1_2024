package com.backend.service;

import com.backend.model.Menu;
import com.backend.model.MenuInfantil;

public class PreparadorMenuIfantil extends PreparadorMenu {

    @Override
    protected String armarMenu(Menu menu) {
        return (menu instanceof MenuInfantil menuInfantil) ? "Menu Infantil, cantidad de jugos " + String.valueOf(menuInfantil.getCantidadJuguetes()) : "No aplica preparado";

    }

    @Override
    protected double calcularPrecioMenu(Menu menu) {
        return (menu instanceof MenuInfantil menuInfantil) ? menuInfantil.getPrecioBase() + menuInfantil.getCantidadJuguetes() * menuInfantil.getPRECIOJUGUETE() : 0;

    }

}
