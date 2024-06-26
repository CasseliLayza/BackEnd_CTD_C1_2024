package com.backend.parcial.repository.coneccionJDBC;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConeccionH2 {
    public static Connection getConnetion() throws Exception {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/clase8c1b2", "casseli", "qwerty");
    }


    public static void crearTable() {
        Connection connection = null;

        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:~/clase8c1b2;INIT=RUNSCRIPT FROM 'script.sql'", "casseli", "qwerty");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception esql) {
                esql.printStackTrace();
            }
        }

    }


}
