
package guardiassaludmental.persistencia;

import guardiassaludmental.entidades.Profesional;
import java.util.List;

public class ProfesionalDAO extends DAO<Profesional>{
    
    @Override
    public void guardar(Profesional profesional) {
        super.guardar(profesional);
    }
    
    public Profesional buscarPorNombre(String nombre){
        conectar();
        Profesional encontrado = (Profesional) em.createQuery("SELECT a FROM Profesional a WHERE a.nombre LIKE :nombre").setParameter("nombre", nombre).setMaxResults(1).getResultList();
        desconectar();
        return encontrado;
    }
    public List<Profesional> listarTodosLosProfesionales(){
        conectar();
        List<Profesional> profesionales;
        profesionales = em.createQuery("SELECT m FROM Profesional m ").getResultList();
        return profesionales;
    }
    }
