package aed.inyeccion;

import java.sql.DriverManager;
import java.sql.*;

public class DatosBichados {

    private static final String URL = "jdbc:mariadb://localhost:3306/seguridad";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}
