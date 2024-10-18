package aed.tiendaonline.pedidos;


import aed.tiendaonline.productos.Productos;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

@XmlRootElement(name = "pedido")
public class Pedido {
    private Productos productos;
    private String fechaPedido;

    public Pedido() {}

    public Pedido(Productos productos, String fechaPedido) {
        this.productos = productos;
        this.fechaPedido = fechaPedido;
    }

    @XmlElement(name = "productos")
    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    @XmlElement(name = "fechaPedido")
    public String getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(String fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    @Override
    public String toString() {
        return "Fecha del Pedido: " + this.fechaPedido + ", Productos: " + this.productos;
    }
}
