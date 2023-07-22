
package pruebabucle;

import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;
import servicios.ServicioGuardiaProfesional;

public class PruebaBucle {

    public static void main(String[] args) {
       ServicioGuardiaProfesional sgp = new ServicioGuardiaProfesional();
     
       try{
           sgp.crearGuardias();
//           sgp.mostrarGuardias();
           sgp.crearProfesionales();
           sgp.mostrarProfesionalesOrdenados();
           sgp.bucleDelbuclePpal();
//           sgp.crearLicencia();
        
//           sgp.mostrarGuardias();
//           sgp.mostrarProfesionales();
           
//           sgp.mostrarProfesionales();
           
//           System.out.println("");


           sgp.mostrarProfesionalesOrdenados();
           
           System.out.println("");
           sgp.mostrarGuardias();
           
//           sgp.mostrarOrdenCentinelas();
//           
       }catch(Exception e){
           e.printStackTrace();
       }
       
    
        }
        
    
}
