/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package archivostxt.AccesoAleatorio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Jonathan
 */
public class EjercicioSeek {
     public static void main(String[] args) {
        // Ruta del fichero
        String nombreFichero = "ejemplo_fichero.bin";

        // Intentamos abrir el fichero con RandomAccessFile
        try (RandomAccessFile fichero = new RandomAccessFile(new File(nombreFichero), "r")) {
            
            // Cabecera de la tabla
            System.out.printf("%-10s %-10s %-10s\n", "ID", "Nombre", "Valor");
            System.out.println("-----------------------------------");

            // Bucle para leer el contenido del fichero
            while (fichero.getFilePointer() < fichero.length()) {
                // Leer los datos desde el fichero. En este ejemplo se asume un formato simple:
                // ID (int), Nombre (String de 10 caracteres), Valor (double)
                int id = fichero.readInt();
                byte[] nombreBytes = new byte[10]; // Asumimos que el nombre tiene 10 caracteres
                fichero.readFully(nombreBytes);
                String nombre = new String(nombreBytes).trim(); // Eliminar espacios en blanco
                double valor = fichero.readDouble();

                // Mostrar la fila leída
                System.out.printf("%-10d %-10s %-10.2f\n", id, nombre, valor);
            }

        } catch (IOException e) {
            System.err.println("Error al leer el fichero: " + e.getMessage());
        }
    }
}
