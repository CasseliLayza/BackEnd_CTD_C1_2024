package com.backend.service.imp;

import com.backend.entity.Medicamento;
import com.backend.repository.IDao;
import com.backend.service.IMedicamentoService;

public class MedicamentoService implements IMedicamentoService {

    private IDao<Medicamento> medicamentoIDao;

    public MedicamentoService(IDao<Medicamento> medicamentoIDao) {
        this.medicamentoIDao = medicamentoIDao;
    }


    @Override
    public Medicamento registarMedicamento(Medicamento medicamento) {
        // alguna logica de negocio
        return medicamentoIDao.registrar(medicamento);
    }

    @Override
    public Medicamento buscarMedicamentoPorId(Long id) {
        return medicamentoIDao.buscarPorId(id);
    }
}
