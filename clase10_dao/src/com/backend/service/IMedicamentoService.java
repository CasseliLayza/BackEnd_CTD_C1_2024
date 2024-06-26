package com.backend.service;

import com.backend.entity.Medicamento;

public interface IMedicamentoService {
    Medicamento registarMedicamento(Medicamento medicamento);
    Medicamento buscarMedicamentoPorId(Long id);
}
