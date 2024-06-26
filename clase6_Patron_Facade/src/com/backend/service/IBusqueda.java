package com.backend.service;

import com.backend.model.ServicioHotel;
import com.backend.model.ServicioVuelo;

public interface IBusqueda {

    String busquedaServicio(ServicioVuelo servicioVuelo, ServicioHotel servicioHotel);

}
