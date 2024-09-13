
package aed.ejercicios.introduccion;

import java.util.HashSet;

public class Vehiculo {
    protected String modelo;
    protected double potencia;
    protected boolean cRuedas;
    
    public Vehiculo(String _modelo) {
        this.modelo = _modelo;
    }

    public double getPotencia() {
        return potencia;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    public boolean iscRuedas() {
        return cRuedas;
    }

    public void setcRuedas(boolean cRuedas) {
        this.cRuedas = cRuedas;
    }
    
    public void imprimir() {
        System.out.println("Modelo: " + this.modelo);
        System.out.println("Potencia: " + this.getPotencia());
        if (this.iscRuedas()) {
            System.out.println("Tiene tracción en las 4 ruedas");
        } else {
            System.out.println("No tiene tracción en las 4 ruedas");
        }
    }
    
    public static void main(String[] args) {
        Vehiculo mi_coche = new Vehiculo("Fiat500");
        mi_coche.setPotencia(200);
        mi_coche.setcRuedas(false);
        mi_coche.imprimir();
    }
}
