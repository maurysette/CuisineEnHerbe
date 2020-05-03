/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import beans.User;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author bst
 */
public class ConnexionCheckForm {

    private static final String CHAMP_EMAIL = "connectionEmail";
    private static final String CHAMP_PASS = "connectionPassword";
    private String result;
    private final Map<String, String> errors = new HashMap<>();

    public String getResult() {
        return result;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public User checkForm(HttpServletRequest request) {
        /* Récupération des champs du formulaire */
        String email = getValeurChamp(request, CHAMP_EMAIL);
        String password = getValeurChamp(request, CHAMP_PASS);
        User user = new User();
        /* Validation du champ email. */
        try {
            validationEmail(email);
        } catch (Exception e) {
            setError(CHAMP_EMAIL, e.getMessage());
        }
        user.setEmail(email);
        /* Validation du champ mot de passe. */
        try {
            validationMotDePasse(password);
        } catch (Exception e) {
            setError(CHAMP_PASS, e.getMessage());
        }
        user.setPassword(password);
        /* Initialisation du résultat global de la validation. */
        if (errors.isEmpty()) {
            result = "Succès de la connexion.";
        } else {
            result = "Échec de la connexion.";
        }
        return user;
    }

    /**
     * Valide l'adresse email saisie.
     */
    private void validationEmail(String email) throws Exception {
        if (email == null) {
            throw new Exception("Merci de saisir une adresse mail.");
        } else if (!email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)"
        )) {
            throw new Exception("Merci de saisir une adresse mail valide.");
        }
    }

    /**
     * Valide le mot de passe saisi.
     */
    private void validationMotDePasse(String motDePasse) throws Exception {
        if (motDePasse != null) {
            if (motDePasse.length() < 3) {
                throw new Exception("Le mot de passe doit contenir au moins 3 caractères.");

            }
        } else {
            throw new Exception("Merci de saisir votre mot de passe.");
        }
    }

    /*
 * Ajoute un message correspondant au champ spécifié à la map des
erreurs.
     */
    private void setError(String champ, String message) {
        errors.put(champ, message);
    }

    /*
 * Méthode utilitaire qui retourne null si un champ est vide, et son
contenu
 * sinon.
     */
    private static String getValeurChamp(HttpServletRequest request, String nom) {
        String valeur = request.getParameter(nom);
        if (valeur == null || valeur.trim().length() == 0) {
            return null;
        } else {
            return valeur;
        }
    }
}
