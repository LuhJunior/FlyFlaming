<%-- 
    Document   : login
    Created on : 21/05/2018, 21:50:11
    Author     : Diego Malta
--%>

<jsp:include page="layout/header.jsp"/>    
    <jsp:include page="layout/navbar.jsp"/>
    <div class="android-content mdl-layout__content">
        <div class="android-be-together-section">
            <div class="formulario color-orange padding-form">     
                <div class="mdl-grid center-items color-orange">
                    <div class="logo-font GoBystrok-title GoBystrok-slogan">Login</div>
                    <form method="POST" name="loginForm" onsubmit="return verificarCamposLogin()">
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label col-tam ">
                            <input class="mdl-textfield__input color-white" type="text" minlength="11" maxlength="11" name="CPF" pattern = "-?[0-9]*(\.[0-9]+)?" id="sample3">
                            <label class="mdl-textfield__label mdl-color-text--orange-50" for="sample3">CPF</label>
                            <span class="mdl-textfield__error color-white">CPF inválido preencha corretamente.</span>
                        </div>
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label col-tam ">
                            <input class="mdl-textfield__input color-white" type="password" name="Senha" minlength="8" maxlength="16" id="sample3">
                            <label class="mdl-textfield__label mdl-color-text--orange-50" for="sample3">Senha</label>
                        </div>

                        <div class="toolbar-section">
                            <button class="mdl-button mdl-js-button mdl-button--raised mdl-color--accent mdl-color-text--accent-contrast mdl-js-ripple-effect margin-top" type="submit" name="submit">Entrar</button>
                            <button class="mdl-button mdl-js-button mdl-button--raised mdl-color--accent mdl-color-text--accent-contrast mdl-js-ripple-effect margin-top" type="submit" name="submit">Esqueci minha senha</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="mdl-grid center-items color-orange"></div>                
<jsp:include page="layout/footer.jsp"/>  