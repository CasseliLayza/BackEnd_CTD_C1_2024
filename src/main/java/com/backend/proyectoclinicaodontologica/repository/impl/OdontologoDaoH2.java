package com.backend.proyectoclinicaodontologica.repository.impl;

import com.backend.proyectoclinicaodontologica.dbconnection.H2Connection;
import com.backend.proyectoclinicaodontologica.entity.Odontologo;
import com.backend.proyectoclinicaodontologica.repository.IDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoH2 implements IDao<Odontologo> {

    private final Logger LOGGER = LoggerFactory.getLogger(OdontologoDaoH2.class);

    @Override
    public Odontologo registrar(Odontologo odontologo) {

        String insert = "INSERT INTO ODONTOLOGOS(MATRICULA, NOMBRE, APELLIDO)VALUES(?, ?, ?)";

        Connection connection = null;
        Odontologo odontologoRegistrado = null;

        try {
            connection = H2Connection.getConnection();
            connection.setAutoCommit(false);

            PreparedStatement preparedStatement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, odontologo.getMatricula());
            preparedStatement.setString(2, odontologo.getNombre());
            preparedStatement.setString(3, odontologo.getApellido());
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            odontologoRegistrado = new Odontologo(odontologo.getMatricula(), odontologo.getNombre(), odontologo.getApellido());

            while (resultSet.next()) {
                odontologoRegistrado.setId(resultSet.getLong(1));
            }
            connection.commit();
            LOGGER.info("Odontologo registrado en H2: " + odontologoRegistrado);

        } catch (Exception e) {
            LOGGER.error("Hubo un problema" + e.getMessage());
            e.printStackTrace();

            if (connection != null) {
                try {
                    connection.rollback();
                    LOGGER.error("Tuvimos un problema realizando rollback.. " + e.getMessage());
                    e.printStackTrace();
                } catch (SQLException exception) {
                    LOGGER.error(exception.getMessage());
                    exception.printStackTrace();
                }
            }
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                LOGGER.error("No se pudo cerrar la conexion de la DB: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return odontologoRegistrado;

    }

    @Override
    public Odontologo buscarPorId(Long id) {
        return null;
    }


    @Override
    public List<Odontologo> listarTodos() {

        String selectAll = "SELECT * FROM ODONTOLOGOS";
        List<Odontologo> odontologos = new ArrayList<>();
        Connection connection = null;

        try {
            connection = H2Connection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(selectAll);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Odontologo odontologo = conformandoObjetoOdontologo(resultSet);
                odontologos.add( odontologo);

            }

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();

        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                LOGGER.error("Ha ocurrido un error al intentar cerrar la conexion a la DB. " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        LOGGER.info("Listado de todos los odontologos en H2:\n " + odontologos);

        return odontologos;


    }

    private Odontologo conformandoObjetoOdontologo(ResultSet resultSet) throws SQLException {
        Odontologo odontologo = new Odontologo(resultSet.getLong("ID"), resultSet.getString("MATRICULA"),
                resultSet.getString("NOMBRE"), resultSet.getString("APELLIDO"));
        return odontologo;
    }


}
