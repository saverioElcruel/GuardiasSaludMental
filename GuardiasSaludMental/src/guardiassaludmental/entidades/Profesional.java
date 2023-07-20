
package guardiassaludmental.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Profesional implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid")
    private String id;
    
    private String nombre;
    @OneToOne
    private Disponibilidad disponibilidad;
    
    private int credito;
    private int guardiasFinde;
    private int guardiasAsignadas;

    public Profesional() {
    }

    public Profesional(String nombre, Disponibilidad disponibilidad, int credito, int guardiasFinde, int guardiasAsignadas) {
        this.nombre = nombre;
        this.disponibilidad = disponibilidad;
        this.credito = credito;
        this.guardiasFinde = guardiasFinde;
        this.guardiasAsignadas = guardiasAsignadas;
    }

    
    
    public int getGuardiasFinde() {
        return guardiasFinde;
    }

    public void setGuardiasFinde(int guardiasFinde) {
        this.guardiasFinde = guardiasFinde;
    }

    public int getGuardiasAsignadas() {
        return guardiasAsignadas;
    }

    public void setGuardiasAsignadas(int guardiasAsignadas) {
        this.guardiasAsignadas = guardiasAsignadas;
    }
    
   
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Disponibilidad getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(Disponibilidad disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    

    public int getCredito() {
        return credito;
    }

    public void setCredito(int credito) {
        this.credito = credito;
    }
    
    
}
