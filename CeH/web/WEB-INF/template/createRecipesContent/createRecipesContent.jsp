<%-- 
    Document   : createRecipesContent
    Created on : 23 avr. 2020, 08:56:58
    Author     : stag
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

    </head>
    <body>
        <h1>Création d'une recette</h1>
        <form method="post"  name="createRecipe" enctype="multipart/form-data">
            <div id="globalCreateRecipes">
                <div id="difficultCreateRecipes">
                    <h4>Difficulté  <span class="requis">*</span></h4>
                    <input type="radio" name="difficultRecipes" id="difficult" size ="1"  value="facile" checked>
                    <label for="facile">facile</label>
                    <input type="radio" name="difficultRecipes" id="difficult" size ="1" value="moyen" >
                    <label for = "moyen">moyen </label>
                    <input type="radio" name="difficultRecipes" id="difficult" size ="1" value="difficile" >
                    <label for="difficile" >difficile</label>
                </div>
                <div id="listCreateRecipes">
                    <h4>Liste des ingrédients  <span class="requis">*</span></h4>
                    <input type="text" name="descriptIngredient" id="descript" required>

                </div>
                <div id="imgCreateRecipes">
                    <h4>Photo</h4>
                    <input type="file" id="avatar" name="avatar"
                           accept="image/png, image/jpeg">

                </div>
                <div id="descriptCreateRecipes">
                    <h4>Descriptif  <span class="requis">*</span></h4>
                    <input type="text" name="descriptRecipes" id="descript" required>

                </div>
                <div class='buttonCreateRecipes' >
                    <input type="submit" value="soumettre">
                </div>
            </div>
        </form>
    </body>
</html>
