/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import connexionCEH.SQLConnexion;

/**
 *
 * @author stag
 */
public interface Dao<Q> {

    Connection CONNECTION = SQLConnexion.getInstance();

    public abstract Q getUser();

    public abstract Q create(Q obj);

    public abstract void update(Q obj);

    public abstract void delete(Q obj);

}
