package aed.poolconexiones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainApplication {

    public static void main(String[] args) {
        // Crear un pool de threads para simular conexiones concurrentes
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        // Ejecutar varias tareas que solicitan conexiones del pool
        for (int i = 0; i < 20; i++) {
            executorService.submit(() -> {
                try (Connection connection = DBCPDataSource.getConnection()) {
                    String query = "SELECT * FROM usuarios LIMIT 1"; // Cambia "tu_tabla" por el nombre real de tu tabla
                    try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                         ResultSet resultSet = preparedStatement.executeQuery()) {
                        while (resultSet.next()) {
                            System.out.println("Resultado: " + resultSet.getString("username")); // Cambia "columna_ejemplo" por el nombre real de tu columna
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
        }

        // Cierra el servicio de ejecución después de que todas las tareas hayan terminado
        executorService.shutdown();

        // Cerrar el pool de conexiones al finalizar el programa
        Runtime.getRuntime().addShutdownHook(new Thread(DBCPDataSource::close));
    }
}