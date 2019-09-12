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
import persist.DataPersist;

@WebServlet("/ModifierProfilMedecin")
public class ModifierProfilMedecin extends HttpServlet {
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
            HttpSession session = request.getSession(false);
            Doctor doc=null;
            if(session!=null)
                doc=(Doctor)session.getAttribute("medecin");
            if(session==null||doc==null)
                this.getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
            
            request.setAttribute("medecin", doc);
            this.getServletContext().getRequestDispatcher("/WEB-INF/modifierProfilMedecin.jsp").forward(request, response);
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
            HttpSession session = request.getSession(false);
            Doctor doc=null;
            if(session!=null)
                doc=(Doctor)session.getAttribute("medecin");
            if(session==null||doc==null){
                this.getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
                return;
            }
            
            String nom=request.getParameter("name");
            String prenom=request.getParameter("surname");
            String address= request.getParameter("address");
            String tel=request.getParameter("telephone");
            String pass1=request.getParameter("pass");
            String pass2=request.getParameter("passwd");
            String alert;
            if(!pass1.equals(pass2)){
                    alert="Veuillez entrer le bon mot de passe";
            }
            doc.setContact(tel);
            doc.setName(nom);
            doc.setAddress(address);
            doc.setPassword(pass1);
            doc.setSurname(prenom);
            request.setAttribute("medecin", doc);
            
            if(persist.updateDoctor(doc)){
                List<Consultation> consultations = fetch.fetchDocConsultation(doc.getId());
                request.setAttribute("consultations", consultations);
                this.getServletContext().getRequestDispatcher("/WEB-INF/HistoriqueConsultation.jsp").forward(request, response);
            }
            	
            doGet(request, response);
	}

}
