package aed.ejercicios.introduccion;

import java.util.Set;

public class Caja {
    protected int ancho;
    protected int alto;
    protected int fondo;
    Unidad tipo_unidad;
    protected String etiqueta;
    
    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getFondo() {
        return fondo;
    }

    public void setFondo(int fondo) {
        this.fondo = fondo;
    }

    public Unidad getTipo_unidad() {
        return tipo_unidad;
    }

    public void setTipo_unidad(Unidad tipo_unidad) {
        this.tipo_unidad = tipo_unidad;
    }
    
    public String getEtiqueta() {
        return this.etiqueta;
    }
    
    public double getVolumen() {
        return (this.getFondo() * this.getAlto() * this.getAncho());
    }
    
    public void SetEtiqueta(String etiqueta) {
        if (etiqueta.length() > 30 || etiqueta.length() == 0) {
            System.out.println("Tamaño de la etiqueta no valido");
        } else {
            this.etiqueta = etiqueta;
        }
    }
    
    
    public void ToString() {
        System.out.println("Info caja:");
        System.out.println("Alto: " + this.getAlto());
        System.out.println("Ancho: " + this.getAncho());
        System.out.println("Largo: "  + this.getFondo());
        System.out.println("Etiqueta: " + this.getEtiqueta());
    }

    
    
    public Caja(int _ancho, int _alto, int _fondo, Unidad _unidad) {
        this.ancho = _ancho;
        this.alto = _alto;
        this.fondo = _fondo;
        this.tipo_unidad = _unidad;
    }
    
    public static void main(String[] args) {
        Unidad unidad_caja = new Unidad();
        unidad_caja.setUnidad("cm");
        Caja mi_caja = new Caja(10, 20, 20, unidad_caja);
        mi_caja.SetEtiqueta("Caja de zapatos");
        mi_caja.ToString();
    }
    
}
