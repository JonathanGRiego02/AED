package archivostxt;

import java.util.Scanner;
import java.io.*;
/**
 *
 * @author Jonathan
 */
public class Usuarios {
    
    public static void AddData() {
        Scanner scanner = new Scanner(System.in);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("usuarios.txt", true))) {
            String input = "";
            while(!input.equals("no")) {
                System.out.print("Introduce tu nombre: ");
                input = scanner.nextLine();
                String nombre = input;
        
                System.out.print("Introduce tu edad: ");
                input = scanner.nextLine();
                String edad = input;
        
                System.out.print("Introduce tu correo electronico: ");
                input = scanner.nextLine();
                String email = input;
                System.out.println();
                writer.write(nombre + " " + edad + " " + email);
                writer.write("\n");
                System.out.print("Desea introducir otro usuario? (si/no)");
                input = scanner.nextLine();
            }
        } catch (IOException e) {
            e.printStackTrace(); 
        }
        
    }
    
    public static void ReadFIle() {
        try (BufferedReader reader = new BufferedReader(new FileReader("usuarios.txt"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea); 
            }
        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while (!input.equals("3")) {
            System.out.println("1- Mostrar datos,");
            System.out.println("2- Anadir datos.");
            System.out.println("3- Salir");
            input = scanner.nextLine();
            switch (input) {
                case "1":
                    ReadFIle();
                    System.out.println();
                    break;
            
                case "2":
                    AddData();
                    System.out.println();
                    break;
            
                case "3":
                    System.out.println("ADIOOOOOOOOOOOOOS");
                    break;
                default:
                    System.out.println("Introduce un valor correcto");
            }
        }
        
        scanner.close();
        
       
    }
    
}
