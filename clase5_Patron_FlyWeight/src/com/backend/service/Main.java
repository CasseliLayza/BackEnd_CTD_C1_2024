package com.backend.service;
import com.backend.model.Arbol;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        /*Arbol arbolOrnamental = ArbolFactory.plantarArboles(200,400,"verde");
        Arbol arbolFrutal = ArbolFactory.plantarArboles(500,300,"rojo");
        Arbol arbolFloral = ArbolFactory.plantarArboles(100, 200, "celeste");*/

        String arbolOrnamentals = "";
        String arbolFrutals = "";
        Map<String, Arbol> totalArboles = new HashMap<>();

        for (int i = 0; i < 1000000; i++) {
            //Arbol arbol = ArbolFactory.plantarArboles(200, 400, "verde");

            if (i < 500000) {
                arbolOrnamentals = "arbolOrnamentals" + (i + 1);
                totalArboles.put(arbolOrnamentals, ArbolFactory.plantarArboles(200, 400, "verde","Ornamental"));
            }
            if (i > 499999) {
                arbolFrutals = "arbolFrutal" + (i + 1);
                totalArboles.put(arbolFrutals, ArbolFactory.plantarArboles(500, 300, "rojo", "Frutal"));
            }

        }


        System.out.println("Arboles reales => " + ArbolFactory.getUnits());
        System.out.println("Detail description reales => " + ArbolFactory.getBosque());
        System.out.println("Todos los arboles => " + totalArboles.size());

        Runtime runtime = Runtime.getRuntime();
        System.out.println("Memoria usada => " + (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024));


    }
}
