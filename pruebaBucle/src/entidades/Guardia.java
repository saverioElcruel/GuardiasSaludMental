
package entidades;

import java.util.Date;

public class Guardia {
    private Date fecha;
    private String turno;
    private Profesional profesional;
    private boolean feriado;

    public Guardia(Date fecha, String turno, boolean feriado) {
        this.fecha = fecha;
        this.turno = turno;
        this.feriado = feriado;
    }

    public Guardia() {
    }

    public Guardia(Profesional profesional) {
        this.profesional = profesional;
    }
    
    

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public Profesional getProfesional() {
        return profesional;
    }

    public void setProfesional(Profesional profesional) {
        this.profesional = profesional;
    }

    public boolean isFeriado() {
        return feriado;
    }

    public void setFeriado(boolean feriado) {
        this.feriado = feriado;
    }
    
    
}
