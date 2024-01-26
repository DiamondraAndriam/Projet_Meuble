/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.vente;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Client;
import model.Meuble;
import model.Vente;

/**
 *
 * @author Diamondra
 */
@WebServlet(name = "InsertVenteServlet", urlPatterns = {"/InsertVente"})
public class InsertVenteServlet extends HttpServlet {

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
            String client = request.getParameter("client");
            String date = request.getParameter("date");
            String[] quantite = request.getParameterValues("quantite");
            List<Meuble> meubles = Meuble.findAll(null);
            List<Vente> ventes = new ArrayList<Vente>();
            for (int i = 0; i<meubles.size(); i++) {
                if(quantite[i].equalsIgnoreCase("")==false){
                Vente vente = new Vente();
                vente.setClient(new Client());
                vente.getClient().setId(client);
                vente.setMeuble(meubles.get(i));
                vente.setNombre(quantite[i]);
                vente.setDate(date);
                ventes.add(vente);
                }
            }
            Vente.save(ventes,null);
            response.sendRedirect("index.jsp");
        } catch (Exception ex) {
            Logger.getLogger(InsertVenteServlet.class.getName()).log(Level.SEVERE, null, ex);
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
