package aed;

import java.sql.*;

public class Instituto {
    public static void main(String[] args) {
        Connection con;
        String url = "jdbc:mariadb://localhost:3306/instituto";
        try {

            con = DriverManager.getConnection(url, "root", "");
            System.out.println("Conexión realizada con éxito.");

            String query = "SELECT * FROM alumnos";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("num") + ", Nombre: " + rs.getString("nombre"));
            }

            con.close();

            System.out.println("Conexión cerrada.");

        } catch (SQLException ex) {
            System.out.println("Ha ocurrido algún error: " + ex.getMessage());
        }

    }
}
