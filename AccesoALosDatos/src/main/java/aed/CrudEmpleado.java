package aed;

import java.math.BigDecimal;
import java.sql.*;

public class CrudEmpleado {

    private final String url = "jdbc:mariadb://localhost:3306/gestion_empleados";
    private final String user = "root";
    private final String password = "";
    private Connection con;

    public CrudEmpleado() {
        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión realizada con éxito.");
        } catch (SQLException ex) {
            System.out.println("Ha ocurrido algún error: " + ex.getMessage());
        }
    }

    public Connection getConnection() {
        return con;
    }



    public void createEmpleado(int id, String nombre, String apellido, String email, BigDecimal salario, Date fechaContratacion) {
        String insertQuery = "INSERT INTO empleados (id, nombre, apellido, email, salario, fecha_contratacion) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(insertQuery)) {
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, nombre);
            preparedStatement.setString(3, apellido);
            preparedStatement.setString(4, email);
            preparedStatement.setBigDecimal(5, salario);
            preparedStatement.setDate(6, fechaContratacion);

            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Empleado creado. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            System.err.println("Error al crear empleado: " + e.getMessage());
        }
    }

    public void readEmpleadoById(int id) {
        String query = "SELECT * FROM empleados WHERE id = ?";

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Nombre: " + resultSet.getString("nombre"));
                System.out.println("Apellido: " + resultSet.getString("apellido"));
                System.out.println("Email: " + resultSet.getString("email"));
                System.out.println("Salario: " + resultSet.getBigDecimal("salario"));
                System.out.println("Fecha de Contratación: " + resultSet.getDate("fecha_contratacion"));
            } else {
                System.out.println("Empleado no encontrado.");
            }

        } catch (SQLException e) {
            System.err.println("Error al leer empleado: " + e.getMessage());
        }
    }

    public void updateEmpleado(int id, String nombre, String apellido, String email, BigDecimal salario, Date fechaContratacion) {
        String updateQuery = "UPDATE empleados SET nombre = ?, apellido = ?, email = ?, salario = ?, fecha_contratacion = ? WHERE id = ?";

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(updateQuery)) {

            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, apellido);
            preparedStatement.setString(3, email);
            preparedStatement.setBigDecimal(4, salario);
            preparedStatement.setDate(5, fechaContratacion);
            preparedStatement.setInt(6, id);

            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Empleado actualizado. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            System.err.println("Error al actualizar empleado: " + e.getMessage());
        }
    }

    public void deleteEmpleado(int id) {
        String deleteQuery = "DELETE FROM empleados WHERE id = ?";

        try (PreparedStatement preparedStatement = getConnection().prepareStatement(deleteQuery)) {

            preparedStatement.setInt(1, id);

            int filasAfectadas = preparedStatement.executeUpdate();
            System.out.println("Empleado eliminado. Filas afectadas: " + filasAfectadas);

        } catch (SQLException e) {
            System.err.println("Error al eliminar empleado: " + e.getMessage());
        }
    }

    public static void main(String[] args) throws SQLException {
        CrudEmpleado crudEmpleado = new CrudEmpleado();
        crudEmpleado.readEmpleadoById(1);
        crudEmpleado.getConnection().close();
    }
}
