package aed.ejercicios.introduccion;

public class Unidad {
   protected String unidad;
   
   public Unidad() {}
   
   public void setUnidad(String _unidad) {
       if (_unidad != "cm" || _unidad != "m") {
           System.out.println("Tipo no válido");
       } else {
           this.unidad = _unidad;
       }
   }
   
   public String getUnidad() {
       return this.unidad;
   }
}
