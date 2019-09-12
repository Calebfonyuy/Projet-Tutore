package beans.personne;

import javax.ejb.Stateless;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Stateless
@Entity
public class Patient extends Personne {
    @OneToOne
    private Doctor medecin;

    public Doctor getMedecin() {
        return medecin;
    }

    public void setMedecin(Doctor medecin) {
        this.medecin = medecin;
    }
    public Patient() {
            super();
    }
}
