package com.backend.test;

import com.backend.model.Menu;
import com.backend.model.MenuInfantil;
import com.backend.model.MenuVegetariano;
import com.backend.service.PreparadorMenu;
import com.backend.service.PreparadorMenuIfantil;
import com.backend.service.PreparadorMenuVegetariano;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PreparadorMenuTest {
    private PreparadorMenu preparadorMenu;

    @Test
    void verificaPreparadoMenuInfantil() {

        //arrange
        Menu menuInfantil = new MenuInfantil(10, 1);
        preparadorMenu = new PreparadorMenuIfantil();
        String responseEsperado = "Menu armando => Menu Infantil, cantidad de jugos 1 => precio de $13.0";
        //actual
        String responseActual = preparadorMenu.prepararMenu(menuInfantil);
        ;

        assertEquals(responseEsperado, responseActual);

    }

    @Test
    void verificaPreparadoMenuVegetariano() {

        //arrange
        Menu menuVegetariano = new MenuVegetariano(10, 1, 1);
        preparadorMenu = new PreparadorMenuVegetariano();

        String responseEsperado = "Menu armando => Menu Vegetariano, cantidad de salsas vegetarianas 1, cantidad especias 1 => precio de $13.2";
        //actual
        String responseActual = preparadorMenu.prepararMenu(menuVegetariano);
        ;

        assertEquals(responseEsperado, responseActual);

    }

    @Test
    void verificaPreparadoNoOKIngresoMenuIncorrecto() {

        //arrange
        Menu menuVegetariano = new MenuVegetariano(10, 1, 1);
        preparadorMenu = new PreparadorMenuIfantil();

        String responseEsperado = "Menu armando => No aplica preparado => precio de $0.0";
        //actual
        String responseActual = preparadorMenu.prepararMenu(menuVegetariano);
        ;

        assertEquals(responseEsperado, responseActual);

    }

}