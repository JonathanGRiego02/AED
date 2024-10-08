/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aed.crudbinario;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Jonathan
 */
public class Crud {
    private final String path;
    
    public Crud(String _path) {
        this.path = _path;
    }
    
    // Crear un nuevo registro
    public void Create(int id, short edad, float salario) {
        try (RandomAccessFile file = new RandomAccessFile(this.path, "rw")) {
            file.seek(file.length()); // Mover al final del archivo para agregar un nuevo registro
            file.writeInt(id);        // Escribir ID (4 bytes)
            file.writeShort(edad);    // Escribir Edad (2 bytes)
            file.writeFloat(salario); // Escribir Salario (4 bytes)
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Leer y mostrar todos los registros
    public void Read() {
        try (RandomAccessFile file = new RandomAccessFile(this.path, "r")) {
            while (file.getFilePointer() < file.length()) {
                int id = file.readInt();         // Leer ID (4 bytes)
                short edad = file.readShort();   // Leer Edad (2 bytes)
                float salario = file.readFloat();// Leer Salario (4 bytes)

                System.out.println("ID: " + id + ", Edad: " + edad + ", Salario: " + salario);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Actualizar un registro por ID
    public void Update(int searchId, short newEdad, float newSalario) {
        try (RandomAccessFile file = new RandomAccessFile(this.path, "rw")) {
            while (file.getFilePointer() < file.length()) {
                int id = file.readInt();
                if (id == searchId) {
                    file.writeShort(newEdad);    // Actualizar Edad (2 bytes)
                    file.writeFloat(newSalario); // Actualizar Salario (4 bytes)
                    System.out.println("Registro con ID " + searchId + " actualizado.");
                    return;
                } else {
                    file.skipBytes(6); // Saltar Edad (2 bytes) y Salario (4 bytes)
                }
            }
            System.out.println("Registro con ID " + searchId + " no encontrado.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Eliminar un registro por ID (marcar como eliminado)
    public void Delete(int searchId) {
        try (RandomAccessFile file = new RandomAccessFile(this.path, "rw")) {
            // Crear un archivo temporal
            RandomAccessFile tempFile = new RandomAccessFile("temp.dat", "rw");

            while (file.getFilePointer() < file.length()) {
                int id = file.readInt();
                short edad = file.readShort();
                float salario = file.readFloat();

                if (id != searchId) {
                    // Copiar solo los registros que no coinciden con el ID buscado
                    tempFile.writeInt(id);
                    tempFile.writeShort(edad);
                    tempFile.writeFloat(salario);
                }
            }

            // Reemplazar el archivo original por el temporal
            file.setLength(0); // Vaciar el archivo original
            tempFile.seek(0);  // Volver al inicio del archivo temporal

            while (tempFile.getFilePointer() < tempFile.length()) {
                // Copiar los registros del archivo temporal al original
                file.writeInt(tempFile.readInt());
                file.writeShort(tempFile.readShort());
                file.writeFloat(tempFile.readFloat());
            }

            tempFile.close();  // Cerrar el archivo temporal
            System.out.println("Registro con ID " + searchId + " eliminado.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Buscar un registro por ID
    public void Search(int searchId) {
        try (RandomAccessFile file = new RandomAccessFile(this.path, "r")) {
            while (file.getFilePointer() < file.length()) {
                int id = file.readInt();
                short edad = file.readShort();
                float salario = file.readFloat();
                
                if (id == searchId) {
                    System.out.println("Registro encontrado: ID: " + id + ", Edad: " + edad + ", Salario: " + salario);
                    return;
                }
            }
            System.out.println("Registro con ID " + searchId + " no encontrado.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
