package archivostxt;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
/**
 *
 * @author Jonathan
 */
public class CrearArchivo {
    
    public static void main(String[] args) {
        // Pedimos el nombre del archivo a crear
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el nombre del archivo: ");
        String nombre_archivo = scanner.nextLine();
        
        // Asignamos ese nombre a un objeto File con la extensión txt
        File archivo = new File(nombre_archivo + ".txt");
        
        try {
            // Si no existe lo creamos
            if (archivo.createNewFile()) {
                System.out.println("Se ha creado: " + archivo.getName());
            } else {
                System.out.println("El archivo ya existe.");
            }
        } catch (IOException e) {
            System.out.println("Ocurrio un erorr ");
            e.printStackTrace();
        }
                
    }
}
