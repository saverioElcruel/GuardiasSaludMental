
package guardiassaludmental.servicios;

import guardiassaludmental.entidades.Disponibilidad;
import guardiassaludmental.persistencia.DisponibilidadDAO;
import java.util.Scanner;

public class DisponibilidadServicio {
    
    private final DisponibilidadDAO DAO;
    
    Scanner sc = new Scanner(System.in).useDelimiter("\n");
    
    public DisponibilidadServicio(){
        this.DAO = new DisponibilidadDAO();
    }
    
    public Disponibilidad crearDisponibilidad(){
        System.out.println("Dias disponibles en el turno DIA:");
        String dispoDia = sc.next();
        System.out.println("Dias disponibles en el turno NOCHE:");
        String dispoNoche = sc.next();
        System.out.println("Disponibilidad 24hs:");
        String dispo24 = sc.next();
        Disponibilidad dispo = new Disponibilidad(dispoDia,dispoNoche,dispo24);
        DAO.guardar(dispo);
        return dispo;
    }
    
}
