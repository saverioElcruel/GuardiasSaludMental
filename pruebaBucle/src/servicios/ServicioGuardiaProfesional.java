
package servicios;

import entidades.Guardia;
import entidades.Licencia;
import entidades.Profesional;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ServicioGuardiaProfesional {
    
    private List<Guardia> guardias = new ArrayList();
    private List<Profesional> profesionales = new ArrayList();
    
    private Scanner sc = new Scanner(System.in).useDelimiter("\n");
    
    public LocalDate crearFeriado(){
        System.out.println("Ingrese feriado (dd/mm/aaaa):");
        String fecha = sc.next();
        DateTimeFormatter formatear = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate feriado = LocalDate.parse(fecha, formatear);
            return feriado;
        }
    
    public void crearGuardias()throws Exception{
        String fecha = "16-06-2023";
        DateTimeFormatter formatear = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate primerDia = LocalDate.parse(fecha, formatear);
        for (int i = 0; i < 30; i++) {
            LocalDate diaSiguiente = primerDia.plusDays(i);
            if(diaSiguiente.getDayOfWeek()==DayOfWeek.SATURDAY || diaSiguiente.getDayOfWeek()==DayOfWeek.SUNDAY){
                guardias.add(new Guardia(diaSiguiente,"DIA",true));
                guardias.add(new Guardia(diaSiguiente,"NOCHE",true));
            }else{
                guardias.add(new Guardia(diaSiguiente,"DIA",false));
                guardias.add(new Guardia(diaSiguiente,"NOCHE",false));
            }   
        }
        String fecha1 = "19-06-2023";
        LocalDate feriado1 = LocalDate.parse(fecha1, formatear);
        for (Guardia guardia : guardias) {
            if(guardia.getFecha().getDayOfMonth()==feriado1.getDayOfMonth()){
                    guardia.setFeriado(true);
                }
        }
        String fecha2 = "20-06-2023";
        LocalDate feriado2 = LocalDate.parse(fecha2, formatear);
        for (Guardia guardia : guardias) {
            if(guardia.getFecha().getDayOfMonth()==feriado2.getDayOfMonth()){
                    guardia.setFeriado(true);
                }
        }
    }
    
    public void crearGuardiasManual()throws Exception{
        System.out.println("Fecha de inicio del calendario(dd/mm/aaaa): ");
        String fecha = sc.next();
        DateTimeFormatter formatear = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate primerDia = LocalDate.parse(fecha, formatear);
        
        for (int i = 0; i < 30; i++) {
            LocalDate diaSiguiente = primerDia.plusDays(i);
           
            if(diaSiguiente.getDayOfWeek()==DayOfWeek.SATURDAY || diaSiguiente.getDayOfWeek()==DayOfWeek.SUNDAY){
                guardias.add(new Guardia(diaSiguiente,"DIA",true));
                guardias.add(new Guardia(diaSiguiente,"NOCHE",true));
            }else{
                guardias.add(new Guardia(diaSiguiente,"DIA",false));
                guardias.add(new Guardia(diaSiguiente,"NOCHE",false));
            }
            
            }
        
        System.out.println("¿Cuántos feriados tendrá el mes?");
        int vueltas = sc.nextInt(); 
        for (int i = 0; i < vueltas; i++) {
            LocalDate feriado = crearFeriado();
            for (Guardia guardia : guardias){
                if(guardia.getFecha().getDayOfMonth()==feriado.getDayOfMonth()){
                    guardia.setFeriado(true);
                }
                
            }
        }
        
        }
    
    
    public Licencia crearLicencia(){
        System.out.println("Fecha de inicio de la licencia(dd/mm/aaaa): ");
        String fecha = sc.next();
        DateTimeFormatter formatear = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate inicio = LocalDate.parse(fecha, formatear);
        
        System.out.println("Fecha de fin de la licencia(dd/mm/aaaa): ");
        String fecha2 = sc.next();
        DateTimeFormatter formatear2 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate fin = LocalDate.parse(fecha2, formatear2);
        
        return new Licencia(inicio,fin);
    }
    
    
    public boolean tieneLicencia(Guardia g, Profesional p){
        boolean tiene = false;
        try{
            if(g.getFecha().isBefore(p.getLicencia().getFechaFin()) 
                && g.getFecha().isAfter(p.getLicencia().getFechaInicio())
                ){
            tiene = true;
        }
        
       
        }catch(NullPointerException e){
            tiene=false;
        }
         return tiene;
    }
    
    public String pasar(Guardia g){
        String letra = "";
        switch(g.getFecha().getDayOfWeek()){
            case MONDAY:
                letra = "L";
                break;
            case TUESDAY:
                letra = "M";
                break;
            case WEDNESDAY:
                letra = "X";
                break;
            case THURSDAY:
                letra = "J";
                break;
            case FRIDAY:
                letra = "V";
                break;
            case SATURDAY:
                letra = "S";
                break;
            case SUNDAY:
                letra = "D";
                break;
                
        }
        return letra;
    }
    
    
    public void mostrarGuardias()throws NullPointerException{
        
        for (Guardia guardia : guardias) {
            try{
                if(guardia.getProfesional().getNombre()!=null){
                    System.out.println(guardia.getFecha().getDayOfWeek()+" "+guardia.getFecha().getDayOfMonth()+" "+
                    guardia.getFecha().getMonth()+" Turno: "+guardia.getTurno()+" F: "+guardia.isFeriado()+
            " Profesional: "+guardia.getProfesional().getNombre());
                }
                }catch(NullPointerException e){
                   System.out.println(guardia.getFecha().getDayOfWeek()+" "+guardia.getFecha().getDayOfMonth()+" "+
                    guardia.getFecha().getMonth()+" Turno: "+guardia.getTurno()+" F: "+guardia.isFeriado());
                    }
        }
    }
    
    public boolean turnoDispoLicenciaCredito(Guardia g, Profesional p){
        boolean puede = false;
        if((g.getTurno().equals("DIA")&&p.getDisponibilidadDia().contains(pasar(g))||
            g.getTurno().equals("NOCHE")&&p.getDisponibilidadNoche().contains(pasar(g)))&
            p.getCredito()>0&
            !tieneLicencia(g,p)){
            puede=true;
        }
        return puede;
    }
    
    public void asignarGuard(Guardia g, Profesional p){
        g.setProfesional(p);
    }
    
    public void sumarGuardiaFeriado(Profesional p){
        p.setGuardiasFinde(p.getGuardiasFinde()+1);
    }
    
    public void restarCredito(Profesional p){
        p.setCredito(p.getCredito()-1);
    }
    
    public void bucleDelbuclePpal(){
        List<Profesional> ordenados = ordenarEquitativamente(profesionales);
        buclePpal(ordenados);
        buclePpal(ordenados);
        buclePpal(ordenados);
        List<Profesional> centinelas = ordenarCentinelas(profesionales);
        buclePpal(centinelas);
        buclePpal(centinelas);
        buclePpal(centinelas);
        
        buclePpal(ordenados);
        buclePpal(ordenados);
        buclePpal(ordenados);
        buclePpal(ordenados);
        buclePpal(ordenados);
        buclePpal(ordenados);
        buclePpal(ordenados);
        
        
    }
  
    public static int valorLicencia(Profesional p){
        int valor = 30;
        try{
            valor = (int) ChronoUnit.DAYS.between(p.getLicencia().getFechaFin(),p.getLicencia().getFechaInicio());
            
        }catch(Exception e){
            valor = 30;
        }
        return valor;
    }
    
    
      
    public void buclePpal(List<Profesional> profesionales){
        
        Guardia gAnt = new Guardia(new Profesional("montoto"));
        Guardia gAntAnt = new Guardia(new Profesional("montoto"));
        Guardia gAntAntAnt = new Guardia(new Profesional("montoto"));
        
        for (Profesional p : profesionales) {
            for (Guardia g : guardias) {
            if(g.getProfesional()==null){
                
                    if(gAnt.getProfesional()==p){
                        if(p.isCentinela()&g.getTurno().equals("NOCHE")){
                            if(p.getDisponibilidadCentinela().contains(pasar(g))
                                & p.getCredito()>0 
                                        &
                                !tieneLicencia(g,p)){
                                if(g.isFeriado()){
                                    if(p.getGuardiasFinde()<3){
                                        asignarGuard(g,p);
                                        sumarGuardiaFeriado(p);
                                        restarCredito(p);
                                        
                                        break;
                                    }
                                }else{
                                    asignarGuard(g,p);
                                    restarCredito(p);
                                    
                                    break;
                                }
                            }
                        } 
                    }else{
                        if(gAntAnt.getProfesional()!=p){
                            if(gAntAntAnt.getProfesional()!=p){
                                if (turnoDispoLicenciaCredito(g,p)) {
                                    if (g.isFeriado()) {
                                        if (p.getGuardiasFinde()<3) {
                                            asignarGuard(g,p);
                                            sumarGuardiaFeriado(p);
                                            restarCredito(p);
                                            
                                            break;
                                        }
                                    } else {
                                        asignarGuard(g,p);
                                        restarCredito(p);
                                        
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
                gAntAntAnt=gAntAnt;
                gAntAnt=gAnt;
                gAnt=g;            
            }
        }
        
    }
    
   
    
    public void crearProfesionales(){
       
        LocalDate inicio6 = LocalDate.of(2023, 07, 01);
        LocalDate fin6 = LocalDate.of(2023, 07, 15);
        Licencia l6 = new Licencia(inicio6,fin6);
        Profesional prof1 = new Profesional("Hector", "LMXJVSD", "LMXJVSD","LMXJVSD",15,l6,0,0,true);
        profesionales.add(prof1);
        
        
        Profesional prof2 = new Profesional("Maru", "LV", "SD","",5,0,0,false);
        profesionales.add(prof2);
        
        
        Profesional prof3 = new Profesional("Lau S", "LMXJVSD", "MS","X",12,0,0,true);
        profesionales.add(prof3);
        
        LocalDate inicio = LocalDate.of(2023, 06, 26);
        LocalDate fin = LocalDate.of(2023, 07, 15);
        Licencia l1 = new Licencia(inicio,fin);
        Profesional prof4 = new Profesional("Rodo", "LMXJVSD", "LMXJVSD","LMXJVSD", 12,l1,0,0,true);
        profesionales.add(prof4);
        
        LocalDate inicio2 = LocalDate.of(2023, 06, 16);
        LocalDate fin2 = LocalDate.of(2023, 06, 21);
        Licencia l2 = new Licencia(inicio2,fin2);
        Profesional prof5 = new Profesional("Javier", "LMXSD", "LMSD","LMSD",12,l2,0,0,true);
        profesionales.add(prof5);
        
        LocalDate inicio3 = LocalDate.of(2023, 06, 16);
        LocalDate fin3 = LocalDate.of(2023, 06, 22);
        Licencia l3 = new Licencia(inicio3,fin3);
        Profesional prof6 = new Profesional("Flor", "LX", "LXJVD","", 12,l3,0,0,false);
        profesionales.add(prof6);
        
        LocalDate inicio4 = LocalDate.of(2023, 06, 16);
        LocalDate fin4 = LocalDate.of(2023, 07, 01);
        Licencia l4 = new Licencia(inicio4,fin4);
        Profesional prof7 = new Profesional("Luisi", "LXJSD", "D","", 3,l4,0,0,false);
        profesionales.add(prof7);
        
        
        Profesional prof8 = new Profesional("Lorena", "MVS", "","", 7,0,0,false);
        profesionales.add(prof8);
        
        
        Profesional prof9 = new Profesional("Julia", "VSD", "MXSD","", 7,0,0,false);
        profesionales.add(prof9);
        
        
        Profesional prof10 = new Profesional("Lucia", "LVSD", "LMJSD","VSD",12,0,0,true);
        profesionales.add(prof10);
    }
    
    public void mostrarProfesionales(){
        for (Profesional p : profesionales) {
            System.out.println(p.getNombre()+" Crédito: "+p.getCredito());
        }
    }
    public void mostrarProfesionalesOrdenados(){
    List<Profesional> listaOrdenada = ordenarEquitativamente(profesionales);
        for (Profesional p : listaOrdenada) {
            System.out.println(p.getNombre()+
                    " Crédito: "+p.getCredito()
                    + " Guardias FoF: "+p.getGuardiasFinde()
            +" DispoDia: "+p.getDisponibilidadDia()+" DispoNoche: "+p.getDisponibilidadNoche()
            +" DispoCentinela: "+p.getDisponibilidadCentinela());
        }
    }
    
    public List<Profesional> ordenarEquitativamente(List<Profesional> profesionales) {
        Collections.sort(profesionales, new ProfesionalComparator());
        return profesionales;
    }
    
    private static class ProfesionalComparator implements Comparator<Profesional> {
        @Override
        public int compare(Profesional p1, Profesional p2) {
            int p1Dispo = p1.getDisponibilidadDia().length() + p1.getDisponibilidadNoche().length()
                    +p1.getCredito()+valorLicencia(p1);
            int p2Dispo = p2.getDisponibilidadDia().length() + p2.getDisponibilidadNoche().length()
                    +p2.getCredito()+valorLicencia(p2);

            return Integer.compare(p1Dispo,p2Dispo);
        }
    }
    
    public List<Profesional> ordenarCentinelas(List<Profesional> profesionales) {
        Collections.sort(profesionales, new CentinelasComparator());
        return profesionales;
    }
    
    private static class CentinelasComparator implements Comparator<Profesional> {
        @Override
        public int compare(Profesional p1, Profesional p2) {
            int p1Dispo = p1.getDisponibilidadCentinela().length()+p1.getCredito();
            int p2Dispo = p2.getDisponibilidadCentinela().length()+p2.getCredito();

            return Integer.compare(p2Dispo,p1Dispo);
        }
    }
    
    public void mostrarOrdenCentinelas(){
    List<Profesional> listaOrdenada = ordenarCentinelas(profesionales);
        for (Profesional p : listaOrdenada) {
            System.out.println(p.getNombre()+
                    " Crédito: "+p.getCredito()
                    + " DispoCentinela: "+p.getDisponibilidadCentinela());
        }
    }
    
}

