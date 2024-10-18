package aed.tiendaonline;

import aed.tiendaonline.pedidos.Pedido;
import aed.tiendaonline.pedidos.Pedidos;
import aed.tiendaonline.productos.Producto;
import aed.tiendaonline.productos.Productos;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws JAXBException {
        Producto producto1 = new Producto("Arroz", 2.50, "Comida");
        Producto producto2 = new Producto("Detergente", 12.50, "Limpiza");
        Producto producto3 = new Producto("Pera", 1, "Fruta");

        // Crear la lista de productos para un pedido
        Productos productosPedido1 = new Productos();
        productosPedido1.agregarProducto(producto1);
        productosPedido1.agregarProducto(producto2);

        // Crear otro pedido con diferentes productos
        Productos productosPedido2 = new Productos();
        productosPedido2.agregarProducto(producto3);

        // Crear pedidos con fecha
        Pedido pedido1 = new Pedido(productosPedido1, "21-12-2024");
        Pedido pedido2 = new Pedido(productosPedido2, "21-12-2024");

        // Crear la lista de pedidos y agregar los pedidos
        Pedidos listaPedidos = new Pedidos();
        listaPedidos.agregarPedido(pedido1);
        listaPedidos.agregarPedido(pedido2);

        try {
            // Crear contexto JAXB
            JAXBContext contexto = JAXBContext.newInstance(Pedidos.class);

            // Crear un marshaller
            Marshaller marshaller = contexto.createMarshaller();

            // Formatear el XML
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Escribir el objeto en un archivo XML
            marshaller.marshal(listaPedidos, new File("TiendaOnlineXML/pedidos.xml"));

            System.out.println("Archivo XML de pedidos generado con éxito: pedidos.xml");

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
