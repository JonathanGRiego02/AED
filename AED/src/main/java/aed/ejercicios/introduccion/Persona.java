package aed.ejercicios.introduccion;
import java.util.Scanner;


/**
 *
 * @author jonat
 */
public class Persona {
    String nombre;
    int edad;
    double altura;
    String consulta_Nombre(){
        return nombre;
    }
    void cambia_Nombre(String nom){
        nombre=nom;
    }
    
    //Constructor
    public Persona(String _nombre, int _edad, double _altura) {
        this.nombre = _nombre;
        this.edad = _edad;
        this.altura = _altura;
    }
    
    // Preguntar nombre
    public void PreguntarNombre() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¿Como te llamas?");
        this.nombre = scanner.nextLine();
        System.out.println("Tu nombre es " + this.nombre + ".");
    }
    
    // Preguntar edad
    public void PreguntarEdad() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¿Cuantos años tienes?");
        this.edad = scanner.nextInt();
        System.out.println("Tienes" + this.edad + " años.");
    }
    
    // Preguntar Altura
    public void PreguntarAltura() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("¿Cuanto mides?");
        this.altura = scanner.nextDouble();
        System.out.println("Mides " + this.nombre + " m.");
    }
    
    // Check de mayoria de edad
    public boolean esMayorDeEdad() {
        if (this.edad >= 18) {
            return true;
        }  
        return false;
        
    }
}
