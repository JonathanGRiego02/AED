import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Jonathan
 */
public class NumeroLineas {
    
    public static void main(String[] args) {
        
        try (BufferedReader reader = new BufferedReader(new FileReader("poema.txt"))) {
            int contador = 0;
            while (reader.readLine() != null) {
                contador++;
            }
            System.out.println("El programa tiene " + contador + "lineas.");
        } catch (IOException e) {
            System.out.println("Ha habido un error");
            e.printStackTrace();
        }
    }
}