package com.backend.parcial.repository.imp;

import com.backend.parcial.entity.Medicamento;
import com.backend.parcial.repository.IDOA;
import com.backend.parcial.repository.coneccionJDBC.ConeccionH2;
import org.apache.log4j.Logger;
import org.h2.Driver;

import java.sql.*;
import java.util.*;


public class MediH2 implements IDOA<Medicamento> {
    private static final Logger LOGGER = Logger.getLogger(MediH2.class);

    @Override
    public Medicamento registar(Medicamento medicamento) {

        Connection connection = null;
        Medicamento medicamentoRegitrado = null;

        String insert = "INSERT INTO MEDICAMENTOS(CODIGO,NOMBRE,LABORATORIO,CANTIDAD,PRECIO) VALUES(?,?,?,?,?)";


        try {
            connection = ConeccionH2.getConnetion();
            connection.setAutoCommit(false);
            //Statement statement = connection.createStatement();
            //statement.execute(create);
            PreparedStatement preparedStatement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, medicamento.getCodigo());
            preparedStatement.setString(2, medicamento.getNombre());
            preparedStatement.setString(3, medicamento.getLaboratorio());
            preparedStatement.setInt(4, medicamento.getCantidad());
            preparedStatement.setDouble(5, medicamento.getPrecio());
            preparedStatement.execute();

            connection.commit();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                medicamentoRegitrado = new Medicamento(resultSet.getLong("id"), medicamento.getCodigo(),
                        medicamento.getNombre(), medicamento.getLaboratorio(), medicamento.getCantidad(), medicamento.getPrecio());


            }


            LOGGER.info(" Medicamento registrado => :" + medicamentoRegitrado);

            connection.setAutoCommit(true);


        } catch (Exception e) {
            LOGGER.error("Ocurrio un problema" + e.getMessage());
            //throw new RuntimeException(e);
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                LOGGER.error("Ocurrio un problema no se pudo cerrar la conexion" + ex.getMessage());
                ex.printStackTrace();
                //    throw new RuntimeException(e);
            }
        }


        return medicamentoRegitrado;
    }

    @Override
    public Medicamento buscarPorId(Long id) {

        Connection connection = null;
        Medicamento medicamentoEncontrado = null;

        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:~/clase8c1b2", "casseli", "qwerty");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM MEDICAMENTOS WHERE ID=?");

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                medicamentoEncontrado = new Medicamento(resultSet.getLong("id"), resultSet.getString("codigo"), resultSet.getString("nombre"),
                        resultSet.getString("laboratorio"), resultSet.getInt("cantidad"), resultSet.getDouble("precio"));
            }


        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }


        }


        if (medicamentoEncontrado != null) {
            LOGGER.info("Se ha encontrado el medicamento con ID=" + medicamentoEncontrado.getId() + ": \t=>> " + medicamentoEncontrado);
        } else {
            LOGGER.info("NO ha encontrado el medicamento con id: " + id);

        }

        return medicamentoEncontrado;
    }


    @Override
//    public Map<Long, Medicamento> listarAll() {
    public List<Medicamento> listarAll() {
        String selectAll = "SELECT * FROM MEDICAMENTOS";

        Connection connection = null;
        //Map<Long, Medicamento> medicamentoList = new HashMap<>();
        List<Medicamento> medicamentoList = new ArrayList<>();

        try {
            connection = ConeccionH2.getConnetion();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectAll);

            LOGGER.info("Lista de todos los elementos:--------------------|");
            while (resultSet.next()) {
                //medicamentoList.add(new Medicamento(resultSet.getLong("id"), resultSet.getInt("codigo"), resultSet.getString("nombre"),
                //resultSet.getString("laboratorio"), resultSet.getInt("cantidad"), resultSet.getDouble("precio")));
               // medicamentoList.put(resultSet.getLong("id"), (new Medicamento(resultSet.getLong("id"), resultSet.getString("codigo"), resultSet.getString("nombre"),
                medicamentoList.add((new Medicamento(resultSet.getLong("id"), resultSet.getString("codigo"), resultSet.getString("nombre"),
                        resultSet.getString("laboratorio"), resultSet.getInt("cantidad"), resultSet.getDouble("precio"))));

                LOGGER.info("ID : " + resultSet.getLong("id") + " { " + resultSet.getString("codigo") + " : " + resultSet.getString("nombre") + " : " + resultSet.getString("laboratorio") + " : " + resultSet.getInt("cantidad") + " : " + resultSet.getDouble("precio") + " }");
            }
            LOGGER.info("Lista de todos los elementos:--------------------|");
            LOGGER.info("Lista de todos los elementos :" + medicamentoList);

            for (Medicamento m:medicamentoList) {
                LOGGER.info("Medicamento => " + m);
            }


        } catch (Exception e) {
            LOGGER.error("Error de conexion DB", e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                LOGGER.error("Error de no se puedo cerrar la conexion DB", e);

            }
        }

        return medicamentoList;
    }







}
