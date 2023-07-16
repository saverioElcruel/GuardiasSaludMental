package guardiassaludmental.entidades;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Disponibilidad {
    
    @Id
    @GeneratedValue(generator = "uuid")
    private String id;
    private String dias;
    private String noches;
    private String centinela;

    public Disponibilidad() {
    }

    public Disponibilidad(String dias, String noches, String centinela) {
        this.dias = dias;
        this.noches = noches;
        this.centinela = centinela;
    }
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    public String getNoches() {
        return noches;
    }

    public void setNoches(String noches) {
        this.noches = noches;
    }

    public String getCentinela() {
        return centinela;
    }

    public void setCentinela(String centinela) {
        this.centinela = centinela;
    }
    
    
    
    
}
