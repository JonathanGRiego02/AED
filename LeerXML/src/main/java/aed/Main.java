package aed;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Scanner;

public class Main {

    public static void guardarCatalogo(CatalogoLibros catalogo, String archivo) {
        try {
            JAXBContext context = JAXBContext.newInstance(CatalogoLibros.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(catalogo, new File(archivo));
            System.out.println("Catálogo guardado correctamente en " + archivo);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static CatalogoLibros cargarCatalogo(String archivo) {
        try {
            JAXBContext context = JAXBContext.newInstance(CatalogoLibros.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (CatalogoLibros) unmarshaller.unmarshal(new File(archivo));
        } catch (JAXBException e) {
            e.printStackTrace();
            return new CatalogoLibros();
        }
    }

    public static void main(String[] args) {
        CatalogoLibros catalogo = new CatalogoLibros();
        Scanner scanner = new Scanner(System.in);
        String archivoXML = "catalogo.xml";

        // Cargar catálogo desde el archivo si existe
        catalogo = cargarCatalogo(archivoXML);

        int opcion;

        do {
            System.out.println("\n--- Catálogo de Libros ---");
            System.out.println("1. Agregar libro");
            System.out.println("2. Eliminar libro");
            System.out.println("3. Listar libros");
            System.out.println("4. Guardar catálogo");
            System.out.println("5. Cargar catálogo");
            System.out.println("6. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    // Agregar libro
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();
                    System.out.print("Año de publicación: ");
                    int anio = scanner.nextInt();
                    scanner.nextLine();  // Consumir el salto de línea
                    System.out.print("Género: ");
                    String genero = scanner.nextLine();

                    Libro libro = new Libro(titulo, autor, anio, genero);
                    catalogo.agregarLibro(libro);
                    System.out.println("Libro agregado.");
                    break;

                case 2:
                    // Eliminar libro
                    System.out.print("Título del libro a eliminar: ");
                    String tituloEliminar = scanner.nextLine();
                    if (catalogo.eliminarLibro(tituloEliminar)) {
                        System.out.println("Libro eliminado.");
                    } else {
                        System.out.println("Libro no encontrado.");
                    }
                    break;

                case 3:
                    // Listar libros
                    catalogo.listarLibros();
                    break;

                case 4:
                    // Guardar catálogo
                    guardarCatalogo(catalogo, archivoXML);
                    break;

                case 5:
                    // Cargar catálogo
                    catalogo = cargarCatalogo(archivoXML);
                    System.out.println("Catálogo cargado.");
                    break;

                case 6:
                    // Salir
                    System.out.println("Saliendo del programa.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 6);

        scanner.close();
    }
}