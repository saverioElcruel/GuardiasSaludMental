
package guardiassaludmental;

import guardiassaludmental.servicios.GuardiaServicio;
import guardiassaludmental.servicios.ProfesionalServicio;

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
