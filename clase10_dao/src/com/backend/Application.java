package com.backend;

import com.backend.entity.Medicamento;
import com.backend.repository.imp.MedicamentoDaoH2;

public class Application {
    public static void main(String[] args) {
        //H2Connection.crearTabal();
        Medicamento medicamento = new Medicamento(2558, "Aspirina", "Bayer", 50, 1500);
        MedicamentoDaoH2 medicamentoDaoH2 = new MedicamentoDaoH2();
        medicamentoDaoH2.registrar(medicamento);
        medicamentoDaoH2.buscarPorId(3L);
        medicamentoDaoH2.buscarPorId(30L);

        //mejoras
        medicamentoDaoH2.listarAllMedicamentos();
        //medicamentoDaoH2.deleteById(4L);
        //medicamentoDaoH2.listarAll();

/*        MedicamentoService medicamentoService = new MedicamentoService(new MedicamentoDaoH2());
        medicamentoService.registarMedicamento(medicamento);
        medicamentoService.buscarMedicamentoPorId(4L);*/


    }
}
