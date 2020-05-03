/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import beans.Admin;
import beans.Comment;
import beans.Recette;

/**
 *
 * @author stag
 */
public class DAOFactory {

    public static Dao<Admin> getAdminDAO() {
        return new AdminDao();
    }

    public static UserDao getUserDAO() {
        return new UserDao();
    }

    public static RecetteDao getRecetteDAO() {
        return new RecetteDao();
    }

    public static Dao<Comment> getCommentDAO() {
        return new CommentDao();
    }
}
