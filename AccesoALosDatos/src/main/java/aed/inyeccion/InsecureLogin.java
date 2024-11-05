package aed.inyeccion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsecureLogin {
    public static boolean login(String username, String password) {
        String query = "SELECT * FROM usuarios WHERE username = '" + username + "' AND (password = '" + password + "')"; // Esto tambien se soluciona poniendo unos parentesis

        try (Connection connection = DatosBichados.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            return resultSet.next(); // Retorna true si existe un usuario con los datos proporcionados
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        if (login(username, password)) {
            System.out.println("Login exitoso.");
        } else {
            System.out.println("Login fallido.");
        }
    }
}