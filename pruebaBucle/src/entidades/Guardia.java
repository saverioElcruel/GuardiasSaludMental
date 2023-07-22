
package entidades;

import java.time.LocalDate;

public class Guardia {
    private LocalDate fecha;
    private String turno;
    private Profesional profesional;
    private boolean feriado;

    public Guardia(LocalDate fecha, String turno, boolean feriado) {
        this.fecha = fecha;
        this.turno = turno;
        this.feriado = feriado;
    }

    public void copyDataFrom(Guardia other) {
        this.turno = other.getTurno();
        this.profesional = other.getProfesional();
        this.feriado = other.isFeriado();
        // Add more attributes here if necessary
    }
    
    public Guardia() {
    }

    public Guardia(Profesional profesional) {
        this.profesional = profesional;
    }
    
    

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
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
