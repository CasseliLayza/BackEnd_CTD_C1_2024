package com.backend.parcial.service.imp;

import com.backend.parcial.entity.Medicamento;
import com.backend.parcial.repository.coneccionJDBC.ConeccionH2;
import com.backend.parcial.repository.imp.MediH2;

public class Application {
    public static void main(String[] args) {
        //ConeccionH2.crearTable();

        MediH2 mediH2 = new MediH2();
        Medicamento medicamento = new Medicamento("123rghjk","Panadol","Bells",20,1.50);
        mediH2.registar(medicamento);
        mediH2.buscarPorId(1L);
        mediH2.listarAll();



    }
}
