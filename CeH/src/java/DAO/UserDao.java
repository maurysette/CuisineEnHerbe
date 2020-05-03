/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author stag
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import beans.User;
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
public class UserDao implements Dao<User> {

    private final String TABLE = "user";

    int id;
    String email, password;
    public ArrayList<User> user;

    @Override
    public User getUser() {
        User user = null;
        try {
            String req = "SELECT * FROM" + TABLE;

            Statement stmt = CONNECTION.createStatement();
            ResultSet result = stmt.executeQuery(req);
            if (result.first()) {
                user = new User(
                        result.getInt("id"),
                        result.getString("email"),
                        result.getString("password")
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;

    }

    @Override
    public User create(User obj) {
        try {
            String req = "INSERT INTO " + TABLE
                    + "(email,password)VALUES(?,?)";
            PreparedStatement pstmt = CONNECTION.prepareStatement(req,
                    Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, obj.getEmail());
            pstmt.setString(2, obj.getPassword());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }

    @Override
    public void update(User obj) {
        try {
            String req = "UPDATE " + TABLE + " SET email = ?,"
                    + " password = ? WHERE id =?";
            PreparedStatement pstmt = CONNECTION.prepareStatement(req);
            pstmt.setString(1, obj.getEmail());
            pstmt.setString(2, obj.getPassword());
            pstmt.setInt(3, obj.getId());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public User find(String email) {
        User user = null;
        try {
            String req = "SELECT * FROM " + TABLE + " WHERE email = ?";
            PreparedStatement pstmt = CONNECTION.prepareStatement(req);
            pstmt.setString(1, email);
            ResultSet result = pstmt.executeQuery();
            if (result.first()) {
                user = new User(
                        id,
                        result.getString("email"),
                        result.getString("password")
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    public ArrayList<User> getAll() {

        user = new ArrayList();
        try {
            String req = "SELECT * FROM" + TABLE;
            PreparedStatement pstmt = CONNECTION.prepareStatement(req);
            ResultSet result = pstmt.executeQuery();

            while (result.next()) {
                user.add(new User(result.getInt("id"), result.getString("email"), result.getString("password")));

            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return user;
    }

    @Override
    public void delete(User obj) {
        try {
            String req = "DELETE" + TABLE + " WHERE id = ?";
            PreparedStatement pstmt = CONNECTION.prepareStatement(req);
            pstmt.setInt(1, obj.getId());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
