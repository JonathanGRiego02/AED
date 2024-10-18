package aed.libros;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "catalogo")
public class CatalogoLibros {
    private List<Libro> libros = new ArrayList<>();

    // Constructor vacío requerido por JAXB
    public CatalogoLibros() {}

    @XmlElement(name = "libro")
    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public boolean eliminarLibro(String titulo) {
        return libros.removeIf(libro -> libro.getTitulo().equalsIgnoreCase(titulo));
    }

    public void listarLibros() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros en el catálogo.");
        } else {
            for (int i = 0 ; i < this.libros.size(); i++) {
                System.out.println( (i + 1) + " " + libros.get(i));
            }
        }
    }
}