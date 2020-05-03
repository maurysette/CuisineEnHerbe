/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import beans.User;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author bst
 */
public class InscriptionCheckForm {

    /* Mes constantes */
    private static final String CHAMP_EMAIL = "registerEmail";
    private static final String CHAMP_PASS = "registerPassword";
    private static final String CHAMP_CONF = "registerConfirmation";

    /*Ma Map ou je stocke mes erreurs*/
    private final Map<String, String> errors = new HashMap();

    private String result;

    /* Mes Getters*/
    public Map<String, String> getErrors() {
        return errors;
    }

    public String getResult() {
        return result;
    }

    public User checkForm(HttpServletRequest request) {
        try {
            /*Si les serveurs sont encodé en latin il faut que l'on affiche les caractères
            spéciaux en UTF-8*/
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(InscriptionCheckForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        /* Variable = fonction getValueUser <-- voir plus bas*/
        String email = getParameterUser(request, CHAMP_EMAIL);
        String password = getParameterUser(request, CHAMP_PASS);
        String confirmation = getParameterUser(request, CHAMP_CONF);

        User user = new User();

        /* Validation de l'e-mail*/
        try {
            validationEmail(email);
        } catch (Exception e) {
            /*Si erreur, je l'ajoute dans ma map*/
            setError(CHAMP_EMAIL, e.getMessage());
        }
        user.setEmail(email);
        /* Validation du mot de passe*/
        try {
            validationMotsDePasse(password, confirmation);
        } catch (Exception e) {
            /*Si erreur, je l'ajoute dans ma map*/
            setError(CHAMP_PASS, e.getMessage());
        }
        user.setPassword(password);

        /* Initialisation du résultat global de la validation. */
        if (errors.isEmpty()) {
            result = "Succès de l'inscription.";
        } else {
            result = "Échec de l'inscription.";
        }

        return user;
    }

    /*-------- Fonction de récupération des valeurs de l'utilisateur -----------*/
    private static String getParameterUser(HttpServletRequest request, String nom) {
        String value = request.getParameter(nom);
        if (value == null || value.trim().length() == 0) {
            return null;
        } else {
            return value.trim();
        }
    }

    /*--------- Fonction qui permet d'ajouter le message d'erreur a ma Map ----------*/
    private void setError(String champ, String message) {
        errors.put(champ, message);
    }

    /*------------- Méthodes outils de validation des champs --------------- */
    /**
     * Valide l'adresse mail saisie
     */
    private void validationEmail(String email) throws Exception {
        if (email != null && email.length() != 0) {
            if (!email.matches(
                    "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
                throw new Exception("Merci de saisir une adresse mail valide.");
            }
        } else {
            throw new Exception("Merci de saisir une adresse mail.");
        }
    }

    /**
     * Valide les mots de passe saisis.
     */
    private void validationMotsDePasse(String motDePasse, String confirmation) throws Exception {
        if (motDePasse != null && motDePasse.length() != 0 && confirmation != null && confirmation.length() != 0) {
            if (!motDePasse.equals(confirmation)) {
                throw new Exception("Les mots de passe entrés sont différents, merci de les saisir à nouveau.");
            } else if (motDePasse.length() < 3) {
                throw new Exception("Les mots de passe doivent contenir aumoins 3 caractères. ");

            }
        } else {
            throw new Exception("Merci de saisir et confirmer votre mot de passe.");

        }
    }
}
