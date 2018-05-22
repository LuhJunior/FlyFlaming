<%-- 
    Document   : esqueci-senha-trocar
    Created on : 21/05/2018, 22:08:14
    Author     : Diego Malta
--%>

<jsp:include page="layout/header.jsp"/>    
    <jsp:include page="layout/navbar.jsp"/>
    <div class="android-content mdl-layout__content">
        <div class="android-be-together-section">
            <div class="formulario color-orange padding-form">     
                <div class="mdl-grid center-items color-orange">
                    <div class="logo-font GoBystrok-title GoBystrok-slogan">Troca de Senha</div>
                    <form method="POST" name="loginForm" onsubmit="return verificarCampos()">
                        <div class="mdl-js-textfield color-white col-tam">
                            --CPF AQUI--
                        </div>
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label col-tam ">
                            <input class="mdl-textfield__input color-white" type="password" name="Senha" minlength="8" maxlength="16" id="sample3">
                            <label class="mdl-textfield__label mdl-color-text--orange-50" for="sample3">Nova Senha</label>
                        </div>
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label col-tam ">
                            <input class="mdl-textfield__input color-white" type="password" name="Senha" minlength="8" maxlength="16" id="sample3">
                            <label class="mdl-textfield__label mdl-color-text--orange-50" for="sample3">Confirmar Senha</label>
                        </div>
                        <div class="toolbar-section">
                            <button class="mdl-button mdl-js-button mdl-button--raised mdl-color--accent mdl-color-text--accent-contrast mdl-js-ripple-effect margin-top" type="submit" name="submit">Confirmar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="mdl-grid center-items color-orange"></div>
<jsp:include page="layout/footer.jsp"/> 