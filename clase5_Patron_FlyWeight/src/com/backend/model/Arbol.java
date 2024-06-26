package com.backend.model;

public class Arbol {
    private int alto;
    private int ancho;
    private String color;
    private String tipo;

    private static int contador;

    public Arbol(int alto, int ancho, String color, String tipo) {
        this.alto = alto;
        this.ancho = ancho;
        this.color = color;
        this.tipo = tipo;
        contador++;
        System.out.println("Existencias: " + contador);
    }

    @Override
    public String toString() {
        return "Arbol:" +
                "-alto " + alto +
                "-ancho " + ancho +
                "-color " + color;
    }

}
