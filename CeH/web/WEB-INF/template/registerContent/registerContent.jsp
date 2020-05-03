<%-- 
    Document   : registerContent
    Created on : 23 avr. 2020, 16:44:50
    Author     : bst
--%>
<div class="register-container">
    <h2 class="register-title">Inscription</h2>

    <form class="register-form" action="inscription" method="POST">
        <label for="email-register">
            Adresse-mail
            <input type="text" name="registerEmail" id="email-register">
            <span>${ nForm.errors['registerEmail'] }</span>
        </label>

        <label for="password-register">
            Mot de passe
            <input type="password" name="registerPassword" id="password-register">
            <span>${ nForm.errors['registerPassword'] }</span>
        </label>
        <label for="confirm-password-register">
            Confirmation du mot de passe
            <input type="password" name="registerConfirmation" id="confirm-password-register">
        </label>
        <input type="submit" name="register-button" id="register-button" value="Inscription">
        <p>${nForm.result}</p>
    </form>

</div>