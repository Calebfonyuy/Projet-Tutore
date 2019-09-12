/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.administration;

import beans.personne.Patient;
import beans.personne.Personnel;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import persist.DataFetch;

/**
 *
 * @author suuynyuy
 */
@WebServlet(name = "AdminPatients", urlPatterns = {"/admin_patients"})
public class AdminPatients extends HttpServlet {
    @EJB
    DataFetch fetch;

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
        HttpSession session = request.getSession(false);
        Personnel p = null;
        if(session!=null)
            p = (Personnel)session.getAttribute("personel");
        if(session==null||p==null){
            this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            return;
        }
        request.setAttribute("personel",p);
        
        List<Patient> list = fetch.fetchPatients();
        System.out.println("Number of patients: "+list.size());
        request.setAttribute("patients", list);
        this.getServletContext().getRequestDispatcher("/WEB-INF/adminPatients.jsp").forward(request, response);
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
