package com.backend.repository;

import java.util.Map;

public interface IDao<T> {
    T registrar(T t);
    T buscarPorId(Long id);

    //mejoras
    Map<Long,T> listarAllMedicamentos();

     String deleteById(Long id);
}
