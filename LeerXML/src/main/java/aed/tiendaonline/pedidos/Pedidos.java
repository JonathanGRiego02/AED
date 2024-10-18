package aed.tiendaonline.pedidos;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "pedidos")
public class Pedidos {
    private List<Pedido> pedidos = new ArrayList<>();

    public Pedidos() {}

    @XmlElement(name = "pedido")
    public List<Pedido> getPedidos() {
        return this.pedidos;
    }

    public void agregarPedido(Pedido pedido) {
        this.pedidos.add(pedido);
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public String toString() {
        return "Pedidos: " + this.pedidos;
    }
}
