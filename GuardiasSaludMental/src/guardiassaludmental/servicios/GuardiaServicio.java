package guardiassaludmental.servicios;

import guardiassaludmental.entidades.Credito;
import guardiassaludmental.entidades.Guardia;
import guardiassaludmental.entidades.Profesional;
import guardiassaludmental.entidades.Turno;
import guardiassaludmental.persistencia.GuardiaDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class GuardiaServicio {
    
    private List<Guardia> guardias;
    private final GuardiaDAO DAO;
    private Scanner sc = new Scanner(System.in).useDelimiter("\n");
     
    public GuardiaServicio(){
        this.DAO = new GuardiaDAO();
    }
    
    public void cargarGuardia(Guardia guardia) throws Exception{
        DAO.guardar(guardia);
    }
    
    public void crearGuardias(){
        System.out.println("Fecha de inicio del calendario(dd/mm/aaaa): ");
        String fecha = sc.next();
        String fechak[] = fecha.split("/");
        Date inicio = new Date(Integer.parseInt(fechak[2]) - 1900, Integer.parseInt(fechak[1]), Integer.parseInt(fechak[0]));
        
        long unDiaEnMiliSegundos = 24 * 60 * 60 * 1000;
        long inicioEnMiliSegundos = inicio.getTime();
        
        for (int i = 1; i < 31; i++) {
            long nuevoDiaEnMili = inicioEnMiliSegundos + (unDiaEnMiliSegundos*i);
            Date nuevoDia = new Date(nuevoDiaEnMili);
            DAO.guardar(new Guardia(nuevoDia,Turno.DIA));
            DAO.guardar(new Guardia(nuevoDia,Turno.NOCHE));
        }
        }
    
    public List<Guardia> listarGuardias(){
         guardias = DAO.listarTodasLasGuardias();
         return guardias;
     }
    
    public List<Guardia> listarGuardiasDia(){
         guardias = DAO.listarGuardiasDia();
         return guardias;
     }
    
    
    public void asignarGuardiaDia(){
        ArrayList<Guardia> guardiasDia = (ArrayList<Guardia>)listarGuardiasDia();
        ProfesionalServicio server = new ProfesionalServicio();
        for (Guardia guardia : guardiasDia) {
            ArrayList<Profesional> candidatxs = (ArrayList<Profesional>) server.listarCandidatosDIA(guardia);
            for (Profesional candidatx : candidatxs) {
                if(candidatx.getCredito().getGuardiasMes()>0){
                    guardia.setProfesional(candidatx);
                    Credito credito = candidatx.getCredito();
                    credito.setGuardiasMes(candidatx.getCredito().getGuardiasMes()-1);
                    candidatx.setCredito(credito);
                }
            }
            
        }
    }
   
    public String mesEnString(){
        int mes = guardias.get(0).getFecha().getMonth();
        String messi = "";
        switch(mes){
            case 1:messi = "Enero";break;
            case 2:messi = "Febrero";break;
            case 3:messi = "Marzo";break;
            case 4:messi = "Abril";break;
            case 5:messi = "Mayo";break;
            case 6:messi = "Junio";break;
            case 7:messi = "Julio";break;
            case 8:messi = "Agosto";break;
            case 9:messi = "Septiembre";break;
            case 10:messi = "Octubre";break;
            case 11:messi = "Noviembre";break;
            case 12:messi = "Diciembre";break;
        }
        return messi;
    }
   

}



    
    
    

