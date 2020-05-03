/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connexionCEH;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author stag
 */
public final class SQLConnexion {
    // MES ATTRIBUTS

    private final static String HOST = ""; // L'ip de l'hôte
    private final static String PORT = ""; // Le PORT de connexion, 3306 par défaut sur MySQL
    private final static String BASE = ""; // La BASE de données sur laquelle se connecter
    private final static String LOGIN = ""; // Le LOGIN
    private final static String PASSWORD = ""; // Le mot de passe
    private static Connection connection = null;
    private final static String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + BASE;

    // mon constructeur doit etre private
    private SQLConnexion() {
    }

    // je cree ma methode statique final pour me connecter
    public static final Connection getInstance() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
                System.out.println("vous etes connecter a la base de donnée");

            } catch (SQLException ex) {
                Logger.getLogger(SQLConnexion.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SQLConnexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return connection;

    }
    // ont creé une Méthode properties qui va nous retourner notre instance connection et la créer si elle n'existe pas

    public static Connection getInstanceWithProperties(String propertiesFileName) {
        // Crée un objet properties pour récupérer les données
        Properties sqlConfig = new Properties();

        try (InputStream in = SQLConnexion.class
                .getResourceAsStream("/ressources/" + propertiesFileName);) {
            sqlConfig.load(in);
        } catch (IOException ex) {
            System.out.println("Fichier property " + propertiesFileName + " n'a pas pu être lu");
            System.exit(1);
        }

        if (connection == null) {
            try {
                String url = "jdbc:" + sqlConfig.getProperty("sgbdr") + "://"
                        + sqlConfig.getProperty("host") + ":"
                        + sqlConfig.getProperty("port") + "/"
                        + sqlConfig.getProperty("database");
                System.out.println("url = " + url);
                connection = DriverManager.getConnection(url, sqlConfig);
            } catch (SQLException ex) {
                System.out.println("Connection à la DB impossible");
                Logger.getLogger(SQLConnexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        System.out.println("connecté");

        return connection;
    }
}
