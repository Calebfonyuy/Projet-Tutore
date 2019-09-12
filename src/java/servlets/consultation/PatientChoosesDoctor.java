package servlets.consultation;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.personne.Doctor;
import beans.personne.Patient;
import beans.sante.Consultation;
import java.util.List;
import persist.DataFetch;
import persist.DataPersist;

@WebServlet("/PatientChoosesDoctor")

public class PatientChoosesDoctor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private DataPersist inst;
	@EJB
	private DataFetch fetch;
	
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        Patient patient =null;
        if(session!=null)
            patient= (Patient)session.getAttribute("patient");
        if(patient==null){
            this.getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
            return;
        }
        
        
        List<Doctor> list = fetch.fetchDoctors();
        request.setAttribute("medecins", list);
        request.setAttribute("patient",patient);
	this.getServletContext().getRequestDispatcher("/WEB-INF/patientChooseDoctor.jsp").forward(request, response);
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session =request.getSession(false);

        Patient patient =(Patient) session.getAttribute("patient");
        String idPatient =patient.getId();
        String idDoc= (String) request.getAttribute("medecin");
        String alert;
        Doctor doc=fetch.fetchDoctor(idDoc);
        if(patient.getMedecin()!=null) {
            alert="Vous avez dejà choisi votre médecin, le docteur :"+patient.getMedecin().getName();
            request.setAttribute("alert", alert);
            doGet(request,response);
        }
        else
        {
            if(doc==null) {
                alert="Veuillez correctement entrer l'identifiant de votre médecin";
                request.setAttribute("alert", alert);	
                doGet(request,response);
            }else{
                Boolean choose=inst.chooseMedecinTraitant( idDoc, idPatient);
                if(!choose) {
                    alert="L'enregistrement du choix a échoué";
                    request.setAttribute("alert", alert);	
                    doGet(request,response);
                }else {
                    List<Consultation> consultations = fetch.fetchPatientConsultation(patient.getId());
                    request.setAttribute("consultations", consultations);
                    this.getServletContext().getRequestDispatcher("/WEB-INF/patientHome.jsp").forward(request, response);
                }
            }
        }
    }
}
