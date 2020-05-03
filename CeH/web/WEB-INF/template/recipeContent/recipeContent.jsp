<%-- 
    Document   : recipeContent
    Created on : 22 avr. 2020, 17:55:46
    Author     : bst
--%>
<div id="container-top-recipe">
    <img src="https://res.cloudinary.com/bdf/image/upload/c_fill,h_370,w_440/v1422979850/bdf/images/ecrire-une-recette-de-cuisine.jpg" alt="image recette">
    <div id="container-info">
        <div id="main-recipeTitle">
            <h2 id="recipe-Title">Nom de la recette</h2>
            <div id="container-difficulty">
                <p class="difficulty">Difficulté</p>
                <p class="difficulty">les étoiles</p>
            </div>
        </div>
        <div id="infosRecipe">
            <div id="note">
                <input type="image" src="./rsc/image/pouceVert.png">
                <input type="image" src="./rsc/image/pouceRouge.png">
                <div id="number-note">
                    <p>Nbr Up</p>
                    <p>NbrDown</p>
                </div>
            </div>
            <div>
                <p>Ingrédients</p>
                <p>Affichage des ingrédients</p>
            </div>
        </div>
    </div>
</div>
<div id="container-bottom-recipe">
    <div id="container-comments-recipe">
        <form action="">
            <label for="comment">
                Commentaire
                <input type="text" name="comment" id="comment-recipe">
            </label>
            <input type="submit" name="submit-comment" id="submit-comment" value="Valider">
        </form>
        <div id="comments-block">
            <div>
                <p>Les commentaire seront la <span><a href="#">Signaler</a></span></p>
            </div>
        </div>
    </div>
    <div id="preparation-recipe">
        <p>Préparation</p>
        <p>Il y aura la marche a suivre ici</p>
    </div>
</div>