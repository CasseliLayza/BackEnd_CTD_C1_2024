package com.backend.model;

public class Usuario {

    private String id;
    private TipoUsuario tipoUsuario;

    public Usuario(String id, TipoUsuario tipoUsuario) {
        this.id = id;
        this.tipoUsuario = tipoUsuario;
    }

    public String getId() {
        return id;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

}
