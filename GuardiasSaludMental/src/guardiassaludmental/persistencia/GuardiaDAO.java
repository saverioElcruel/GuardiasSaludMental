package guardiassaludmental.persistencia;

import guardiassaludmental.entidades.Guardia;
import java.util.List;

public class GuardiaDAO extends DAO<Guardia>{
    
    @Override
    public void guardar(Guardia guardia) {
        super.guardar(guardia);
    }
    
    public List<Guardia> listarTodasLasGuardias(){
        conectar();
        List<Guardia> guardias = em.createQuery("SELECT m FROM Guardia m ").getResultList();
        return guardias;
    }
    
    public List<Guardia> listarGuardiasDia(){
        conectar();
        List<Guardia> guardias = em.createQuery("SELECT m FROM Guardia m WHERE m.turno LIKE 'DIA' ").getResultList();
        return guardias;
    }
    public List<Guardia> listarGuardiasNoche(){
        conectar();
        List<Guardia> guardias = em.createQuery("SELECT m FROM Guardia m WHERE m.turno LIKE 'NOCHE' ").getResultList();
        return guardias;
    }
     
}
