package com.gailor.tpjavaee.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gpetemoy
 */
@WebServlet(name = "HomeServlet", urlPatterns = {"/home"})
public class HomeServlet extends HttpServlet {

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
        // En cas de requête GET, nous affichons la page "introduction.jsp".        
        response.sendRedirect(request.getContextPath() + "/home.jsp");
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
        // On attrape le paramètre "name" du formulaire après une requête POST
        // s'il n'est pas vide, sinon on retourne notre page d'accueil.
        if (!request.getParameter("name").isEmpty()) {

            request.getSession().setAttribute("name", request.getParameter("name"));

            // On transfère le traitement vers la page "home.jsp".
            request.getRequestDispatcher("todolist.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/home");
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
    }// </editor-fold>

}
