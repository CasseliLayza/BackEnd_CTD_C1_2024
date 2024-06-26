package com.backend.repository;

public interface IDao <T> {
    T registrar(T t);
    T bucarPorId(Long id);
    List<T> listarTodo();
}
