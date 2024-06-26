package com.backend.repository.imp;

import com.backend.entity.Medicamento;
import com.backend.repository.IDao;
import com.backend.repository.dnconnection.H2Connection;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MedicamentoDaoH2 implements IDao<Medicamento> {
    private static final Logger logger = Logger.getLogger(MedicamentoDaoH2.class);

    @Override
    public Medicamento registrar(Medicamento medicamento) {
        String insert = "INSERT INTO MEDICAMENTOS(CODIGO,NOMBRE,LABORATORIO,CANTIDAD,PRECIO) VALUES(?,?,?,?,?)";
        Connection connection = null;
        Medicamento medicamentoRegistrado = null;

        try {
            connection = H2Connection.getConnection();
            connection.setAutoCommit(false);

            PreparedStatement preparedStatement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setInt(1, medicamento.getCodigo());
            preparedStatement.setString(2, medicamento.getNombre());
            preparedStatement.setString(3, medicamento.getLaboratorio());
            preparedStatement.setInt(4, medicamento.getCantidad());
            preparedStatement.setDouble(5, medicamento.getCodigo());

            preparedStatement.execute();

            //connection.commit();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                medicamentoRegistrado = new Medicamento(resultSet.getLong("id"), medicamento.getCodigo(), medicamento.getNombre(),
                        medicamento.getLaboratorio(), medicamento.getCantidad(), medicamento.getPrecio());

            }

            connection.commit();
            logger.info("Medicamento registrado: \t=>> " + medicamentoRegistrado);

            connection.setAutoCommit(true);

        } catch (Exception e) {
            logger.error(e.getClass());
            e.printStackTrace();
            if (connection != null) {
                try {
                    connection.rollback();
                    logger.error("Tuvimos un problema : " + e.getMessage());
                    e.printStackTrace();
                } catch (SQLException exception) {
                    logger.error((exception.getMessage()));
                    exception.printStackTrace();
                } finally {
                    try {
                        connection.close();
                    } catch (Exception ex) {
                        logger.error(" No se puedo cerrar la conexion: " + ex.getMessage());
                    }

                }
            }


        }

        return medicamentoRegistrado;
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
                medicamentoEncontrado = new Medicamento(resultSet.getLong("id"), resultSet.getInt("codigo"), resultSet.getString("nombre"),
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
            logger.info("Se ha encontrado el medicamento con ID=" + medicamentoEncontrado.getId() + ": \t=>> " + medicamentoEncontrado);
        } else {
            logger.info("NO ha encontrado el medicamento con id: " + id);

        }

        return medicamentoEncontrado;
    }

    Map<Long, Medicamento> medicamentoList = new HashMap<>();

    @Override
    public Map<Long, Medicamento> listarAllMedicamentos() {
        String selectAll = "SELECT * FROM MEDICAMENTOS";

        Connection connection = null;
        //List<Medicamento> medicamentoList = new ArrayList<>();

        try {
            connection = H2Connection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectAll);

            logger.info("Lista de todos los elementos:--------------------|");
            while (resultSet.next()) {
                //medicamentoList.add(new Medicamento(resultSet.getLong("id"), resultSet.getInt("codigo"), resultSet.getString("nombre"),
                //resultSet.getString("laboratorio"), resultSet.getInt("cantidad"), resultSet.getDouble("precio")));
                medicamentoList.put(resultSet.getLong("id"), (new Medicamento(resultSet.getLong("id"), resultSet.getInt("codigo"), resultSet.getString("nombre"),
                        resultSet.getString("laboratorio"), resultSet.getInt("cantidad"), resultSet.getDouble("precio"))));

                logger.info("ID : " + resultSet.getLong("id") + " { " + resultSet.getInt("codigo") + " : " + resultSet.getString("nombre") + " : " + resultSet.getString("laboratorio") + " : " + resultSet.getInt("cantidad") + " : " + resultSet.getDouble("precio") + " }");
            }
            logger.info("Lista de todos los elementos:--------------------|");
            logger.info("Lista de todos los elementos :" + medicamentoList);

        } catch (Exception e) {
            logger.error("Error de conexion DB", e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error("Error de no se puedo cerrar la conexion DB", e);

            }
        }

        return medicamentoList;
    }

    @Override
    public String deleteById(Long id) {
        Connection connection = null;
        int response = 0;

        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:~/clase8c1b2", "casseli", "qwerty");
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM MEDICAMENTOS WHERE ID=?");
            //preparedStatement.setLong(1, id);

            response = preparedStatement.executeUpdate();
            if ((response > 0)) {
                logger.info(response + "row afected");
            } else {
                logger.info("Register con ID=" + id + " not found");
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

        return (response > 0) ? response + "row affected" : "Not found register";

    }
}
