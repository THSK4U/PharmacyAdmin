package Pharmacy.web;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Pharmacy.controleur.produitcontrol;
import Pharmacy.modele.produit;
import jakarta.servlet.annotation.WebServlet;


@WebServlet("/")
public class produitservlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private produitcontrol produitcontrol;

    public void init() {
        produitcontrol = new produitcontrol();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertproduit(request, response);
                    break;
                case "/delete":
                    deleteproduit(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateproduit(request, response);
                    break;
                default:
                    listproduit(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listproduit(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        produit[] produits = produitcontrol.selectproduitAll();
        request.setAttribute("produits", produits);
        RequestDispatcher dispatcher = request.getRequestDispatcher("produit-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("produit-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        produit existingProduit = produitcontrol.selectproduit(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("produit-form.jsp");
        request.setAttribute("produit", existingProduit);
        dispatcher.forward(request, response);
    }

    // insert
    private void insertproduit(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        int quantite = Integer.parseInt(request.getParameter("quantite"));
        float prix = Float.parseFloat(request.getParameter("prix"));
        String description = request.getParameter("description");
        produit newProduit = new produit(name, quantite, prix, description);
        produitcontrol.insertproduits(newProduit);
        response.sendRedirect("list");
    }

    // update
    private void updateproduit(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int quantite = Integer.parseInt(request.getParameter("quantite"));
        float prix = Float.parseFloat(request.getParameter("prix"));
        String description = request.getParameter("description");

        produit updatedProduit = new produit(id, name, quantite, prix, description);
        produitcontrol.updateproduit(updatedProduit);
        response.sendRedirect("list");
    }

    private void deleteproduit(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        produitcontrol.deleteproduit(id);
        response.sendRedirect("list");
    }
}
