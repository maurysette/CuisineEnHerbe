/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import beans.Comment;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author stag
 */
public class CommentDao implements Dao<Comment> {

    private final String TABLE = "comment";
    int id;
    String comment;

    public ArrayList<Comment> listComment;

    @Override
    public Comment getUser() {
        Comment comments = null;
        try {

            String req = "SELECT * FROM comment";
            Statement stmt = CONNECTION.createStatement();
            ResultSet result = stmt.executeQuery(req);
            if (result.first()) {
                comments = new Comment(
                        result.getInt("id"),
                        result.getString("comment")
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return comments;
    }

    @Override
    public Comment create(Comment obj) {
        try {
            String req = "INSERT INTO" + TABLE + "(comment) VALUES(?)";
            PreparedStatement pstmt = CONNECTION.prepareStatement(req);
            pstmt.setString(1, obj.getComment());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CommentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }

    @Override
    public void update(Comment obj) {
        try {
            String req = "UPDATE" + TABLE + "SET comment = ? WHERE id = ?";
            PreparedStatement pstmt = CONNECTION.prepareStatement(req);
            pstmt.setString(1, obj.getComment());
        } catch (SQLException ex) {
            Logger.getLogger(CommentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Comment obj) {
        try {
            String req = "DELETE" + TABLE + "WHERE id = ?";
            PreparedStatement pstmt = CONNECTION.prepareStatement(req);
            pstmt.setInt(1, obj.getId());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CommentDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<Comment> getAll() {

        try {
            listComment = new ArrayList();

            String req = "SELECT * FROM comment";
            PreparedStatement pstmt = CONNECTION.prepareStatement(req);
            ResultSet result = pstmt.executeQuery();

            while (result.next()) {
                listComment.add(new Comment(result.getInt("id"), result.getString("comment")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(CommentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listComment;
    }

    public Comment find(int id) {
        Comment comments = null;
        try {

            String req = "SELECT * FROM " + TABLE + "WHERE id = ?";
            PreparedStatement pstmt = CONNECTION.prepareStatement(req);
            pstmt.setInt(1, id);
            ResultSet result = pstmt.executeQuery();
            if (result.first()) {
                comments = new Comment(
                        id,
                        result.getString("comment"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return comments;
    }

}
