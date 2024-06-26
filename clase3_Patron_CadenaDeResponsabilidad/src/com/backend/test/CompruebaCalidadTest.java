package com.backend.test;

import com.backend.model.Articulo;
import com.backend.service.CompruebaCalidad;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CompruebaCalidadTest {
    private final CompruebaCalidad compruebaCalidad= new CompruebaCalidad();

    @Test
    void validacionCorretaDeArticuloConLosStandaresDeProduccion() {
        //arrage
        String respuestaEsperada = "Aceptado";
        //act
        String respuestaObtenida = compruebaCalidad.validarCalidadDelProducto(new Articulo("Motor", 1000, 1200, "sano"));

        //assert
        assertEquals(respuestaEsperada, respuestaObtenida);
    }

    @Test
    void validacionIncorretaDeArticuloConLosNoStandaresDeProduccion() {
        //arrage
        String respuestaEsperada = "Rechazado";
        //act
        String respuestaObtenida = compruebaCalidad.validarCalidadDelProducto(new Articulo("Motor", 1000, 100, "dañado"));

        //assert
        assertEquals(respuestaEsperada, respuestaObtenida);
    }
}