package archivostxt.AccesoSecuencia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Jonathan
 */
public class ContarPalabras {
     
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("texto_largo.txt"))) {
            String linea;
            int contador = 0;
            while ((linea = reader.readLine()) != null) {
                String[] palabras = linea.split(" ");
                contador += palabras.length;
            }
            System.out.println("El texto tiene " + contador + " palabras.");
        } catch (IOException e) {
            System.out.println("Ha habido un error");
            e.printStackTrace();
        }
    }
}
