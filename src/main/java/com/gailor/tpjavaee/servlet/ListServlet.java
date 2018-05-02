/*
 * The MIT License
 *
 * Copyright 2018 gpetemoy.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.gailor.tpjavaee.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gpetemoy
 */
@WebServlet(name = "ListServlet", urlPatterns = {"/list"})
public class ListServlet extends HttpServlet {

    private final HashMap<String, String> names = new HashMap();
    private final HashMap<String, StringBuilder> list = new HashMap();
    
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
        response.sendRedirect(request.getContextPath() + "/introduce");
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
        
        // On attrape les paramètres de session.
        String name = request.getParameter("name");
        StringBuilder requestList = new StringBuilder(request.getParameter("list"));
        
         // Si  nous avons affaire à la requête d'entrée, on set l'attribut "name".
        if(name != null){
            request.getSession().setAttribute("name", name);
        } else {
            name = request.getSession().getAttribute("name").toString();
        }
        
        // On ajoute l'utilisateur à notre liste
        this.names.put(name, "");
        // On manipule notre liste de StringBuilder
        if(this.list.containsKey(name)){
            // Soit l'objet existe déjà et on ajoute à la liste préexistante.
            StringBuilder newElement = requestList.insert(0, "<li>").append("</li>");
            this.list.put(name, this.list.get(name).append(newElement));
        } else {
            // Sinon on crée l'objet avec la nouvelle chaîne de caractère.
            this.list.put(name, requestList.insert(0, "<li>").append("</li>"));
        }

        // On set l'attribut "list" selon l'utilisateur en cours.
        request.getSession().setAttribute( "list", this.list.get(name) );
        
        request.getRequestDispatcher("home.jsp").forward(request, response);
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
