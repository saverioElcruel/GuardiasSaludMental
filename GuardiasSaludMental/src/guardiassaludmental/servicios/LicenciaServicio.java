package guardiassaludmental.servicios;

import guardiassaludmental.entidades.Licencia;
import guardiassaludmental.persistencia.LicenciaDAO;
import java.util.Date;
import java.util.Scanner;

public class LicenciaServicio {
    
    private final LicenciaDAO DAO;
    
    Scanner sc = new Scanner(System.in).useDelimiter("\n");
     
    public LicenciaServicio(){
        this.DAO = new LicenciaDAO();
    }
    
    public Licencia crearLicencia(){
        System.out.println("Fecha de inicio de la licencia(dd/mm/aaaa): ");
        String fecha = sc.next();
        String fechak[] = fecha.split("/");
        Date inicio = new Date(Integer.parseInt(fechak[2]) - 1900, Integer.parseInt(fechak[1]), Integer.parseInt(fechak[0]));
        /*       
        long unDiaEnMiliSegundos = 24 * 60 * 60 * 1000;
        long inicioEnMiliSegundos = inicio.getTime();
        */
        System.out.println("Fecha de fin de la licencia(dd/mm/aaaa): ");
        String fecha2 = sc.next();
        String fechak2[] = fecha2.split("/");
        Date fin = new Date(Integer.parseInt(fechak2[2]) - 1900, Integer.parseInt(fechak2[1]), Integer.parseInt(fechak2[0]));
        Licencia licencia = new Licencia(inicio,fin);
        DAO.guardar(licencia);
        return licencia;
    }
    
}
