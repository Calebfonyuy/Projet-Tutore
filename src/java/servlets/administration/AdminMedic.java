/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.administration;

import beans.personne.Personnel;
import beans.sante.Medicament;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persist.DataFetch;
import persist.DataPersist;

/**
 *
 * @author suuynyuy
 */
@WebServlet(name = "AdminMedic", urlPatterns = {"/admin_medicaments"})
public class AdminMedic extends HttpServlet {
    @EJB
    DataFetch fetch;
    @EJB
    DataPersist persist;

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Personnel p = (Personnel)request.getSession().getAttribute("personel");
        if(p==null){
            this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            return;
        }
        request.setAttribute("personel",p);
        
        List<Medicament> meds = fetch.fetchMedicament();
        request.setAttribute("meds", meds);
        this.getServletContext().getRequestDispatcher("/WEB-INF/adminMedicament.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            Medicament med = new Medicament();
            med.setName(request.getParameter("name"));
            med.setDescription(request.getParameter("desc"));
            String id = persist.persistMedicament(med);
            if(id==null)
                throw new Exception("failed");
        }catch(Exception ex){
            request.setAttribute("warning", "Echec d'enregistrement");
            request.setAttribute("name", request.getParameter("name"));
            request.setAttribute("desc", request.getParameter("desc"));
            ex.printStackTrace();
        }
        doGet(request,response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
