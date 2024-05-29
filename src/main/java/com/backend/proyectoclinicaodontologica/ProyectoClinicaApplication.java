package com.backend.proyectoclinicaodontologica;

import com.backend.proyectoclinicaodontologica.dbconnection.H2Connection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ProyectoClinicaApplication {
	private static Logger LOGGER = LoggerFactory.getLogger(ProyectoClinicaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ProyectoClinicaApplication.class, args);
		LOGGER.info("Proyecto Clinica Odontologica INIT....");
		H2Connection.ejecutarScriptInicial();
	}

	@GetMapping("/hola")
	public String saludar(){
		return "hola clinica";
	}

}
