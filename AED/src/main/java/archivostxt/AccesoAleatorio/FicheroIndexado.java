/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package archivostxt.AccesoAleatorio;

import java.io.IOException;
import java.io.RandomAccessFile;

public class FicheroIndexado {
    
    public static void main(String[] args) {
        try (RandomAccessFile file = new RandomAccessFile("ejemplo_fichero.bin", "rw")) {
            AddRegister(file, 1, "Juan", (short) 25, 2500.50f);
            AddRegister(file, 2, "Ana", (short) 30, 3000.75f);
            AddRegister(file, 3, "Carlos", (short) 40, 4500.00f);
            AddRegister(file, 4, "Luisa", (short) 22, 2000.00f);
            AddRegister(file, 5, "Pedro", (short) 35, 3800.80f);
            
            leerTodosRegistros(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void AddRegister(RandomAccessFile contactos, int ID, String nombre, short edad, float salario) throws IOException {
        // Mover el puntero al final del archivo para agregar un nuevo registro
            contactos.seek(contactos.length());

            // Escribir el nuevo registro al final del archivo
            contactos.writeInt(ID);        // Escribir el ID (4 bytes)
            contactos.writeChars(nombre);    // Escribir la Edad (2 bytes)
            contactos.writeShort(edad);
            contactos.writeFloat(salario); // Escribir el Salario (4 bytes)

    }
    
    public static void leerTodosRegistros(RandomAccessFile file) throws IOException {
        // Tamaño de cada registro: ID (4 bytes) + Nombre (40 bytes) + Edad (2 bytes) + Salario (4 bytes) = 50 bytes
        int tamanoRegistro = 50;

        // Calcular la cantidad de registros en el archivo
        long numRegistros = file.length() / tamanoRegistro;

        // Bucle para leer todos los registros
        for (int i = 0; i < numRegistros; i++) {
            // Mover el puntero al inicio del registro actual
            file.seek(i * tamanoRegistro);

            // Leer el ID (4 bytes)
            int id = file.readInt();

            // Leer el Nombre (40 bytes, 20 caracteres de 2 bytes cada uno)
            char[] nombreChars = new char[20];
            for (int j = 0; j < 20; j++) {
                nombreChars[j] = file.readChar();
            }
            String nombre = new String(nombreChars).trim(); // Eliminar los espacios al final

            // Leer la Edad (2 bytes)
            short edad = file.readShort();

            // Leer el Salario (4 bytes)
            float salario = file.readFloat();

            // Imprimir el registro leído
            System.out.println("Registro #" + (i + 1));
            System.out.println("ID: " + id);
            System.out.println("Nombre: " + nombre);
            System.out.println("Edad: " + edad);
            System.out.println("Salario: " + salario);
            System.out.println("--------------------------");
        }
    }
}

