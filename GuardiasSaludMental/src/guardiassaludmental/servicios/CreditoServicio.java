package guardiassaludmental.servicios;

import guardiassaludmental.entidades.Credito;
import guardiassaludmental.persistencia.CreditoDAO;
import java.util.Scanner;

public class CreditoServicio {
    
     private final CreditoDAO DAO;
     
     Scanner sc = new Scanner(System.in).useDelimiter("\n");
    
    public CreditoServicio(){
        this.DAO = new CreditoDAO();
    }
    public void crearCredito(Credito credito){
        DAO.guardar(credito);
    }
    
    public Credito crearCredito(){
        System.out.println("¿Cuántas guardias quiere?");
        int eleccion = sc.nextInt();
        Credito credito = new Credito(eleccion,4);
        return credito;
    }
    
}
