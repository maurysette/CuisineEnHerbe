/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.Dao.CONNECTION;
import beans.Recette;
import java.sql.Date;
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
public class RecetteDao implements Dao<Recette> {

    private final String TABLE = "recette";
    int id;
    String title;
    String ingredient;
    String difficulty;
    int noteUp;
    int noteDown;
    Date date;
    String detail;

    public ArrayList<Recette> recette;

    @Override
    public Recette getUser() {
        Recette recette = null;
        try {
            String req = "SELECT * FROM recette";

            Statement stmt = CONNECTION.createStatement();
            ResultSet result = stmt.executeQuery(req);
            if (result.first()) {
                recette = new Recette(
                        result.getInt("id"),
                        result.getString("title"),
                        result.getString("ingredient"),
                        result.getString("difficulty"),
                        result.getInt("noteUp"),
                        result.getInt("noteDown"),
                        result.getDate("date"),
                        result.getString("detail")
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(RecetteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return recette;

    }

    @Override
    public Recette create(Recette obj) {
        try {
            String req = "INSERT INTO recette"
                    + "(title,ingredient,difficulty,noteUp,noteDown,date,detail) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement pstmt = CONNECTION.prepareStatement(req,
                    Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, obj.getTitle());
            pstmt.setString(2, obj.getIngredient());
            pstmt.setString(3, obj.getDifficulty());
            pstmt.setInt(4, obj.getNoteUp());
            pstmt.setInt(5, obj.getNoteDown());
            pstmt.setDate(6, obj.getDate());
            pstmt.setString(7, obj.getDetail());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RecetteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }

    @Override
    public void update(Recette obj) {
        try {
            String req = "UPDATE " + TABLE + " SET title = ?," + "ingredient = ?" + "difficulty = ?" + "noteUp =?" + "noteDown = ?"
                    + "date = ?" + " detail = ? WHERE id =?";
            PreparedStatement pstmt = CONNECTION.prepareStatement(req);
            pstmt.setString(1, obj.getTitle());
            pstmt.setString(2, obj.getIngredient());
            pstmt.setString(3, obj.getDifficulty());
            pstmt.setInt(4, obj.getNoteUp());
            pstmt.setInt(5, obj.getNoteDown());
            pstmt.setDate(6, obj.getDate());
            pstmt.setString(7, obj.getDetail());
            pstmt.setInt(7, obj.getId());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RecetteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Recette obj) {
        try {
            String req = "DELETE" + TABLE + " WHERE id = ?";
            PreparedStatement pstmt = CONNECTION.prepareStatement(req);
            pstmt.setInt(1, obj.getId());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RecetteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Recette> getAll() {

        recette = new ArrayList();
        try {
            String req = "SELECT * FROM recette ";
            PreparedStatement pstmt = CONNECTION.prepareStatement(req);
            ResultSet result = pstmt.executeQuery();

            while (result.next()) {
                recette.add(new Recette(result.getInt("id"), result.getString("title"), result.getString("ingredient"), result.getString("difficulty"),
                        result.getInt("noteUp"), result.getInt("noteDown"), result.getDate("date"), result.getString("detail")));

            }
        } catch (SQLException ex) {
            Logger.getLogger(RecetteDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return recette;
    }

    public Recette find(String title, Date date) {
        Recette recette = null;
        try {
            String req = "SELECT * FROM " + TABLE + " WHERE title = ?, date =?";
            PreparedStatement pstmt = CONNECTION.prepareStatement(req);
            pstmt.setString(1, title);
            pstmt.setDate(2, date);
            ResultSet result = pstmt.executeQuery();
            if (result.first()) {
                recette = new Recette(
                        id,
                        result.getString("title"),
                        result.getString("ingredient"),
                        result.getString("difficulty"),
                        result.getInt("noteUp"),
                        result.getInt("noteDown"),
                        result.getDate("date"),
                        result.getString("detail")
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(RecetteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return recette;
    }

}
