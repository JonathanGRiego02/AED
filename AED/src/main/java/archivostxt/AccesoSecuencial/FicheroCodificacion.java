package archivostxt;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author Jonathan
 */
public class FicheroCodificacion {
    public static void main(String[] args) {
        try (Writer writer = new OutputStreamWriter(new FileOutputStream("prueba.txt"), StandardCharsets.UTF_8)) {
            writer.write("¡Me encanta DAM :)!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
