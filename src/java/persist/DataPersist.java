package persist;

import beans.Identite;
import javax.ejb.Stateful;


import beans.personne.Doctor;
import beans.personne.Generalist;
import beans.personne.Patient;
import beans.personne.Personnel;
import beans.sante.Consultation;
import beans.sante.Maladie;
import beans.sante.Medicament;
import beans.sante.Reimboursement;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Session Bean implementation class DataPersist
 */
@Stateful(name="DataPersist",mappedName = "DataPersist")
@LocalBean
public class DataPersist implements DataPersistRemote {
	private final EntityManagerFactory factory;
        private final EntityManager manager;
	private Identite id;
	
    /**
     * Default constructor. 
     */
    public DataPersist() {
        factory = Persistence.createEntityManagerFactory("Projet_TutorePU");
        manager = factory.createEntityManager();
    }

	@Override
	public String persistDoctor(Doctor doc) {
            manager.getTransaction().begin();
            id = manager.find(Identite.class, "Doctor");
            if(id==null){
                id = new Identite();
                id.setNom("Doctor");
                id.setCount(1);
                manager.persist(id);
                id = manager.find(Identite.class, "Doctor");
            }
            
            doc.setId("DOC-"+String.format("%04d",id.getCount()));
            id.setCount(id.getCount()+1);
            manager.persist(doc);
            manager.getTransaction().commit();
            return doc.getId();
	}
        
        

	@Override
	public String persistGeneralist(Generalist gen) {
		manager.getTransaction().begin();
                id = manager.find(Identite.class, "Generalist");
                if(id==null){
                    id = new Identite();
                    id.setNom("Generalist");
                    id.setCount(1);
                    manager.persist(id);
                    id = manager.find(Identite.class, "Generalist");
                }
                gen.setId("GEN-"+String.format("%04d",id.getCount()));
                id.setCount(id.getCount()+1);
		manager.persist(gen);
		manager.getTransaction().commit();
		return gen.getId();
	}

	@Override
	public String persistPatient(Patient patient) {
		manager.getTransaction().begin();
                id = manager.find(Identite.class, "Patient");
                if(id==null){
                    id = new Identite();
                    id.setNom("Patient");
                    id.setCount(1);
                    manager.persist(id);
                    manager.getTransaction().commit();
                    manager.getTransaction().begin();
                    id = manager.find(Identite.class, "Patient");
                }
                patient.setId("ASS-"+String.format("%04d",id.getCount()));
                id.setCount(id.getCount()+1);
		manager.persist(patient);
		manager.getTransaction().commit();
		return patient.getId();
	}

	@Override
	public String persistPersonnel(Personnel person) {
		manager.getTransaction().begin();
                id = manager.find(Identite.class, "Person");
                if(id==null){
                    id = new Identite();
                    id.setNom("Person");
                    id.setCount(1);
                    manager.persist(id);
                    id = manager.find(Identite.class, "Person");
                }
                person.setId("ADMIN-"+String.format("%04d",id.getCount()));
                id.setCount(id.getCount()+1);
		manager.persist(person);
		manager.getTransaction().commit();
		return person.getId();
	}

	@Override
	public String persistMedicament(Medicament med) {
                manager.getTransaction().begin();
                id = manager.find(Identite.class, "Medicament");
                if(id==null){
                    id = new Identite();
                    id.setNom("Medicament");
                    id.setCount(1);
                    manager.persist(id);
                    id = manager.find(Identite.class, "Medicament");
                }
                med.setId("MED-"+String.format("%04d",id.getCount()));
                id.setCount(id.getCount()+1);
		manager.persist(med);
                manager.getTransaction().commit();
		return med.getId();
	}

	@Override
	public boolean persistMaladie(Maladie mal) {
                mal.setName(mal.getName().toUpperCase());
                try{
                    manager.getTransaction().begin();
                    manager.persist(mal);
                    manager.getTransaction().commit();
                }catch(Exception ex){
                    ex.printStackTrace();
                    return false;
                }
		return true;
	}

	@Override
	public String persistConsultation(Consultation consult) {
		try{
                    manager.getTransaction().begin();
                id = manager.find(Identite.class, "Consultation");
                if(id==null){
                    id = new Identite();
                    id.setNom("Consultation");
                    id.setCount(1);
                    manager.persist(id);
                    id = manager.find(Identite.class, "Consultation");
                }
                consult.setId("CONS-"+String.format("%04d",id.getCount()));
                id.setCount(id.getCount()+1);
		manager.persist(consult);
		manager.getTransaction().commit();
		return consult.getId();
                }catch(Exception ex){
                    ex.printStackTrace();
                    return null;
                }
	}

    @Override
    public String persistReimboursement(Reimboursement rem) {
        try{
            manager.getTransaction().begin();
            id = manager.find(Identite.class, "Reimboursement");
            if(id==null){
                id = new Identite();
                id.setNom("Reimboursement");
                id.setCount(1);
                manager.persist(id);
                id = manager.find(Identite.class, "Reimboursement");
            }
            rem.setId("REM-"+String.format("%04d",id.getCount()));
            id.setCount(id.getCount()+1);
            manager.persist(rem);
            manager.getTransaction().commit();
            return rem.getId();
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean chooseMedecinTraitant(String idMed, String idPat) {
        try{
            manager.getTransaction().begin();
            Patient pat = manager.find(Patient.class, idPat);
            if(pat==null) return false;
            Doctor doc = manager.find(Doctor.class, idMed);
            if(doc==null){
                doc = manager.find(Generalist.class, idMed);
                if(doc==null) return false;
            }
            pat.setMedecin(doc);
            manager.getTransaction().commit();
            return true;
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateDoctor(Doctor doc) {
       try{
           manager.getTransaction().begin();
           Doctor doctor = manager.find(Doctor.class, doc.getId());
           doctor.setAddress(doc.getAddress());
           doctor.setContact(doc.getContact());
           doctor.setName(doc.getName());
           doctor.setSurname(doc.getSurname());
           manager.getTransaction().commit();
           return true;
       }catch(Exception ex){
           ex.printStackTrace();
           return false;
       }
    }

    @Override
    public boolean updateGeneralist(Generalist gen) {
        try{
            manager.getTransaction().begin();
            Generalist general = manager.find(Generalist.class, gen.getId());
            general.setName(gen.getName());
            general.setSurname(gen.getSurname());
            general.setAddress(gen.getAddress());
            general.setContact(gen.getContact());
            manager.getTransaction().commit();
            return true;
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updatePatient(Patient patient) {
        try{
            manager.getTransaction().begin();
            Patient pat = manager.find(Patient.class, patient.getId());
            pat.setAddress(patient.getAddress());
            pat.setName(patient.getName());
            pat.setSurname(patient.getSurname());
            pat.setContact(patient.getContact());
            pat.setPassword(patient.getPassword());
            manager.getTransaction().commit();
            return true;
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updatePersonnel(Personnel person) {
        try{
            manager.getTransaction().begin();
            Personnel pat = manager.find(Personnel.class, person.getId());
            pat.setAddress(person.getAddress());
            pat.setName(person.getName());
            pat.setSurname(person.getSurname());
            pat.setContact(person.getContact());
            pat.setPassword(person.getPassword());
            manager.getTransaction().commit();
            return true;
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
}
