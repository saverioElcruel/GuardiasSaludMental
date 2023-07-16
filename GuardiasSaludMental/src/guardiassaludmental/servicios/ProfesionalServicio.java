package guardiassaludmental.servicios;

import guardiassaludmental.entidades.Disponibilidad;
import guardiassaludmental.entidades.Guardia;
import guardiassaludmental.entidades.Credito;
import guardiassaludmental.entidades.Licencia;
import guardiassaludmental.entidades.Profesional;
import guardiassaludmental.persistencia.ProfesionalDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProfesionalServicio {
    
    private List<Profesional> profesionales;
    private final ProfesionalDAO DAO;
    
    Scanner sc = new Scanner(System.in).useDelimiter("\n");
     
    public ProfesionalServicio(){
        this.DAO = new ProfesionalDAO();
    }
    
    public void crearProfesional(Profesional profesional) throws Exception{
        DAO.guardar(profesional);
    }
    
    public void crearProfesionale(){
        System.out.println("Nombre:");
        String nombre = sc.next();
        DisponibilidadServicio dispon = new DisponibilidadServicio();
        Disponibilidad dispo = dispon.crearDisponibilidad();
        System.out.println("¿Toma licencia?");
        String rta = sc.next();
        LicenciaServicio gremio = new LicenciaServicio();
        Licencia licencia = null;
        if(rta.equalsIgnoreCase("si")||rta.equalsIgnoreCase("sí")){
            licencia = gremio.crearLicencia();
        }
        CreditoServicio anto = new CreditoServicio();
        Credito credito = anto.crearCredito();
        DAO.guardar(new Profesional(nombre, dispo, licencia,credito));
    }
    
    public Profesional buscarPorNombre(String nombre) throws Exception{
         return DAO.buscarPorNombre(nombre);
     }
     
     public List<Profesional> listarProfesionales() throws Exception{
         profesionales = DAO.listarTodosLosProfesionales();
         return profesionales;
     }
     
     public List<Profesional> listarCandidatosDIA(Guardia guardia){
        String dia = diaEnString(guardia); 
        List<Profesional> candidatos = new ArrayList();
         for (Profesional profesional : profesionales) {
             if(profesional.getDisponibilidad().getDias().equalsIgnoreCase(dia)){
                 candidatos.add(profesional);
             }
         }
         return candidatos;
    }
     
     public String diaEnString(Guardia guardia){
        int diaInt = guardia.getFecha().getDay();
             String dia = "";
             switch(diaInt){
                 case 1:
                     dia = "L";
                     break;
                 case 2:
                     dia = "M";
                     break;
                 case 3:
                     dia = "X";
                     break;
                 case 4:
                     dia = "J";
                     break;
                 case 5:
                     dia = "V";
                     break;
                 case 6:
                     dia = "S";
                     break;
                 case 7:
                     dia = "D";
                     break;
             }
             return dia;
    }
}
