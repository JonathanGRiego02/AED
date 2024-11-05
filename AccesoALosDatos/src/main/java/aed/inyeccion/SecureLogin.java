package aed.inyeccion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SecureLogin {
    public static boolean login(String username, String password) {
        String query = "SELECT * FROM usuarios WHERE username = ? AND password = ?";

        try (Connection connection = DatosBichados.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Asignar valores a los parámetros de la consulta
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
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