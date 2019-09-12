package beans.sante;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import beans.personne.Doctor;
import beans.personne.Patient;
import java.io.Serializable;
import java.sql.Date;
@Entity
@Stateless
public class Consultation implements Serializable{
    @Id
    @Column(name="ID")
    private String id;
    @OneToOne
    private Doctor doctor;
    @OneToOne
    private Patient patient;
    @Column(name="Observation")
    private String observation;
    @Column(name="ConsultationDate")
    private Date date;
    @OneToMany
    private List<Maladie> maladie = new ArrayList<>();
    @OneToMany
    private List<Medicament> medicaments = new ArrayList<>();

    public Consultation() {
            super();
    }

    public String getId() {
            return id;
    }

    public void setId(String id) {
            this.id = id;
    }

    public Doctor getDoctor() {
            return doctor;
    }

    public void setDoctor(Doctor doctor) {
            this.doctor = doctor;
    }

    public Patient getPatient() {
            return patient;
    }

    public void setPatient(Patient patient) {
            this.patient = patient;
    }

    public String getObservation() {
            return observation;
    }

    public void setObservation(String observation) {
            this.observation = observation;
    }

    public List<Maladie> getMaladie() {
            return maladie;
    }

    public void setMaladie(List<Maladie> maladie) {
            this.maladie = maladie;
    }

    public List<Medicament> getMedicaments() {
            return medicaments;
    }

    public void setMedicaments(List<Medicament> medicaments) {
            this.medicaments = medicaments;
    }

    public void addMaladie(Maladie mal) {
            maladie.add(mal);
    }

    public void addMedicament(Medicament med) {
            medicaments.add(med);
    }

    public void removeMaladie(Maladie mal) {
            maladie.remove(mal);
    }

    public void removeMedicament(Medicament med) {
            medicaments.remove(med);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
