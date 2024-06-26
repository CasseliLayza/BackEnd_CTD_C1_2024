package com.backend.parcial.repository;

import java.util.List;
import java.util.Map;

public interface IDOA<T> {

    T registar(T t);

    T buscarPorId(Long t);

    //mejoras
    //Map<Long,T> listarAll();
    List<T> listarAll();
    //String deleteById(Long id);


}
