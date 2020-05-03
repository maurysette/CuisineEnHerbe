<%-- 
    Document   : adminContent
    Created on : 22 avr. 2020, 17:56:33
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
        <h1 id="titreAdmin">Panneau Administrateur</h1>
        <div id="globalAdmin">

            <div id="recipeAdmin">
                <h3>Recette</h3>
                <input type=text list=browsers >
                <datalist class="browsers" >
                    <option> blblbl
                    <option> fioufiou
                </datalist>
                <div class="buttonAdmin" >
                    <button>visualiser</button>
                    <button>conserver</button>
                    <button>supprimer</button>
                </div>
            </div>
            <div id="registeredAdmin">
                <h3>Inscrit</h3>
                <input type=text list=browsers >
                <datalist class="browsers" >
                    <option> blblbl
                    <option> fioufiou
                </datalist>
                <div class="buttonAdmin" >
                    <button>réactiver</button>
                    <button>désactiver</button>
                    <button>supprimer</button>
                </div>
            </div>
            <div class="commentAdmin">
                <h3>Commentaire signaler</h3>
                <input type=text list=browsers >
                <datalist class="browsers" >
                    <option> blblbl
                    <option> fioufiou
                </datalist>
                <div class="buttonAdmin" >
                    <button>visualiser</button>
                    <button>conserver</button>
                    <button>supprimer</button>
                </div>
            </div>
        </div>

    </body>
</html>
