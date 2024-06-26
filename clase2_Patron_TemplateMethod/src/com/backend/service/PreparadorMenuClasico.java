package com.backend.service;

import com.backend.model.Menu;
import com.backend.model.MenuClasico;

public class PreparadorMenuClasico extends PreparadorMenu {
    @Override
    protected String armarMenu(Menu menu) {
        return "Menu Clasico";
    }

    @Override
    protected double calcularPrecioMenu(Menu menu) {
        return (menu instanceof MenuClasico menuClasico) ? menuClasico.getPrecioBase() : 0;
    }
}
