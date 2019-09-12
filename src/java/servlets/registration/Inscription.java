package servlets.registration;

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
import persist.DataPersist;

/**
 * Servlet implementation class Enregistrement
 */
@WebServlet("/inscription")
public class Inscription extends HttpServlet {
	
	@EJB
	DataPersist persister;
        
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String contact = request.getParameter("contact");
		String adresse = request.getParameter("adresse");
		String password = request.getParameter("password");
		String categorie = request.getParameter("categorie");
		
		System.out.println("categorie = "+categorie);
		
		
		if(categorie.equals("assure")) {
			System.out.println("entered assure");
			Patient pat = new Patient();
			pat.setName(nom);
			pat.setSurname(prenom);
			pat.setContact(contact);
			pat.setAddress(adresse);
			pat.setPassword(password);
			
			String id = persister.persistPatient(pat);
			System.out.println("entered assure");
			
			if(id != null) {
				pat.setId(id);
				request.setAttribute("patient", pat);
				this.getServletContext().getRequestDispatcher("/WEB-INF/patientHome.jsp").forward(request, response);
			}else {
				request.setAttribute("personne", pat);
				this.getServletContext().getRequestDispatcher("/index.html");
			}
			
		}else if(categorie.equals("specialiste")) {
			System.out.println("entered assure");
			Doctor spe = new Doctor();
			spe.setName(nom);
			spe.setSurname(prenom);
			spe.setContact(contact);
			spe.setAddress(adresse);
			spe.setPassword(password);
			
			String id = persister.persistDoctor(spe);
			System.out.println("entered assure");
			
			if(id != null) {
				spe.setId(id);
				request.setAttribute("medecin", spe);
				this.getServletContext().getRequestDispatcher("/WEB-INF/MedecinAcceuil.jsp").forward(request, response);
			}else {
				request.setAttribute("personne", spe);
				this.getServletContext().getRequestDispatcher("/index.html").forward(request, response);
			}
		}else if(categorie.equals("generaliste")) {
			System.out.println("entered assure");
			Generalist gen = new Generalist();
			gen.setName(nom);
			gen.setSurname(prenom);
			gen.setContact(contact);
			gen.setAddress(adresse);
			gen.setPassword(password);
			
			String id = persister.persistGeneralist(gen);
			System.out.println("entered assure");
			
			if(id != null) {
				gen.setId(id);
				request.setAttribute("medecin", gen);
				this.getServletContext().getRequestDispatcher("/WEB-INF/MedecinAcceuil.jsp").forward(request, response);
			}else {
				request.setAttribute("personne", gen);
				this.getServletContext().getRequestDispatcher("/index.html").forward(request, response);
			}
			
			
		}else {
			doGet(request,response);
		}
	}

	
}
