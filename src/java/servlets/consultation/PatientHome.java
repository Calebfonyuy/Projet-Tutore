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

/**
 * Servlet implementation class PatientHome
 */
@WebServlet("/PatientHome")
public class PatientHome extends HttpServlet {
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
        if(patient==null){
            this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            return ;
        }

        List<Consultation> consultations = fetch.fetchPatientConsultation(patient.getId());
        request.setAttribute("consultations", consultations);
        this.getServletContext().getRequestDispatcher("/WEB-INF/patientHome.jsp").forward(request, response);
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
            doGet(request,response);
    }

}
