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
import beans.sante.Consultation;
import java.util.List;
import persist.DataFetch;

/**
 * Servlet implementation class DoctorHome
 */
@WebServlet("/DoctorHome")
public class DoctorHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB 
    private DataFetch fetch;
    public DoctorHome() {
       
    }

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
            
            List<Consultation> consultations =fetch.fetchDocConsultation(doc.getId());
            request.setAttribute("consultations", consultations);
            this.getServletContext().getRequestDispatcher("/WEB-INF/HistoriqueConsultation.jsp").forward(request, response);
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


