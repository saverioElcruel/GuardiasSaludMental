
package servicios;

import entidades.Guardia;
import entidades.Profesional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ServicioGuardiaProfesional {
    
    private List<Guardia> guardias = new ArrayList();
    private List<Profesional> profesionales = new ArrayList();
    
    private Scanner sc = new Scanner(System.in).useDelimiter("\n");
    
    public Date crearFeriado(){
        System.out.println("Ingrese feriado (dd/mm/aaaa):");
        String fecha = sc.next();
            String feriado[] = fecha.split("/");
            Date f1 = new Date(Integer.parseInt(feriado[2]) - 1900, Integer.parseInt(feriado[1]), Integer.parseInt(feriado[0]));
            return f1;
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
           
            if(nuevoDia.getDay()==2||nuevoDia.getDay()==3){
                guardias.add(new Guardia(nuevoDia,"DIA",true));
                guardias.add(new Guardia(nuevoDia,"NOCHE",true));
            }else{
                guardias.add(new Guardia(nuevoDia,"DIA",false));
                guardias.add(new Guardia(nuevoDia,"NOCHE",false));
            }
            
            }
        
//        System.out.println("¿Cuántos feriados tendrá el mes?");
//        int vueltas = sc.nextInt(); 
//        for (int i = 0; i < vueltas; i++) {
//            Date feriado = crearFeriado();
//            for (Guardia guardia : guardias){
//                if(guardia.getFecha()==feriado){
//                    guardia.setFeriado(true);
//                }
//                
//            }
//        }
        
        }
    
    public void mostrarGuardias()throws NullPointerException{
        
        for (Guardia guardia : guardias) {
            try{
                if(guardia.getProfesional().getNombre()!=null){
                    System.out.println(diaEnString(guardia.getFecha())+" "+guardia.getFecha().getDate()+" "+
                    guardia.getFecha().getMonth()+" Turno: "+guardia.getTurno()+" F: "+guardia.isFeriado()+
            " Profesional: "+guardia.getProfesional().getNombre());
                }
                }catch(NullPointerException e){
                   System.out.println(diaEnString(guardia.getFecha())+" "+guardia.getFecha().getDate()+" "+
                    guardia.getFecha().getMonth()+" Turno: "+guardia.getTurno()+" F: "+guardia.isFeriado());
                    }
        }
    }
    
  public void asigDia(){
      List<Profesional> ordenados = ordenarEquitativamente(profesionales);
        for (Profesional p : ordenados) {
            Guardia guardiaAnterior = new Guardia();
            Guardia guardiaAntAnt = new Guardia();
            Guardia gA = new Guardia();
            Guardia gb = new Guardia();
            
            for (Guardia guardia : guardias) {
                if(guardia.getTurno().equals("DIA")
                & p.getDisponibilidadDia().contains(diaEnString(guardia.getFecha()))
                        & p.getCredito()>0
                        & p.getGuardiasFinde()<3
                        & guardia.getProfesional()==null
                        & (p != guardiaAnterior.getProfesional())
                        & (p != guardiaAntAnt.getProfesional())
                        & (p != gA.getProfesional())
                        & (p != gb.getProfesional())) {

                        guardia.setProfesional(p);
                        p.setCredito(p.getCredito() - 1);
                        p.setGuardiasAsignadas(p.getGuardiasAsignadas()+1);
                        
                        if(guardia.isFeriado()){
                            p.setGuardiasFinde(p.getGuardiasFinde()+1);
                        }
                        
                }else if(guardia.getTurno().equals("NOCHE")){
                    if(p.isCentinela()){
                        if(p.getDisponibilidadCentinela().contains(diaEnString(guardia.getFecha()))
                                &guardiaAnterior.getProfesional()==p
                                &p.getCredito()>0
                                & p.getGuardiasFinde()<3
                                & guardia.getProfesional()==null
                                & (p != guardiaAntAnt.getProfesional())
                                & (p != gA.getProfesional())
                                & (p != gb.getProfesional())) {

                        guardia.setProfesional(p);
                        p.setCredito(p.getCredito() - 1);
                        p.setGuardiasAsignadas(p.getGuardiasAsignadas()+1);
                        if(guardia.isFeriado()){
                            p.setGuardiasFinde(p.getGuardiasFinde()+1);
                        }
                        
                        
                    }
                //si p no es centinela
                }else{
                        if(p.getDisponibilidadNoche().contains(diaEnString(guardia.getFecha()))
                                &guardiaAnterior.getProfesional()!=p
                                &p.getCredito()>0
                                & p.getGuardiasFinde()<3
                                & guardia.getProfesional()==null
                                & (p != guardiaAntAnt.getProfesional())
                                & (p != gA.getProfesional())
                                & (p != gb.getProfesional())) {

                        guardia.setProfesional(p);
                        p.setCredito(p.getCredito() - 1);
                        p.setGuardiasAsignadas(p.getGuardiasAsignadas()+1);
                        if(guardia.isFeriado()){
                            p.setGuardiasFinde(p.getGuardiasFinde()+1);
                        }
                    }
                    
        }
    }
                gb = gA;
                    gA = guardiaAntAnt;
                    guardiaAntAnt = guardiaAnterior;
                    guardiaAnterior = guardia;
  }
        }
  }
  
  public void asigNyC(){
      List<Profesional> ordenados = ordenarCentinelas(profesionales);
        for (Profesional p : ordenados) {
            Guardia guardiaAnterior = new Guardia();
            Guardia guardiaAntAnt = new Guardia();
            Guardia gA = new Guardia();
            Guardia gb = new Guardia();
            
            for (Guardia guardia : guardias) {
                if(p.isCentinela()&p.getDisponibilidadCentinela().contains(diaEnString(guardia.getFecha()))
                        &guardia.getTurno().equals("NOCHE")
                        &guardiaAnterior.getProfesional()==p){
                    if(p.getCredito()>0
                        & p.getGuardiasFinde()<3
                        & guardia.getProfesional()==null
                        & (p != guardiaAntAnt.getProfesional())
                        & (p != gA.getProfesional())
                        & (p != gb.getProfesional())) {

                        guardia.setProfesional(p);
                        p.setCredito(p.getCredito() - 1);
                        p.setGuardiasAsignadas(p.getGuardiasAsignadas()+1);
                        
                        gb = gA;
                        gA = guardiaAntAnt;
                        guardiaAntAnt = guardiaAnterior;
                        guardiaAnterior = guardia;
                        
                        if(guardia.isFeriado()){
                            p.setGuardiasFinde(p.getGuardiasFinde()+1);
                        }
                        
                }
                }else  if(!p.isCentinela()&guardia.getTurno().equals("NOCHE")
                        & p.getDisponibilidadNoche().contains(diaEnString(guardia.getFecha()))){
                            if(p.getCredito()>0
                        & p.getGuardiasFinde()<3 
                        & guardia.getProfesional()==null
                        & (p != guardiaAnterior.getProfesional())
                        & (p != guardiaAntAnt.getProfesional())
                        & (p != gA.getProfesional())
                        & (p != gb.getProfesional())) {

                        guardia.setProfesional(p);
                        p.setCredito(p.getCredito() - 1);
                        p.setGuardiasAsignadas(p.getGuardiasAsignadas()+1);
                        
                        gb = gA;
                        gA = guardiaAntAnt;
                        guardiaAntAnt = guardiaAnterior;
                        guardiaAnterior = guardia;
                        
                        if(guardia.isFeriado()){
                            p.setGuardiasFinde(p.getGuardiasFinde()+1);
                        }
                        
                }
                    
                    }
                
        }
    }
  }
    
    
            
    
    
    public void crearProfesionales(){
        Profesional prof1 = new Profesional("Hector", "LMXJVSD", "LMXJVSD","LMXJVSD",15,0,0,true);
        profesionales.add(prof1);
        Profesional prof2 = new Profesional("Maru", "LV", "SD","",5,0,0,false);
        profesionales.add(prof2);
        Profesional prof3 = new Profesional("Lau S", "LMXJVSD", "MS","X", 12,0,0,true);
        profesionales.add(prof3);
        Profesional prof4 = new Profesional("Rodo", "LMXJVSD", "LMXJVSD","LMXJVSD", 12,0,0,true);
        profesionales.add(prof4);
        Profesional prof5 = new Profesional("Javier", "LMXSD", "LMSD","LMSD",12,0,0,true);
        profesionales.add(prof5);
        Profesional prof6 = new Profesional("Flor", "LX", "LXJVD","", 12,0,0,false);
        profesionales.add(prof6);
        Profesional prof7 = new Profesional("Luisi", "LXJSD", "D","", 3,0,0,false);
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
            System.out.println(p.getNombre()+" Crédito: "+p.getCredito()+" Guardias Asignadas: "+p.getGuardiasAsignadas());
        }
    }
    public void mostrarProfesionalesOrdenados(){
    List<Profesional> listaOrdenada = ordenarEquitativamente(profesionales);
        for (Profesional p : listaOrdenada) {
            System.out.println(p.getNombre()+
                    " Crédito: "+p.getCredito()+" Guardias Asignadas: "+p.getGuardiasAsignadas()
                    + " Guardias FoF: "+p.getGuardiasFinde()
            +" DispoDia: "+p.getDisponibilidadDia()+" DispoNoche: "+p.getDisponibilidadNoche());
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
                    +p1.getCredito();
            int p2Dispo = p2.getDisponibilidadDia().length() + p2.getDisponibilidadNoche().length()
                    +p1.getCredito();

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
            int p1Dispo = p1.getDisponibilidadCentinela().length();
            int p2Dispo = p1.getDisponibilidadCentinela().length();

            return Integer.compare(p2Dispo,p1Dispo);
        }
    }
    
    public String diaEnString(Date date){
        int diaInt = date.getDay();
             String dia = "";
             switch(diaInt){
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
}

