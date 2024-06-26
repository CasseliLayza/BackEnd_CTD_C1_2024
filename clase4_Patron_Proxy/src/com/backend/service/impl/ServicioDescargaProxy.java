package com.backend.service.impl;

import com.backend.model.TipoUsuario;
import com.backend.model.Usuario;
import com.backend.service.SpotifyPremium;

public class ServicioDescargaProxy implements SpotifyPremium {
    private ServicioDescarga servicioDescarga;

    @Override
    public String descargar(Usuario usuario) {

        //controlar membresia
        String respuesta = "No puedes descargar :(, susbcribete a al plan Premium " + usuario.getId()+" " + usuario.getTipoUsuario();
        if (validarMembresia(usuario)) {
            servicioDescarga = new ServicioDescarga();
            respuesta = servicioDescarga.descargar(usuario);
        }

        System.out.println("respuesta = " + respuesta);

        return respuesta;
    }

    private boolean validarMembresia(Usuario usuario) {
        return usuario.getTipoUsuario().equals(TipoUsuario.PREMIUM);
    }

}
