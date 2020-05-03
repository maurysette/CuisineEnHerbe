<%-- 
    Document   : header
    Created on : 22 avr. 2020, 09:45:41
    Author     : bst
--%>

<div id="container-header">
    <h1 id="mainTitle">Cuisine en Herbe</h1>
    <div id="register-header">
        <form class="connection-register" action="accueil" method="POST">
            <label for="email">
                E-mail : 
                <input type="text" name="connectionEmail" id="email">
            </label>
            <span>${nForm.errors['connectionEmail']}</span>
            <label for="password">
                Mot de passe : 
                <input type="password" name="connectionPassword" id="password">
                <span>${nForm.errors['connectionPassword']}</span>
            </label>
            <div id="formButton">
                <input class="submit" type="submit" value="Connexion">
            </div>
        </form>
        <a class="createAccount" href="http://localhost:8084/CuisineEnHerbe/inscription">Créer un compte</a>
    </div>
</div>

<nav>
    <ul >
        <li class="nav"><a class="links" href="http://localhost:8084/CuisineEnHerbe/accueil">- Accueil</a></li>
        <li class="nav"><a class="links" href="http://localhost:8084/CuisineEnHerbe/NosRecettes">- Recettes</a></li>

    </ul>
</nav>
