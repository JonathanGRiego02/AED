package aed.tiendaonline.clientes;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "clientes")
public class Clientes {
    private List<Cliente> clientes;

    public Clientes() {}

    public Clientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    @XmlElement(name = "cliente")
    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
}
