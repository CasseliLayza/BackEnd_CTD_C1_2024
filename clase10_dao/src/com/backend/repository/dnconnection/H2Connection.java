package com.backend.repository.dnconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class H2Connection {

    public static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/clase8c1b2", "casseli", "qwerty");
    }


    public static void crearTabal(){
        Connection connection = null;
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:~/clase8c1b2;INIT=RUNSCRIPT FROM create.sql'", "casseli", "qwerty");
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }


        }

    }

}
