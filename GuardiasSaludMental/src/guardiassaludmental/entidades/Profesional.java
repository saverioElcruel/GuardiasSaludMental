
package guardiassaludmental.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Profesional implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid")
    private String id;
    
    private String nombre;
    @OneToOne
    private Disponibilidad disponibilidad;
    @OneToMany
    private Licencia licencia;
    @OneToOne
    private Credito credito;

    public Profesional() {
    }
    
    public Profesional(String nombre, Disponibilidad disponibilidad, Licencia licencia, Credito credito) {
        this.nombre = nombre;
        this.disponibilidad = disponibilidad;
        this.licencia = licencia;
        this.credito = credito;
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

    public Licencia getLicencia() {
        return licencia;
    }

    public void setLicencia(Licencia licencia) {
        this.licencia = licencia;
    }

    public Credito getCredito() {
        return credito;
    }

    public void setCredito(Credito credito) {
        this.credito = credito;
    }
    
    
}
