package persist;

import java.util.List;

import javax.ejb.Remote;

import beans.personne.Doctor;
import beans.personne.Generalist;
import beans.personne.Patient;
import beans.personne.Personnel;
import beans.sante.Consultation;
import beans.sante.Maladie;
import beans.sante.Medicament;
import beans.sante.Reimboursement;

@Remote
public interface DataFetchRemote {
	public List<Doctor> fetchDoctors();
	public Doctor fetchDoctor(String id);
	
	public List<Generalist> fetchGeneralist();
	public Generalist fetchGeneralist(String id);
	
	public List<Patient> fetchPatients();
	public Patient fetchPatient(String id);
	
	public Personnel fetchPersonnel(String id);
	public List<Personnel> fetchPersonnel();
	
	public Medicament fetchMedicament(String id);
	public List<Medicament> fetchMedicament();
	
	public Maladie fetchMaladie(String id);
	public List<Maladie> fetchMaladie();
	
	public Consultation fetchConsultation(String id);
	public List<Consultation> fetchConsultation();
        
        public Reimboursement fetchReimboursement(String id);
        public List<Reimboursement> fetchReimboursement();
        
        public Doctor signDocIn(String id, String password);
        public Patient signPatIn(String id,String password);
        public Personnel signPersIn(String id, String password);
        public Generalist signGenIn(String id, String password);
        
        public List<Consultation> fetchPatientConsultation(String id);
        public List<Consultation> fetchDocConsultation(String id);
}
