package aed.ejercicios.introduccion;

/*
Construye una clase Complejo con dos atributos:

real: parte real del número complejo
imag: parte imaginaria del número complejo
A continuación crea los siguientes métodos dentro de la clase:

public Complejo(): Constructor que inicializa los atributos a cero.
public Complejo(double real, double imag): Constructor que inicializa los atributos a los valores indicados por los parámetros.
public double consulta_Real(): Devuelve la parte real del objeto.
public double consulta_Imag(): Devuelve la parte imaginaria del objeto.
public void cambia_Real(double real): Asigna a la parte real del objeto el valor indicado en el parámetro real.
public void cambia_Imag(double imag): Asigna a la parte imaginaria del objeto el valor indicado en el parámetro imag.
public String toString(): Convierte a String el número complejo, mediante la concatenación de sus atributos y devuelve como resultado la cadena de texto 3 + 4i, si 3 es la parte real y 4 la parte imaginaria.
public void sumar(Complejo b): Suma la parte real con la parte real del número complejo b y la parte imaginaria con la parte imaginaria del número complejo b.
Crea un proyecto que contenga la clase Complejo en un paquete llamado números y pruebe todos sus métodos.
*/
public class Complejo {
    protected double real;
    protected double imag;
    
    public Complejo() {
        this.real = 0;
        this.imag = 0;
    }
    
    public Complejo(double _real, double _imag) {
        this.real = _real;
        this.imag = _imag;
    }
    
    public double consulta_Real() {
        return this.real;
    }
    
    public double consulta_Imag() {
        return this.imag;
    }
    
    public void cambia_Real(double _real) {
        this.real = _real;
    }
    
    public void cambia_Imag(double _imag) {
        this.imag = _imag;
    }
    
    @Override
    public String toString() {
        return String.format("%.3f + %.3fi" , this.real, this.imag);
    }
    
    public void Sumar(Complejo b) {
        System.out.println(String.format("%.3f + %.3fi" , this.real + b.real, this.real + b.imag));
    }
    
    
    
    
    
    public static void main(String[] args) {
        Complejo mi_complejo = new Complejo(2,3);
        System.out.println(mi_complejo.toString());
        mi_complejo.Sumar(mi_complejo);
    }
}
