package persist;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;


import beans.personne.Doctor;
import beans.personne.Personne;
import beans.personne.Generalist;
import beans.personne.Patient;
import beans.personne.Personnel;
import beans.sante.Consultation;
import beans.sante.Maladie;
import beans.sante.Medicament;
import beans.sante.Reimboursement;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

@Stateful(name="DataFetch", mappedName="DataFetch")
@LocalBean
public class DataFetch implements DataFetchRemote {
	private final EntityManagerFactory factory;
        private final EntityManager manager;
        private Query query;
        
	
    public DataFetch() {
    	factory = Persistence.createEntityManagerFactory("Projet_TutorePU");
        manager = factory.createEntityManager();
    }

	@Override
	public List<Doctor> fetchDoctors() {
		query = manager.createQuery("Select d from Doctor d");
		return (List<Doctor>)query.getResultList();
	}

	@Override
	public Doctor fetchDoctor(String id) {
            Doctor doc = manager.find(Doctor.class, id);
            return doc;
	}

	@Override
	public List<Generalist> fetchGeneralist() {
            query = manager.createQuery("SELECT g from Generalist g");
            return (List<Generalist>)query.getResultList();
	}

	@Override
	public Generalist fetchGeneralist(String id) {
		return manager.find(Generalist.class,id);
	}

	@Override
	public List<Patient> fetchPatients() {
            query = manager.createQuery("SELECT p from Patient p",Patient.class);
            return query.getResultList();
	}

	@Override
	public Patient fetchPatient(String id) {
		return manager.find(Patient.class,id);
	}

	@Override
	public Personnel fetchPersonnel(String id) {
		return manager.find(Personnel.class,id);
	}

	@Override
	public List<Personnel> fetchPersonnel() {
            query = manager.createQuery("SELECT p from Personnel p");
            return (List<Personnel>)query.getResultList();
	}

	@Override
	public Medicament fetchMedicament(String id) {
		return manager.find(Medicament.class,id);
	}

	@Override
	public List<Medicament> fetchMedicament() {
		query = manager.createQuery("select m from Medicament m");
		return (List<Medicament>)query.getResultList();
	}

	@Override
	public Maladie fetchMaladie(String id) {
		return manager.find(Maladie.class,id);
	}

	@Override
	public List<Maladie> fetchMaladie() {
		query = manager.createQuery("select m from Maladie m");
		return (List<Maladie>)query.getResultList();
	}

	@Override
	public Consultation fetchConsultation(String id) {
		return manager.find(Consultation.class, id);
	}

	@Override
	public List<Consultation> fetchConsultation() {
		query = manager.createQuery("select c from Consultation c");
		return (List<Consultation>)query.getResultList();
	}
        
        

    @Override
    public Doctor signDocIn(String id, String password) {
        Doctor doc = manager.find(Doctor.class, id);
        if(doc==null)
            return null;
        else{
            if(doc.getPassword().equals(password))
                return doc;
            else return null;
        }
    }

    @Override
    public Patient signPatIn(String id, String password) {
        Patient pat = manager.find(Patient.class,id);
        if(pat==null) return null;
        else{
            if(pat.getPassword().equals(password)) return pat;
            else return null;
        }
    }

    @Override
    public Personnel signPersIn(String id, String password) {
        Personnel pers = manager.find(Personnel.class,id);
        if(pers==null) return null;
        else{
            if(pers.getPassword().equals(password)) return pers;
            else return null;
        }
    }

    @Override
    public Generalist signGenIn(String id, String password) {
        Generalist gen = manager.find(Generalist.class, id);
        if(gen==null) return null;
        else{
            if(gen.getPassword().equals(password)) return gen;
            else return null;
        }
    }      

    @Override
    public List<Consultation> fetchPatientConsultation(String id) {
        return manager.createQuery("Select c from Consultation c where c.patient.id= ?1", Consultation.class).setParameter(1, id).getResultList();
       
    }

    @Override
    public List<Consultation> fetchDocConsultation(String id) {
        return manager.createQuery("Select c from Consultation c where c.doctor.id= ?1",Consultation.class).setParameter(1, id).getResultList();
    }

    @Override
    public Reimboursement fetchReimboursement(String id) {
        return manager.find(Reimboursement.class,id);
    }

    @Override
    public List<Reimboursement> fetchReimboursement() {
        return manager.createQuery("Select r from Reimboursement r",Reimboursement.class).getResultList();
    }
}
