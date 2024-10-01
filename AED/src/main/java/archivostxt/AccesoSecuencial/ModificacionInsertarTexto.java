package archivostxt;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 *
 * @author Jonathan
 */
public class ModificacionInsertarTexto {
    public static void main(String[] args) {
        try (Writer writer = new OutputStreamWriter(new FileOutputStream("mis_memorias.txt", true), StandardCharsets.UTF_8)) {
            String texto;
            Scanner scanner = new Scanner(System.in);
            while (!(texto = scanner.nextLine()).isEmpty()) {
                writer.write(texto + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
