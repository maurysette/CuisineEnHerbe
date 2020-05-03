/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registerServlet;

import DAO.DAOFactory;
import DAO.UserDao;
import beans.User;
import forms.InscriptionCheckForm;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bst
 */
public class Register extends HttpServlet {

    private static final String VIEW = "/WEB-INF/template/registerContent/register.jsp";
    private static final String ATT_USER = "nUser";
    private static final String ATT_FORM = "nForm";

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* Affichage de la page de connexion */
        this.getServletContext().getRequestDispatcher(VIEW).forward(request,
                response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InscriptionCheckForm form = new InscriptionCheckForm();
        User user = form.checkForm(request);

        UserDao userdao = DAOFactory.getUserDAO();

        User users = userdao.create(user);

        request.setAttribute(ATT_FORM, form);
        request.setAttribute(ATT_USER, user);

        this.getServletContext().getRequestDispatcher(VIEW).forward(request, response);
    }

}
