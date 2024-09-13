package aed.ejercicios.introduccion;

/**
 *
 * @author jonat
 */
public class Main {
    public static void main(String[] args) {
        Persona nueva_persona = new Persona("Sonia", 27, 1.72);
        System.out.println("Nombre: " + nueva_persona.nombre);
        System.out.println("Edad: " + nueva_persona.edad);
        System.out.println("Altura: " + nueva_persona.altura);
    }
}
