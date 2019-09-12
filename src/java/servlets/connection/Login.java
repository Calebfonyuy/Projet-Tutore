package servlets.connection;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.personne.Doctor;
import beans.personne.Generalist;
import beans.personne.Patient;
import beans.personne.Personnel;
import beans.sante.Consultation;
import java.util.List;
import persist.DataFetch;

@WebServlet("/login")
public class Login extends HttpServlet{
	
	@EJB
	DataFetch dataFetcher;
        
    /**
     *
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
            this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String identifiant = request.getParameter("logIdentifiant");
		String password = request.getParameter("logPassword");
		
		if(identifiant.startsWith("DOC")) {
			Doctor doc = dataFetcher.signDocIn(identifiant, password);
			if(doc != null) {
				request.setAttribute("medecin", doc);
                                request.getSession(true).setAttribute("medecin", doc);
                                List<Consultation> consultations = dataFetcher.fetchDocConsultation(doc.getId());
                                request.setAttribute("consultations", consultations);
				this.getServletContext().getRequestDispatcher("/WEB-INF/HistoriqueConsultation.jsp").forward(request, response);
			}else {
                            request.setAttribute("identifiant", identifiant);
                            doGet(request,response);
                        }
		}else if(identifiant.startsWith("GEN")) {
			Generalist gen = dataFetcher.signGenIn(identifiant, password);
			if(gen != null) {
				request.setAttribute("medecin", gen);
                                request.getSession(true).setAttribute("medecin", gen);
                                List<Consultation> consultations = dataFetcher.fetchDocConsultation(gen.getId());
                                request.setAttribute("consultations", consultations);  
				this.getServletContext().getRequestDispatcher("/WEB-INF/HistoriqueConsultation.jsp").forward(request, response);
				
			}else {
                            request.setAttribute("identifiant", identifiant);
                            doGet(request,response);
                        }
			
		}else if(identifiant.startsWith("ASS")) {
			Patient ass = dataFetcher.signPatIn(identifiant, password);
			if(ass != null) {
				request.setAttribute("patient", ass);
                                request.getSession(true).setAttribute("patient", ass);
                                List<Consultation> consultations = dataFetcher.fetchPatientConsultation(ass.getId());
                                request.setAttribute("consultations", consultations);
				this.getServletContext().getRequestDispatcher("/WEB-INF/patientHome.jsp").forward(request, response);
				
			}else {
                            request.setAttribute("identifiant", identifiant);
                            doGet(request,response);
                        }
		}else if(identifiant.startsWith("ADMIN")) {
			Personnel per = dataFetcher.signPersIn(identifiant, password);
			if(per != null) {
				request.setAttribute("personel", per);
                                request.getSession(true).setAttribute("personel", per);
				this.getServletContext().getRequestDispatcher("/WEB-INF/adminHome.jsp").forward(request, response);
			}else {
                            request.setAttribute("identifiant", identifiant);
                            doGet(request,response);
                        }
		}else {
			request.setAttribute("identifiant", identifiant);
			doGet(request,response);
		}
		
	}
}
