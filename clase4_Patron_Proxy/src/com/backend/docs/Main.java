package com.backend.docs;

import com.backend.model.TipoUsuario;
import com.backend.model.Usuario;
import com.backend.service.impl.ServicioDescargaProxy;

public class Main {
    public static void main(String[] args) {
        Usuario casseli= new Usuario("7777777777 ", TipoUsuario.PREMIUM);
        Usuario Sedundo= new Usuario("8888888888 ", TipoUsuario.FREE);

        ServicioDescargaProxy servicioDescargaProxy = new ServicioDescargaProxy();

        servicioDescargaProxy.descargar(casseli);
        servicioDescargaProxy.descargar(Sedundo);
    }
}
