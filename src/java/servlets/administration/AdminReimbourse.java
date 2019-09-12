/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.administration;

import beans.personne.Personnel;
import beans.sante.Consultation;
import beans.sante.Reimboursement;
import java.io.IOException;
import java.sql.Date;
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
@WebServlet(name = "AdminReimbouse", urlPatterns = {"/admin_reimboursement"})
public class AdminReimbourse extends HttpServlet {
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
        
        List<Reimboursement> list = fetch.fetchReimboursement();
        request.setAttribute("reimboursements", list);
        List<Consultation> cons = fetch.fetchConsultation();
        request.setAttribute("consultations", cons);
        this.getServletContext().getRequestDispatcher("/WEB-INF/adminReimbousements.jsp").forward(request, response);
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
            Consultation cons = fetch.fetchConsultation(request.getParameter("consid"));
            if(cons==null) throw new Exception("fails");
            Reimboursement rem = new Reimboursement();
            rem.setConsultation(cons);
            rem.setAmount(Double.parseDouble(request.getParameter("amount")));
            rem.setRefundDate(Date.valueOf(request.getParameter("date")));
            String id=persist.persistReimboursement(rem);
            if(id==null)
                throw new Exception("fails");
        }catch(Exception ex){
            request.setAttribute("warning","Echec lors d'enregistrement");
            request.setAttribute("consid", request.getParameter("consid"));
            request.setAttribute("amount", request.getParameter("amount"));
            request.setAttribute("date", request.getParameter("date"));
            ex.printStackTrace();
        }
        
        doGet(request, response);
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
