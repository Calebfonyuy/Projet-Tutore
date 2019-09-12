package persist;

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
public interface DataPersistRemote {
	public String persistDoctor(Doctor doc);
        public boolean updateDoctor(Doctor doc);
	
	public String persistGeneralist(Generalist gen);
        public boolean updateGeneralist(Generalist gen);
	
	public String persistPatient(Patient patient);
        public boolean updatePatient(Patient patient);
	
	public String persistPersonnel(Personnel person);
        public boolean updatePersonnel(Personnel person);
	
	public String persistMedicament(Medicament med);
	
	public boolean persistMaladie(Maladie mal);
	
	public String persistConsultation(Consultation consult);
        
        public String persistReimboursement(Reimboursement rem);
        
        public boolean chooseMedecinTraitant(String idMed, String idPat);
}
