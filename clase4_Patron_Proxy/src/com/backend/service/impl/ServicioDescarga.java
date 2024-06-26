package com.backend.service.impl;

import com.backend.model.Usuario;
import com.backend.service.SpotifyPremium;

public class ServicioDescarga implements SpotifyPremium {
    @Override
    public String descargar(Usuario usuario) {
        System.out.println("Descarga exitosa " + usuario.getId()+" "+ usuario.getTipoUsuario());
        return  "Descarga exitosa "+usuario.getId()+ " "+usuario.getTipoUsuario();
    }
}
