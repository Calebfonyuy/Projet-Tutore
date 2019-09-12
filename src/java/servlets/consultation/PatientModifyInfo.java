package servlets.consultation;



import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.personne.Patient;
import beans.sante.Consultation;
import java.util.List;
import persist.DataFetch;
import persist.DataPersist;

/**
 * Servlet implementation class PatientmodifyInfo
 */
@WebServlet("/PatientmodifyInfo")
public class PatientModifyInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @EJB
    DataPersist persist;
    @EJB
    DataFetch fetch;

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
        Patient patient=null;
        if(session!=null)
            patient= (Patient) session.getAttribute("patient");
        if(session==null||patient==null)
            this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        
        request.setAttribute("patient",patient);
        this.getServletContext().getRequestDispatcher("/WEB-INF/patientModifyInfo.jsp").forward(request, response);
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
        HttpSession session =request.getSession(true);
        Patient patient =(Patient) session.getAttribute("patient");
        String name=(String) request.getParameter("name");
        String surname=request.getParameter("surname");
        String address =request.getParameter("address");
        String telephone=request.getParameter("contact");
        String passwrd= request.getParameter("password");
        String pass=request.getParameter("password2");
        String alert="Profil modifié";
        
        patient.setName(name);
        patient.setSurname(surname);
        patient.setAddress(address);
        patient.setContact(telephone);
        patient.setPassword(passwrd);
        
        if(!pass.equals(passwrd)) {
            alert="Veuillez entrer un mot de passe identique";
        }else if(persist.updatePatient(patient)){
            List<Consultation> consultations = fetch.fetchPatientConsultation(patient.getId());
            request.setAttribute("consultations", consultations);
            this.getServletContext().getRequestDispatcher("/WEB-INF/patientHome.jsp").forward(request, response);
            return;
        }
        
        request.setAttribute(alert, alert);
        request.setAttribute("patient",patient);
        this.getServletContext().getRequestDispatcher("/WEB-INF/patientModifyInfo.jsp").forward(request, response);
        
        
}

}
