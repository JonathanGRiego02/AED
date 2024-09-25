package archivostxt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Jonathan
 */
public class PromedioNumeros {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("numeros.txt"))) {
            String linea;
            int contador = 0;
            float promedio = 0;
            while ((linea = reader.readLine()) != null) {
                promedio += Float.parseFloat(linea);
                contador++;
            }
            System.out.println("El promedio es " + String.format("%.2f", promedio / contador));
        } catch (IOException e) {
            System.out.println("Ha habido un error");
            e.printStackTrace();
        }
    }
}

