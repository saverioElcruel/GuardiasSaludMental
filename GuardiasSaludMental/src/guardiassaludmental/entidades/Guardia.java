
package guardiassaludmental.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Guardia implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid")
    private String id;
    
    @Temporal(TemporalType.DATE)
    private Date fecha;
    private Turno turno;
    
    @OneToOne
    private Profesional profesional;

    public Guardia() {
    }

    public Guardia(Date fecha, Turno turno) {
        this.fecha = fecha;
        this.turno = turno;
    }
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public Profesional getProfesional() {
        return profesional;
    }

    public void setProfesional(Profesional profesional) {
        this.profesional = profesional;
    }
    
}
