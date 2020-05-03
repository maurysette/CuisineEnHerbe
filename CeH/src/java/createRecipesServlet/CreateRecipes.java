/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package createRecipesServlet;

import DAO.DAOFactory;
import DAO.RecetteDao;
import beans.Recette;
import forms.createRecipeCheckForm;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author stag
 */
public class CreateRecipes extends HttpServlet {

    private static final String VIEW = "/WEB-INF/template/createRecipesContent/createRecipes.jsp";
    private static final String ATT_RECETTE = "nRecette";
    private static final String ATT_FORM = "nForm";

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Affichage de la page de connexion */
        this.getServletContext().getRequestDispatcher(VIEW).forward(request,
                response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            createRecipeCheckForm form = new createRecipeCheckForm();
            Recette rec = form.checkForm(request);

            RecetteDao userdao = DAOFactory.getRecetteDAO();

            Recette recs = userdao.create(rec);

            request.setAttribute(ATT_FORM, form);
            request.setAttribute(ATT_RECETTE, rec);

            this.getServletContext().getRequestDispatcher(VIEW).forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(CreateRecipes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
