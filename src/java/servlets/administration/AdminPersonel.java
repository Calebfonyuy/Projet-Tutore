/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.administration;

import beans.personne.Personnel;
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
@WebServlet(name = "AdminPersonel", urlPatterns = {"/admin_personel"})
public class AdminPersonel extends HttpServlet {
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
        
         List<Personnel> pers = fetch.fetchPersonnel();
         request.setAttribute("personels", pers);
        this.getServletContext().getRequestDispatcher("/WEB-INF/adminPersonel.jsp").forward(request, response);
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
        /*Personnel p = (Personnel)request.getSession().getAttribute("person");
        if(p==null)
            this.getServletContext().getRequestDispatcher("index.html").forward(request, response);*/
        try{
            Personnel pers = new Personnel();
            pers.setName(request.getParameter("name"));
            pers.setSurname(request.getParameter("surname"));
            pers.setAddress(request.getParameter("address"));
            pers.setContact(request.getParameter("telephone"));
            pers.setPassword(request.getParameter("password"));
            
            String id = persist.persistPersonnel(pers);
            if(id==null)
                request.setAttribute("npers", pers);
        }catch(Exception e){
            e.printStackTrace();
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
