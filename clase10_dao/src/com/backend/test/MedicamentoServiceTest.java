package com.backend.test;

import com.backend.entity.Medicamento;
import com.backend.repository.imp.MedicamentoDaoH2;
import com.backend.service.imp.MedicamentoService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedicamentoServiceTest {

    private MedicamentoService medicamentoService;

    @Test
    void deberiaRegistaraUnMedicamentoYMeRetornaElId() {
        //array
        medicamentoService = new MedicamentoService(new MedicamentoDaoH2());
        Medicamento medicamentoAPersistir = new Medicamento(2558, "Aspirina", "Bayer", 50, 1500);

        //act
        Medicamento medicamentoPersistido = medicamentoService.registarMedicamento(medicamentoAPersistir);

        //asset
        assertNotNull(medicamentoPersistido.getId());


    }

}