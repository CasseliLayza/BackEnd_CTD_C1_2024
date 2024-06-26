package com.backend.service;

import com.backend.model.Arbol;

import java.util.HashMap;
import java.util.Map;

public class ArbolFactory {
    private static Map<String, Arbol> bosque = new HashMap<>();
    private static int units;


    public static Arbol plantarArboles(int alto, int ancho, String color, String tipo) {
        // definir la Key
        String key = alto + ":" + ancho + ":" + color;
        System.out.println("key = " + key);

        if (!bosque.containsKey(key)) {
            Arbol arbol = new Arbol(alto, ancho, color, tipo);
            bosque.put(key, arbol);
            System.out.println(" Arbol Plantado");
            units++;
        } else {
            System.out.println("Arbol recuperado");

        }
        return bosque.get(key);
    }

    public static Map<String, Arbol> getBosque() {
        return bosque;
    }

    public static int getUnits() {
        return units;
    }

}
