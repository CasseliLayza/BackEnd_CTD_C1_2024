package com.backend;

import com.backend.model.Menu;
import com.backend.model.MenuClasico;
import com.backend.model.MenuInfantil;
import com.backend.model.MenuVegetariano;
import com.backend.service.PreparadorMenu;
import com.backend.service.PreparadorMenuClasico;
import com.backend.service.PreparadorMenuIfantil;
import com.backend.service.PreparadorMenuVegetariano;

public class Application {
    public static void main(String[] args) {
        Menu menuInfantil = new MenuInfantil(10,1);
        Menu menuVegetariano = new MenuVegetariano(10,1,1);
        Menu menuClasico = new MenuClasico(10);

        PreparadorMenu preparadorMenuInfantil = new PreparadorMenuIfantil();
        preparadorMenuInfantil.prepararMenu(menuInfantil);
        PreparadorMenu preparadorMenuVegetariano = new PreparadorMenuVegetariano();
        preparadorMenuVegetariano.prepararMenu(menuVegetariano);
        PreparadorMenu preparadorMenuClasico = new PreparadorMenuClasico();
        preparadorMenuClasico.prepararMenu(menuClasico);


    }
}
