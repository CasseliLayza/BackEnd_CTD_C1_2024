package com.backend.service.facade.imp;

import com.backend.model.ServicioVuelo;

import java.util.Date;

public class BusquedaVuelo {

    public String busquedaDisVuelo( ServicioVuelo vuelo, Date  fechaBusqueda, String origen, String destino){

        return vuelo.getFechaSalida().isBefore(fechaBusqueda)
    }

}
