/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.administration;

import beans.personne.Personnel;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persist.DataPersist;

/**
 *
 * @author suuynyuy
 */
@WebServlet(name = "AdminProfil", urlPatterns = {"/admin_profil"})
public class AdminProfil extends HttpServlet {
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
        
        this.getServletContext().getRequestDispatcher("/WEB-INF/adminModifierProfile.jsp").forward(request,response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occursat java.lang.Thread.run(Thread.java:748)
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Personnel person = (Personnel)request.getSession().getAttribute("personel");
        
        try{
            Personnel pers = new Personnel();
            pers.setId(person.getId());
            pers.setName(request.getParameter("name"));
            pers.setAddress(request.getParameter("address"));
            pers.setContact(request.getParameter("telephone"));
            pers.setSurname(request.getParameter("surname"));
            pers.setPassword(request.getParameter("password"));
            if(persist.updatePersonnel(pers)){
                request.setAttribute("personel", pers);
                request.getSession().setAttribute("personel", pers);
                this.getServletContext().getRequestDispatcher("/WEB-INF/adminHome.jsp").forward(request,response);
            }
            
        }catch(Exception ex){
            ex.printStackTrace();
            request.setAttribute("personel", person);
            this.getServletContext().getRequestDispatcher("/WEB-INF/adminModifierProfile.jsp").forward(request,response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
