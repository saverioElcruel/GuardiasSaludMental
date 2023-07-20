package guardiassaludmental.servicios;


import guardiassaludmental.entidades.Guardia;
import guardiassaludmental.entidades.Profesional;
import guardiassaludmental.entidades.Turno;
import guardiassaludmental.persistencia.GuardiaDAO;
import guardiassaludmental.persistencia.ProfesionalDAO;
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
    
    public void crearGuardias()throws Exception{
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
    
    /*
    // Aquí puedes realizar alguna operación basada en el objeto anterior y el actual
            if (personaAnterior != null) {
                String nombreAnterior = personaAnterior.getNombre();
                int edadAnterior = personaAnterior.getEdad();
                // Hacer algo con los atributos del objeto anterior y el actual
                // Por ejemplo, compararlos, calcular alguna diferencia, etc.
                // ...
            }
    */
    
    
    public void asignarGuardiasEquitativamente(){
        ProfesionalServicio ps = new ProfesionalServicio();
        ProfesionalDAO profDAO = new ProfesionalDAO();
        
        List<Profesional> listadoEquitativo = ps.orderProfesionalesByCharacterCount(profDAO.listarTodosLosProfesionales());
        Profesional profAnterior = null;
        Profesional profAntAnterior = null;
        for (Guardia guardia : guardias) {
            
            for (int i = 0; i < listadoEquitativo.size(); i++) {
                if (listadoEquitativo.get(i).getDisponibilidad().getDias().contains(pasarAString(guardia))& guardia.getTurno()==Turno.DIA) {
                   guardia.setProfesional(listadoEquitativo.get(i));
//                   listadoEquitativo.get(i)
                   DAO.guardar(guardia);
                   listadoEquitativo.remove(listadoEquitativo.get(i));
                } else if (listadoEquitativo.get(i).getDisponibilidad().getNoches().contains(pasarAString(guardia))) {
                    guardia.setTurno(Turno.NOCHE);
                    guardia.setProfesional(listadoEquitativo.get(i));
                    DAO.guardar(guardia);
                    listadoEquitativo.remove(listadoEquitativo.get(i));
                }
            profAntAnterior = profAnterior;
            profAnterior = listadoEquitativo.get(i);
            }
            
        }
            
    }
        
  public void verGuardiasAsignadas(){
      for (Guardia guardia : guardias) {
          System.out.println(guardia.getFecha()+ " "+ guardia.getTurno() + " "+ guardia.getProfesional());
      }
  }

    
    public void asignarGuardias(){
        int count= 0;
        for (Guardia guardia : guardias) {
            ProfesionalServicio profSer = new ProfesionalServicio();
            Profesional[] dr = profSer.pasarListAvector();
            
            if(dr[count].getDisponibilidad().getDias().contains(pasarAString(guardia))){
                guardia.setProfesional(dr[count]);
                DAO.guardar(guardia);
            }
            if(count==9){
                count=0;
            }else{
                count++;
            }
            
            
        }
    }
    
    public String pasarAString(Guardia guardia){
        String dia = "O";
        switch(guardia.getFecha().getDay()){
             case 0:
                     dia = "J";
                     break;
                 case 1:
                     dia = "V";
                     break;
                 case 2:
                     dia = "S";
                     break;
                 case 3:
                     dia = "D";
                     break;
                 case 4:
                     dia = "L";
                     break;
                 case 5:
                     dia = "M";
                     break;
                 case 6:
                     dia = "X";
                     break;
        }
        return dia;
    }
    /*
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
    */
    
   
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



    
    
    

