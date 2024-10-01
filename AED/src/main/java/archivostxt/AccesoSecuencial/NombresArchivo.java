package archivostxt;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Jonathan
 */
public class NombresArchivo {
    public static void main(String[] args) {
        String[] nombres = {"Paco", "Juan", "Estefanía", "Oscar", "Steve"};
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("nombres.txt"))) {
            for (String nombre : nombres) {
                writer.write(nombre + " ");
            }
            
        } catch (IOException e) {
            System.out.println("Ha habido un error");
            e.printStackTrace();
        }
    }
}
