/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listOfRecipesServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bst
 */
public class ListOfRecipes extends HttpServlet {

    private static final String VIEW = "/WEB-INF/template/listOfRecipesContent/listOfRecipes.jsp";

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Affichage de la page de connexion */
        this.getServletContext().getRequestDispatcher(VIEW).forward(request,
                response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {

    }
}
