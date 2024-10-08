/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aed.crudbinario;

import java.util.Scanner;

/**
 *
 * @author Jonathan
 */
public class MainCrud {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        String opcion = "";
        Crud crudController = new Crud("mi_binario.bin");
         int nueva_id;
         short nueva_edad;
         float nuevo_salario;
        
        while(!opcion.equals("6")) {
            System.out.println("Elige una opcion: ");
            System.out.println("1. Ver todos los datos");
            System.out.println("2. Buscar un dato");
            System.out.println("3. Introducir Datos");
            System.out.println("4. Modificar datos");
            System.out.println("5. Borrar datos");
            System.out.println("6. Salir");
            opcion = scanner.nextLine();
           
            
            switch (opcion) {
                case "1":
                    crudController.Read();
                    System.out.println();
                    break;
                
                case "2":
                    System.out.println("Introduce la ID del registro a buscar: ");
                    int id_registro = scanner.nextInt();
                    scanner.nextLine();
                    crudController.Search(id_registro);
                    System.out.println();
                    break;
                    
                case "3":
                    System.out.println("Introduce la id: ");
                    nueva_id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Introduce la edad: ");
                    nueva_edad = scanner.nextShort();
                    scanner.nextLine();
                    System.out.println("Introduce el salario: ");
                    nuevo_salario = scanner.nextFloat();
                    crudController.Create(nueva_id, nueva_edad, nuevo_salario);
                    System.out.println();
                    break;
                    
                case "4":
                    System.out.println("Introduce el id del registro a cambiar: ");
                    nueva_id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Introduce la edad: ");
                    nueva_edad = scanner.nextShort();
                    scanner.nextLine();
                    System.out.println("Introduce el salario: ");
                    nuevo_salario = scanner.nextFloat();
                    crudController.Update(nueva_id, nueva_edad, nuevo_salario);
                    System.out.println();
                    break;
                
                case "5":
                    System.out.println("Introduce el id del registro a borrar: ");
                    nueva_id = scanner.nextInt();
                    scanner.nextLine();
                    crudController.Delete(nueva_id);
                    System.out.println();
                    break;
                
                case "6":
                    System.out.println("ADIOOOOOOOOOS");
                    break;
                
                default:
                    System.out.println("Introduce una opcion va1lida");
            }
        }    
    }    
    
}

