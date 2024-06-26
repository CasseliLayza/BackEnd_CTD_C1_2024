package com.backend.repository.imp;

import com.backend.entity.Domicilio;
import com.backend.repository.IDao;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DomiciloDaoH2 implements IDao <Domicilio>{
  private  final Logger lOGGER = Logger.getLogger(DomiciloDaoH2.class);

  @Override
  public Domicilio registrar(Domicilio domicilio) {

    String insert = "INSERT INTO MEDICAMENTOS(CALLE, NUMERO, LOCALIDAD, PROVINCIA) VALUES(?, ?, ?, ?)";

    Connection connection = null;
    Domicilio domicilioRegistrado = null;

    try {
      connection = H2Connection.getConnection();
      connection.setAutoCommit(false);

      PreparedStatement preparedStatement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
      preparedStatement.setString(1, domicilio.getCalle());
      preparedStatement.setInt(2, domicilio.getNumero());
      preparedStatement.setString(3, domicilio.getLocalidad());
      preparedStatement.setString(4, domicilio.getProvincia());
      preparedStatement.execute();

      //connection.commit();

      ResultSet resultSet = preparedStatement.getGeneratedKeys();

      while (resultSet.next()) {
        domicilioRegistrado = new Medicamento(resultSet.getLong("id"), medicamento.getCodigo(), medicamento.getNombre(), medicamento.getLaboratorio(), medicamento.getCantidad(), medicamento.getPrecio());
      }
      connection.commit();
      LOGG.info("Medicamento guardado: " + domicilioRegistrado);

    } catch (Exception e) {
      LOGGER.error(e.getMessage());
      e.printStackTrace();

      if (connection != null) {
        try {
          connection.rollback();
          LOGGER.error("Tuvimos un problema. " + e.getMessage());
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
        LOGGER.error("No se pudo cerrar la conexion: " + ex.getMessage());
      }
    }
    return domicilioRegistrado;
  }

  @Override
  public Medicamento buscarPorId(Long id) {
    Connection connection = null;
    Medicamento medicamentoEncontrado = null;

    try {
      connection = H2Connection.getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM MEDICAMENTOS WHERE ID = ?");
      preparedStatement.setLong(1, id);

      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        medicamentoEncontrado = new Medicamento(resultSet.getLong(1), resultSet.getInt("codigo"), resultSet.getString("nombre"), resultSet.getString("laboratorio"), resultSet.getInt("cantidad"), resultSet.getDouble("precio"));
      }


    } catch (Exception e) {
      LOGGER.error(e.getMessage());
      e.printStackTrace();
    } finally {
      try {
        connection.close();
      } catch (Exception ex) {
        LOGGER.error("Ha ocurrido un error al intentar cerrar la bdd. " + ex.getMessage());
        ex.printStackTrace();
      }
    }

    if (medicamentoEncontrado != null) LOGGER.info("Se ha encontrado el medicamento " + medicamentoEncontrado);
    else LOGGER.error("No se encontro el medicamento con id " + id);

    return medicamentoEncontrado;


  }

  @Override
  public Domicilio bucarPorId(Long id) {
    return null;
  }

  @Override
  public List<T> listarTodo() {
    return null;
  }
}
