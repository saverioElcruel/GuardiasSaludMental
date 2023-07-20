package entidades;

public class Profesional {
    private String nombre;
    private String disponibilidadDia;
    private String disponibilidadNoche;
    private String disponibilidadCentinela;
    private int credito;
    private int guardiasFinde;
    private int guardiasAsignadas;
    private boolean centinela;

    public Profesional(String nombre, String disponibilidadDia, String disponibilidadNoche,String disponibilidadCentinela,int credito, int guardiasFinde, int guardiasAsignadas,boolean centinela) {
        this.nombre = nombre;
        this.disponibilidadDia = disponibilidadDia;
        this.disponibilidadNoche = disponibilidadNoche;
        this.disponibilidadCentinela = disponibilidadCentinela;
        this.credito = credito;
        this.guardiasFinde = guardiasFinde;
        this.guardiasAsignadas = guardiasAsignadas;
        this.centinela = centinela;
    }

    public Profesional(String nombre) {
        this.nombre = nombre;
    }
    
    

    public String getDisponibilidadDia() {
        return disponibilidadDia;
    }

    public void setDisponibilidadDia(String disponibilidadDia) {
        this.disponibilidadDia = disponibilidadDia;
    }

    public String getDisponibilidadNoche() {
        return disponibilidadNoche;
    }

    public void setDisponibilidadNoche(String disponibilidadNoche) {
        this.disponibilidadNoche = disponibilidadNoche;
    }

    public String getDisponibilidadCentinela() {
        return disponibilidadCentinela;
    }

    public void setDisponibilidadCentinela(String disponibilidadCentinela) {
        this.disponibilidadCentinela = disponibilidadCentinela;
    }

   

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    public int getCredito() {
        return credito;
    }

    public void setCredito(int credito) {
        this.credito = credito;
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

    public boolean isCentinela() {
        return centinela;
    }

    public void setCentinela(boolean centinela) {
        this.centinela = centinela;
    }
    
    
}
