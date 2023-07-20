package guardiassaludmental.servicios;

import guardiassaludmental.entidades.Disponibilidad;
import guardiassaludmental.entidades.Guardia;
import guardiassaludmental.entidades.Licencia;
import guardiassaludmental.entidades.Profesional;
import guardiassaludmental.persistencia.ProfesionalDAO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
        System.out.println("¿Cuántas guardias quiere?");
        int pretension = sc.nextInt();
        DAO.guardar(new Profesional(nombre,dispo,pretension,0,0));
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
     
     public Profesional[] pasarListAvector(){
         ArrayList<Profesional> profesionalex = (ArrayList<Profesional>) profesionales;
         
         Profesional[] drs = new Profesional[profesionalex.size()];
         for (int i = 0; i < drs.length; i++) {
             drs[i] = profesionales.get(i);
         }
         return drs;
     }  
     public String diaEnString(Guardia guardia){
        int diaInt = guardia.getFecha().getDay();
             String dia = "";
             switch(diaInt){
                 case 0:
                     dia = "L";
                     break;
                 case 1:
                     dia = "M";
                     break;
                 case 2:
                     dia = "X";
                     break;
                 case 3:
                     dia = "J";
                     break;
                 case 4:
                     dia = "V";
                     break;
                 case 5:
                     dia = "S";
                     break;
                 case 6:
                     dia = "D";
                     break;
             }
             return dia;
    }
     
     public void listarProfSegunDisp(){
         List<Profesional> listadoEquitativo = orderProfesionalesByCharacterCount(DAO.listarTodosLosProfesionales());
         for (Profesional profesional : listadoEquitativo) {
             System.out.println( profesional.getNombre()+ " " + profesional.getDisponibilidad().getDias().length()+ " " + profesional.getDisponibilidad().getDias().length());
         }
     }
     
     public List<Profesional> orderProfesionalesByCharacterCount(List<Profesional> profesionales) {
        Collections.sort(profesionales, new ProfesionalComparator());
        return profesionales;
    }
    
    private static class ProfesionalComparator implements Comparator<Profesional> {
        @Override
        public int compare(Profesional p1, Profesional p2) {
            // "LMX" "SDL"
            int p1TotalCharacters = p1.getDisponibilidad().getDias().length() + p1.getDisponibilidad().getNoches().length();
            int p2TotalCharacters = p2.getDisponibilidad().getDias().length() + p2.getDisponibilidad().getNoches().length();

            return Integer.compare(p2TotalCharacters,p1TotalCharacters);
        }
    }
}
