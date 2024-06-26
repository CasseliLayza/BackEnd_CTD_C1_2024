package com.backend.test;

import com.backend.model.TipoUsuario;
import com.backend.model.Usuario;
import com.backend.service.impl.ServicioDescargaProxy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServicioDescargaProxyTest {


    @Test
    void validateIfCustomerIsPremium() {

        //arrange
        Usuario casseli = new Usuario("7777", TipoUsuario.PREMIUM);
        ServicioDescargaProxy servicioDescargaProxy = new ServicioDescargaProxy();
        String responseActual = servicioDescargaProxy.descargar(casseli);

        //actual
        String responseEsperado = "Descarga exitosa 7777 PREMIUM";

        //assert
        assertEquals(responseEsperado, responseActual);


    }

    @Test
    void validateIfCustomerIsFree() {

        //arrange
        Usuario segundo = new Usuario("8888888888", TipoUsuario.FREE);
        ServicioDescargaProxy servicioDescargaProxy = new ServicioDescargaProxy();
        String responseEsperado = "No puedes descargar :(, susbcribete a al plan Premium 8888888888 FREE";

        //actual
        String responseActual = servicioDescargaProxy.descargar(segundo);

        //assert
        assertEquals(responseEsperado, responseActual);


    }

}