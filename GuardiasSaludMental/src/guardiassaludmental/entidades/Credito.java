package guardiassaludmental.entidades;

import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Credito {
    @Id
    @GeneratedValue(generator = "uuid")
    private String id;
    
    private int guardiasMes;
    private int guardiasFindeMes;

    public Credito() {
    }

    public Credito(int guardiasMes, int guardiasFindeMes) {
        this.guardiasMes = guardiasMes;
        this.guardiasFindeMes = guardiasFindeMes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    
    public int getGuardiasMes() {
        return guardiasMes;
    }

    public void setGuardiasMes(int guardiasMes) {
        this.guardiasMes = guardiasMes;
    }

    public int getGuardiasFindeMes() {
        return guardiasFindeMes;
    }

    public void setGuardiasFindeMes(int guardiasFindeMes) {
        this.guardiasFindeMes = guardiasFindeMes;
    }
    
    
}
