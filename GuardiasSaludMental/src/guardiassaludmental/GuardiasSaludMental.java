
package guardiassaludmental;

import guardiassaludmental.servicios.GuardiaServicio;
import guardiassaludmental.servicios.ProfesionalServicio;
import java.util.LinkedList;
import java.util.List;

public class GuardiasSaludMental {


    public static void main(String[] args) {
        
        try{
            GuardiaServicio gs = new GuardiaServicio();
        gs.crearGuardias();
        
       ProfesionalServicio ps = new ProfesionalServicio();
     
       
       gs.asignarGuardiasEquitativamente();
       
       gs.verGuardiasAsignadas();
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    
}
        
    
    

