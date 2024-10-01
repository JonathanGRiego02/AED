/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package archivostxt.AccesoAleatorio;

/**
 *
 * @author Jonathan
 */
import java.io.RandomAccessFile;
import java.io.IOException;

public class FicheroBinario2 {
    private static final int TAMANO_REGISTRO = 10; // Tamaño de cada registro en bytes (4 bytes ID + 2 bytes Edad + 4 bytes Salario)

    public static void main(String[] args) {
        try (RandomAccessFile file = new RandomAccessFile("ejemplo_fichero.bin", "r")) {
            // Mostrar el registro específico (por ejemplo, el tercer registro)
            int numeroRegistro = 3; // Número del registro que se quiere leer (por ejemplo, el tercer registro)
            mostrarRegistroEspecifico(file, numeroRegistro);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para mostrar un registro específico usando su número de registro
    public static void mostrarRegistroEspecifico(RandomAccessFile file, int numeroRegistro) throws IOException {
        // Calcular la posición del registro específico en bytes
        long posicion = TAMANO_REGISTRO * (numeroRegistro - 1);  // Ejemplo: tercer registro -> 10 * (3 - 1) = 20 bytes

        // Verificar si la posición calculada está dentro del tamaño del archivo
        if (posicion >= file.length() || posicion < 0) {
            System.out.println("El registro " + numeroRegistro + " no existe en el archivo.");
            return;
        }

        // Mover el puntero a la posición del registro deseado
        file.seek(posicion);

        // Leer los campos del registro en la posición especificada
        int id = file.readInt();          // Leer ID (4 bytes)
        short edad = file.readShort();    // Leer Edad (2 bytes)
        float salario = file.readFloat(); // Leer Salario (4 bytes)

        // Mostrar el registro leído
        System.out.println("Registro " + numeroRegistro + ": ID: " + id + ", Edad: " + edad + ", Salario: " + salario);
    }
}
