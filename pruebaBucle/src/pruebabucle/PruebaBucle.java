
package pruebabucle;

import java.util.Date;
import java.util.Scanner;
import servicios.ServicioGuardiaProfesional;

public class PruebaBucle {

    public static void main(String[] args) {
       ServicioGuardiaProfesional sgp = new ServicioGuardiaProfesional();
       try{
           sgp.crearGuardias();
           sgp.mostrarGuardias();
           sgp.crearProfesionales();
           sgp.asigDia();
           
           
        
           sgp.mostrarGuardias();
//           sgp.mostrarProfesionales();
           sgp.mostrarProfesionalesOrdenados();
//           
       }catch(Exception e){
           e.printStackTrace();
       }
       
    
        }
        
    
}
