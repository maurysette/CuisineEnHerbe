/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.Dao.CONNECTION;
import beans.Admin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author stag
 */
public class AdminDao implements Dao<Admin> {

    private final String TABLE = "admin";
    String email;
    String password;

    public Admin getAdmin() throws SQLException {
        Admin admin = null;
        try {

            String req = "SELECT * FROM admin";
            Statement stmt = CONNECTION.createStatement();
            ResultSet result = stmt.executeQuery(req);
            if (result.first()) {
                admin = new Admin(
                        result.getString("email"),
                        result.getString("password")
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return admin;
    }

    @Override
    public void update(Admin obj) {
        try {
            String req = "UPDATE " + TABLE + " SET password = ? WHERE email=?";
            PreparedStatement pstmt = CONNECTION.prepareStatement(req);
        } catch (SQLException ex) {
            Logger.getLogger(AdminDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Admin create(Admin obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Admin obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Admin getUser() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
