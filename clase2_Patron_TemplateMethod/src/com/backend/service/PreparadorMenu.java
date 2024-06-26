package com.backend.service;

import com.backend.model.Menu;

public abstract class PreparadorMenu {
    public String prepararMenu(Menu menu) {

        //armar
        String armadoMenu = armarMenu(menu);
         //Calculo precio venta
        String precioMenu = Double.toString(calcularPrecioMenu(menu));
        System.out.println("Menu armando => " + armadoMenu + " => precio de $" + precioMenu);

        return "Menu armando => " + armadoMenu + " => precio de $" + precioMenu;
    }

    protected abstract String armarMenu(Menu menu);

    protected abstract double calcularPrecioMenu(Menu menu);


}
