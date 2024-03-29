/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.formule;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.FormuleQuantite;
import model.Materiau;
import model.Meuble;

/**
 *
 * @author HERINIAINA
 */
@WebServlet(name = "InsertFormuleServlet", urlPatterns = {"/InsertFormule"})
public class InsertFormuleServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String idMeuble = request.getParameter("id_meuble");
            Meuble meuble = new Meuble(idMeuble);
            meuble.findById(null);
            List<Materiau> materiaux = meuble.getStyle().selectMateriau(null);
            List<FormuleQuantite> formules = new ArrayList<>();
            for( Materiau materiau : materiaux){
                FormuleQuantite formule = new FormuleQuantite();
                formule.setMeuble(meuble);
                formule.setMateriau(materiau);
                formule.setQuantite(request.getParameter(String.valueOf(materiau.getId())));
                formules.add(formule);
            }
            meuble.setFormules(formules);
            meuble.saveFormule(null);
            RequestDispatcher dispat = request.getRequestDispatcher("index.jsp");
            dispat.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(InsertFormuleServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
        processRequest(request, response);
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
        processRequest(request, response);
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
