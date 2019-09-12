package servlets.consultation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
import beans.sante.Medicament;
import java.sql.Date;
import persist.DataFetch;
import persist.DataPersist;

/**
 * Servlet implementation class ConsultationServlet
 */
@WebServlet("/ConsultationServlet")
public class ConsultationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private DataFetch inst;
	@EJB
	private DataPersist persist;

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            HttpSession session =request.getSession(false);
            Doctor doc = null;
            if(session!=null)
                doc= (Doctor) session.getAttribute("medecin");
            if(session==null||doc==null){
                this.getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
                return;
            }
            
            List<Medicament> list = inst.fetchMedicament();
            request.setAttribute("medicaments", list);
            this.getServletContext().getRequestDispatcher("/WEB-INF/medecinConsultation.jsp").forward(request, response);
        }

	/**
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
        @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            HttpSession session =request.getSession(false);
            if(session==null){
                doGet(request,response);
                return;
            }
            Doctor doctor = (Doctor) session.getAttribute("medecin");
            if(doctor==null){
                doGet(request,response);
                return;
            }
            
            String alert=null;
            String idAssure=request.getParameter("identifier");
            String detailsCons = "Taille: "+request.getParameter("taille")+"M<br>";
            detailsCons = detailsCons+"Poids: "+request.getParameter("poids")+"<br>";
            detailsCons = detailsCons+"Temp: "+request.getParameter("temperature")+"<br>";
            detailsCons=detailsCons+"Details: "+request.getParameter("consultation");
            String temperature =request.getParameter("temperature");
            String poids =request.getParameter("poids");
            String taille= request.getParameter("taille");
            String[] meds = request.getParameterValues("medicaments");
            int n= (meds==null)?0:meds.length;

            List<Medicament> listMed=new ArrayList<>();
            for(int i=0;i<n;i++) {
                listMed.add(inst.fetchMedicament(meds[i]));
            }

            Patient patient =inst.fetchPatient(idAssure);
            
            Consultation cons =new Consultation();
            cons.setMedicaments(listMed);
            cons.setPatient(patient);
            cons.setDoctor(doctor);
            cons.setObservation(detailsCons);
            cons.setDate(new Date(System.currentTimeMillis()));

            String consulpersisted=null;
            if(patient==null) {
                    alert="Veuillez entrez une numéro d'assuré valide";
            }
            else{
                consulpersisted=persist.persistConsultation(cons);
            }
            if(consulpersisted==null){
                alert=(patient==null)?alert:"Veuillez sauvegarder à nouveau votre historique";
                request.setAttribute("observation", detailsCons);
                request.setAttribute("taille", taille);
                request.setAttribute("poids", poids);
                request.setAttribute("temperature", temperature);
                request.setAttribute("alert", alert);
            }else{
                alert= "Consulation enregistré";
            }

            request.setAttribute("alert", alert);
            doGet(request,response);
	}
	
}
	


