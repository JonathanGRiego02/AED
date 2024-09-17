package archivostxt;

import java.io.File;

/**
 *
 * @author Jonathan
 */
public class ListarArchivos {
    File directorioActual = new File(".");
    String[] listarchivos = directorioActual.list();
    
    if (listarchivos != null) {
        System.out.println();
    }
}
