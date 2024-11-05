package aed;

import java.sql.*;

public class Animales {
    public static void main(String[] args) {
        Connection con;
        String url = "jdbc:mariadb://localhost:3306/animales";
        try {

            con = DriverManager.getConnection(url, "root", "");
            System.out.println("Conexión realizada con éxito.");

            String query = "SELECT * FROM animales";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);



            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Propietario: " + rs.getInt("propietario") + ", Animal: " + rs.getString("animal") + ", Raza: " + rs.getString("raza"));;
            }

            con.close();

            System.out.println("Conexión cerrada.");

        } catch (SQLException ex) {
            System.out.println("Ha ocurrido algún error: " + ex.getMessage());
        }

    }
}
