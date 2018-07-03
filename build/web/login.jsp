<%-- 
    Document   : login
    Created on : 21/05/2018, 21:50:11
    Author     : Diego Malta
--%>

<%--Caso tente acessar login pela URL e já esteja logado --%>
<%if(session.getAttribute("clienteAutenticado") != null) { %>
    <jsp:forward page="index.jsp" /> 
<%}%>

<jsp:include page="layout/header.jsp"/> 
    <%if(session.getAttribute("clienteAutenticado") != null) { %>
        <jsp:include page="layout/navbarLogado.jsp"/> 
    <%} else {%>
        <jsp:include page="layout/navbar.jsp"/> 
    <%}%>

    <div class="android-content mdl-layout__content">
        <div class="android-be-together-section">
            <div class="formulario-cadastro color-orange padding-form" style="width: 600px;">     
                <div class="mdl-grid center-items" style="padding-right: 80px;">
                    <div class="logo-font GoBystrok-title GoBystrok-slogan" style="padding-left: 50px;">Login</div>
                    
                    <form method="POST" action="Login" name="loginForm" onsubmit="return verificarCamposLogin()">
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label col-tam2 ">
                            <input class="mdl-textfield__input color-white" 
                                   type="text" 
                                   minlength="14" 
                                   maxlength="14" 
                                   name="CPF" 
                                   onkeydown="javascript: fMasc(this, mCPF);"
                                   id="sample3">
                            
                            <label class="mdl-textfield__label mdl-color-text--orange-50" for="sample3">CPF</label>
                            <span class="mdl-textfield__error color-white">CPF inválido preencha corretamente.</span>
                            
                        </div>
                        
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label col-tam2 ">
                            <input class="mdl-textfield__input color-white" 
                                   type="password" 
                                   name="Senha" 
                                   minlength="8" 
                                   maxlength="16" 
                                   id="sample4">
                            <label class="mdl-textfield__label mdl-color-text--orange-50" for="sample3">Senha</label>
                        </div>

                        <div class="" style="padding-left: 80px;">
                            <button class="mdl-button mdl-js-button mdl-button--raised mdl-color--accent mdl-color-text--accent-contrast mdl-js-ripple-effect margin-top" 
                                    type="submit" 
                                    name="entrar"
                                    value="Entrar">Entrar</button>
                            <button class="mdl-button mdl-js-button mdl-button--raised mdl-color--accent mdl-color-text--accent-contrast mdl-js-ripple-effect margin-top" 
                                    type="submit" 
                                    name="recuperar"
                                    value="Recuperar">Esqueci minha senha</button>
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