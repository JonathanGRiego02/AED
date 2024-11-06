package aed.poolconexiones;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DBCPDataSource {

    // Instancia única del DataSource
    private static BasicDataSource dataSource;

    // Configuración inicial del pool de conexiones
    static {
        dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mariadb://localhost:3306/seguridad"); // Cambia "empresa" por tu nombre de base de datos
        dataSource.setUsername("root"); // Cambia "usuario" por tu nombre de usuario de la base de datos
        dataSource.setPassword(""); // Cambia "contraseña" por la contraseña de la base de datos

        // Configuración del pool de conexiones
        dataSource.setMinIdle(5); // Número mínimo de conexiones inactivas en el pool
        dataSource.setMaxIdle(10); // Número máximo de conexiones inactivas en el pool
        dataSource.setMaxTotal(20); // Número máximo de conexiones activas en el pool
        dataSource.setMaxWaitMillis(10000); // Tiempo de espera máximo para obtener una conexión (en milisegundos)
    }

    // Método para obtener una conexión del pool
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    // Método para cerrar el DataSource
    public static void close() {
        try {
            if (dataSource != null) {
                dataSource.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}