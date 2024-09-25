package archivostxt;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 *
 * @author Jonathan
 */
public class Producto {
    private String id_producto;
    private String nom_producto;
    private String precio;
    private String categoria;

    public Producto(String _id_producto, String _nom_producto, String _precio, String _categoria) {
        this.id_producto = _id_producto;
        this.nom_producto = _nom_producto;
        this.precio = _precio;
        this.categoria = _categoria;
    }
    
// Getters y Setters
    public String getId_producto() {
        return id_producto;
    }

    public String getNom_producto() {
        return nom_producto;
    }

    public String getPrecio() {
        return precio;
    }
    
    public String getCategoria() {
        return categoria;
    }
    
    // Obtenemos todos los productos almacenados en el txt
    protected static ArrayList<Producto> ObtenerProductos(String path) {
        ArrayList<Producto> productos = new ArrayList<>();
         try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                // Obtenemos cada parametro del producto dentro de un array de strings.
                String[] linea_producto = linea.split(",");
                // Creamos el objeto con dichas caracteristicas y lo metemos en el array.
                Producto nuevo_producto = new Producto(linea_producto[0], linea_producto[1], linea_producto[2], linea_producto[3]);
                productos.add(nuevo_producto);
            }
        } catch (IOException e) {
            System.out.println("Ha habido un error");
            e.printStackTrace();
        }
        
        return productos;
    }
   
    
    // Con los productos almacenados, se abrira un archivo con el nombre de su categoria.
    // - Si existe, lo añade al final de la linea.
    // - Si no existe, crea el archivo con dicho nombre y lo pone dentro.
    protected static void CrearCategorias(ArrayList<Producto> productos) {
        for (int i = 0; i < productos.size(); i++) {
            String path = productos.get(i).getCategoria();
            try (Writer writer = new OutputStreamWriter(new FileOutputStream("Categorias/" + path + ".txt", true), StandardCharsets.UTF_8)) {
                String texto = productos.get(i).getNom_producto() + "," + productos.get(i).getPrecio() + "€";
                writer.write(texto + "\n");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
        ArrayList<Producto> supermercado = ObtenerProductos("productos.txt");
        CrearCategorias(supermercado);
    }
    
    
}
