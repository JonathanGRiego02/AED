package aed.tiendaonline.productos;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "productos")
public class Productos {
    private List<Producto> productos = new ArrayList<>();

    public Productos() {}

    @XmlElement(name = "producto")
    public List<Producto> getProductos() {
        return this.productos;
    }

    public void agregarProducto(Producto producto) {
        this.productos.add(producto);
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public void agregarProductos(Producto nuevo_producto) {
        this.productos.add(nuevo_producto);
    }

}
