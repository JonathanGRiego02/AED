/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package archivostxt.AccesoAleatorio;

import java.util.Scanner;

/**
 *
 * @author Jonathan
 */
public class MenuCrud {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        String opcion = "";
        
        
        
        while(opcion != "5") {
            System.out.println("Elige una opcion: ");
            System.out.println("1. Ver datos");
            System.out.println("2. Introducir Datos");
            System.out.println("3. Modificar datos");
            System.out.println("4. Borrar datos");
            System.out.println("5. Salir");
            opcion = scanner.nextLine();
            
            switch (opcion) {
                case "1":
                    
                    break;
                
                case "2":
                    
                    break;
                    
                case "3":
                    
                    break;
                    
                case "4":
                    
                    break;
                
                case "5":
                    System.out.println("ADIOOOOOOOOOS");
                    break;
                
                default:
                    System.out.println("Introduce una opcion válida");
            }
        }    
    }    
    
}
