/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import beans.Recette;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

/**
 *
 * @author stag
 */
public class createRecipeCheckForm {

    /* Nos constantes  pour recette */
    private static final String CHAMP_DIFFICULT = "descriptDifficult";
    private static final String CHAMP_INGREDIENT = "descriptIngredient";
    private static final String CHAMP_FICHIER = "fichier";
    private static final String CHAMP_DESCRIPT = "descriptRecipes";
    private String result;
    private Map<String, String> errors = new HashMap<>();

    public String getResultat() {
        return result;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public Recette checkForm(HttpServletRequest request) throws Exception {
        // String difficult = getValeurChamp(request, CHAMP_DIFFICULT);
        String ingredient = getValeurChamp(request, CHAMP_INGREDIENT);
        String descript = getValeurChamp(request, CHAMP_DESCRIPT);
        Recette recette = new Recette();
        // test upload img
        // getPart permet de récuperer le fichier
        Part part = request.getPart(CHAMP_FICHIER);
        String nomFichier = getNomFichier(part);
        try {
            validationIngredient(ingredient);
        } catch (Exception e) {
            setError(CHAMP_INGREDIENT, e.getMessage());
        }
        recette.setIngredient(ingredient);
        try {
            validationDescript(descript);
        } catch (Exception e) {
            setError(CHAMP_DESCRIPT, e.getMessage());
        }
        recette.setDetail(descript);
        //recette.setDifficulty(difficult);
        if (errors.isEmpty()) {
            result = "Succès de l'enregistrement.";
        } else {
            result = "Échec de l'enregistrement.";
        }
        return recette;
    }

    private void validationIngredient(String ingredient) throws Exception {
        if (ingredient != null && ingredient.length() < 3) {
            throw new Exception("Le nom d'utilisateur doit contenir au moins 3 caractères.");
        } else {
            throw new Exception("Merci de remplir le champ.");
        }
    }

    private void validationDescript(String detail) throws Exception {
        if (detail != null && detail.length() < 3) {
            throw new Exception("Le nom d'utilisateur doit contenir au moins 3 caractères.");

        } else {
            throw new Exception("Merci de remplir le champ.");
        }
    }

    private void setError(String champ, String message) {
        errors.put(champ, message);
    }

    private static String getValeurChamp(HttpServletRequest request, String nomChamp) {
        String valeur = request.getParameter(nomChamp);
        if (valeur == null || valeur.trim().length() == 0) {
            return null;
        } else {
            return valeur.trim();
        }
    }

    private String getNomFichier(Part part) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
