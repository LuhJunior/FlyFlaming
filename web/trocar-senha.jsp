<%-- 
    Document   : trocar-senha
    Created on : 21/05/2018, 22:03:46
    Author     : Diego Malta
--%>
<jsp:include page="autenticarPagina.jsp"/>
<jsp:include page="layout/header.jsp"/>    
    <jsp:include page="layout/navbarLogado.jsp"/>
    <div class="android-content mdl-layout__content">
        <div style="height: 800px;" class="android-be-together-sectionA">
            <div class="formulario-cadastro color-orange padding-form">     
                <div class="mdl-grid center-items color-orange">
                        <div class="logo-font GoBystrok-title GoBystrok-slogan">Troca de Senha</div>
                        <form action="NovaSenha" method="POST" name="trocarSenhaForm" onsubmit="return verificarCamposTrocarSenha()">
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label col-tam2 ">
                                <input class="mdl-textfield__input color-white" type="password" name="Senha" minlength="8" maxlength="16" id="sample3">
                                <label class="mdl-textfield__label mdl-color-text--orange-50" for="sample3">Senha Atual</label>
                            </div>
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label col-tam2 ">
                                <input class="mdl-textfield__input color-white" type="password" name="NovaSenha" minlength="8" maxlength="16" id="sample3">
                                <label class="mdl-textfield__label mdl-color-text--orange-50" for="sample3">Nova Senha</label>
                            </div>
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label col-tam2 ">
                                <input class="mdl-textfield__input color-white" type="password" name="RepetirNovaSenha" minlength="8" maxlength="16" id="sample3">
                                <label class="mdl-textfield__label mdl-color-text--orange-50" for="sample3">Confirmar Senha</label>
                            </div>
                            <div style="margin-left: 40%" class="toolbar-section">
                                <button class="mdl-button mdl-js-button mdl-button--raised mdl-color--accent mdl-color-text--accent-contrast mdl-js-ripple-effect margin-top" type="submit" name="submit">Confirmar</button>
                            </div>
                        </form>
                </div>
            </div>
        </div>      
<jsp:include page="layout/footer.jsp"/> 
<% String Mensagem = (String) request.getAttribute("Mensagem");
    String Erro = (String) request.getAttribute("Erro");
    if(Mensagem != null){%>
    <script>ShowMensagemSucesso("<%=Mensagem%>");</script>
<%}
    if(Erro != null){%>
    <script>ShowMensagemErro("<%=Erro%>");</script>
<%}%>