package aed.ejercicios.introduccion;

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
