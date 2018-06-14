<%-- 
    Document   : signin
    Created on : 21/05/2018, 22:01:56
    Author     : Diego Malta
--%>

<jsp:include page="layout/header.jsp"/>    
    <jsp:include page="layout/navbar.jsp"/>
    <div class="android-content mdl-layout__content">
    <div class="android-be-together-section">
      <div class="formulario-cadastro color-orange"> 
        <div class="mdl-grid center-items color-orange">
            <% String men = (String)request.getAttribute("Mensagem");%>
            <% if(men != null){%>
                <script>alert("<%=men%>");</script>
            <%}%>
            <div class="logo-font GoBystrok-title GoBystrok-slogan">Cadastrar-se</div>
            <form action="cadastrarCliente" method="POST" name="cadastroForm" class="" onsubmit="return verificarCamposCadastro()">

                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label col-tam">
                    <h2 class="mdl-card__title-text color-white">Dados Pessoais</h2>
                </div>
                <tavl
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label col-tam ">
                    <input class="mdl-textfield__input color-white" type="text" name="Nome" maxlength="50" id="sample3">
                    <label class="mdl-textfield__label mdl-color-text--orange-50" for="sample3">Nome</label>
                </div>

                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label col-tam ">
                    <input class="mdl-textfield__input color-white" type="text" name="CPF" maxlength="11" pattern = "-?[0-9]*(\.[0-9]+)?" id="sample3">
                    <label class="mdl-textfield__label mdl-color-text--orange-50" for="sample3">CPF</label>
                    <span class="mdl-textfield__error color-white">Use somente números</span>
                </div>

                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label col-tam ">
                    <input class="mdl-textfield__input color-white" type="password" name="Senha" 
                        minlength="8" maxlength="16" id="sample4">
                    <label class="mdl-textfield__label mdl-color-text--orange-50" for="sample3">Senha</label>
                </div>

                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label col-tam ">
                    <input class="mdl-textfield__input color-white" type="email" name="Email" id="sample3">
                    <label class="mdl-textfield__label mdl-color-text--orange-50" for="sample3">Email</label>
                    <span class="mdl-textfield__error color-white">Formato de email inválido</span>
                </div>
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label col-tam ">
                    <input class="mdl-textfield__input color-white" type="text" name="Telefone" 
                           pattern = "-?[0-9]*(\.[0-9]+)?" minlength="9" maxlength="15" id="sample3">
                    <label class="mdl-textfield__label mdl-color-text--orange-50" for="sample3">Telefone</label>
                    <span class="mdl-textfield__error color-white">Use somente números</span>
                </div>

                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label col-tam">
                    <h2 class="mdl-card__title-text color-white">Endereço</h2>
                </div>

                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label col-tam ">
                    <input class="mdl-textfield__input color-white" type="text" name="Rua" id="sample5">     
                    <label class="mdl-textfield__label mdl-color-text--orange-50" for="sample5">Rua</label>
                </div>  

                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label col-tam ">
                    <input class="mdl-textfield__input color-white" type="text" name="Bairro" id="sample3">
                    <label class="mdl-textfield__label mdl-color-text--orange-50" for="sample3">Bairro</label>
                </div>  

                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label col-tam ">
                    <input class="mdl-textfield__input color-white" type="text" name="Cidade" id="sample5">     
                    <label class="mdl-textfield__label mdl-color-text--orange-50" for="sample5">Cidade</label>
                    <ul for="sample5" class="mdl-menu mdl-menu--bottom-left mdl-js-menu">
                        <li class="mdl-menu__item" data-val="BA">Salvador</li>
                        <li class="mdl-menu__item" data-val="SP">São Paulo</li>
                        <li class="mdl-menu__item" data-val="RS">Porto Alegre</li>
                    </ul>
                </div>

                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label col-tam ">
                    <input class="mdl-textfield__input color-white" name="Estado" type="text" minlength=8 
                           maxlength="8" id="sample6">      
                    <label class="mdl-textfield__label mdl-color-text--orange-50" for="sample6">Estado</label>
                    <ul for="sample6" class="mdl-menu mdl-menu--bottom-left mdl-js-menu">
                        <li class="mdl-menu__item" data-val="BA">Bahia</li>
                        <li class="mdl-menu__item" data-val="SP">Sao Paulo</li>
                        <li class="mdl-menu__item" data-val="RS">Porto Alegre</li>
                    </ul>
                </div>

                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label col-tam ">
                    <input class="mdl-textfield__input color-white" type="text" name="CEP" pattern = "-?[0-9]*(\.[0-9]+)?" id="sample3">
                    <label class="mdl-textfield__label mdl-color-text--orange-50" for="sample3">CEP</label>
                    <span class="mdl-textfield__error color-white">Use somente números</span>
                </div>

                <div class="toolbar-section">
                    <button class="mdl-button mdl-js-button mdl-button--raised mdl-color--accent mdl-color-text--accent-contrast mdl-js-ripple-effect margin-top" type="submit" name="submit">Cadastrar</button>
                </div>
            </form>
        </div>
      </div>
    </div>   
    <div class="android-screen-section mdl-typography--text-center GoBystrok-spacer"></div>
    <div class="android-screen-section mdl-typography--text-center GoBystrok-spacer"></div>
    <div class="mdl-grid center-items color-orange"></div>
<jsp:include page="layout/footer.jsp"/> 