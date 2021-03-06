<%-- 
    Document   : updateCliente
    Created on : 10/06/2018, 22:13:27
    Author     : J�nior
--%>


<jsp:include page="autenticarPagina.jsp"/>
<jsp:include page="layout/header.jsp"/>    
    <jsp:include page="layout/navbarLogado.jsp"/>
    <div class="android-content mdl-layout__content">
        <div class="android-be-together-section" style="height: 1200px;">
      <div class="formulario-cadastro color-orange" style="height: 920px;"> 
        <div class="mdl-grid center-items ">
            <% Modelo.Cliente c = (Modelo.Cliente)request.getAttribute("cliente");
                        if(c == null) {
                            c = new Modelo.Cliente();
                        }
                        if(c.getTelefone() == null) c.setTelefone("");
                        if(c.getEndereco() == null) c.setEndereco(new Modelo.Endereco());
                    %>
            <div class="logo-font GoBystrok-title GoBystrok-slogan">Alterar Dados do Cliente</div>
            
            <form action="UpdateDadosCliente" method="POST" name="updateForm" class="" onsubmit="return verificarCamposCadastro()">
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label col-tam">
                    <h2 class="mdl-card__title-text color-white">Dados Pessoais</h2>
                </div>

                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label col-tam ">
                    <input class="mdl-textfield__input color-white" type="text" name="Nome" maxlength="50" id="sample3" value="<%=c.getNome()%>">
                    <label class="mdl-textfield__label mdl-color-text--orange-50" for="sample3">Nome</label>
                </div>
<%--
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label col-tam ">
                    <input class="mdl-textfield__input color-white" type="text" name="CPF" maxlength="14" minlength="14" onkeydown="javascript: fMasc(this, mCPF);" id="sample3" value="<%=c.getCpf()%>">
                    <label class="mdl-textfield__label mdl-color-text--orange-50" for="sample3">CPF</label>
                    <span class="mdl-textfield__error color-white">Use somente n�meros</span>
                </div>
--%>
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label col-tam ">
                    <input class="mdl-textfield__input color-white" type="email" name="Email" id="sample3" value="<%=c.getEmail()%>">
                    <label class="mdl-textfield__label mdl-color-text--orange-50" for="sample3">Email</label>
                    <span class="mdl-textfield__error color-white">Formato de email inv�lido</span>
                </div>
                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label col-tam ">
                    <input class="mdl-textfield__input color-white" type="text" name="Telefone" 
                            minlength="14" maxlength="14" onkeydown="javascript: fMasc(this, mTel)" id="sample3" value="<%=c.getTelefone()%>">
                    <label class="mdl-textfield__label mdl-color-text--orange-50" for="sample3">Telefone</label>
                    <span class="mdl-textfield__error color-white">Telefone incompleto</span>
                </div>

                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label col-tam">
                    <h2 class="mdl-card__title-text color-white">Endere�o</h2>
                </div>

                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label col-tam ">
                    <input class="mdl-textfield__input color-white" type="text" name="Rua" id="sample5" value="<%=c.getEndereco().getRua()%>">     
                    <label class="mdl-textfield__label mdl-color-text--orange-50" for="sample5">Rua</label>
                </div>  

                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label col-tam ">
                    <input class="mdl-textfield__input color-white" type="text" name="Bairro" id="sample3" value="<%=c.getEndereco().getBairro()%>">
                    <label class="mdl-textfield__label mdl-color-text--orange-50" for="sample3">Bairro</label>
                </div>  

                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label col-tam ">
                    <input class="mdl-textfield__input color-white" type="text" name="Cidade" id="sample5" value="<%=c.getEndereco().getCidade()%>">   
                    <label class="mdl-textfield__label mdl-color-text--orange-50" for="sample5">Cidade</label>
                    <!--<ul for="sample5" class="mdl-menu mdl-menu--bottom-left mdl-js-menu">
                        <li class="mdl-menu__item" data-val="BA">Salvador</li>
                        <li class="mdl-menu__item" data-val="SP">S�o Paulo</li>
                        <li class="mdl-menu__item" data-val="RS">Porto Alegre</li>
                    </ul>-->
                </div>

                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label col-tam ">
                    <input class="mdl-textfield__input color-white" name="Estado" type="text" minlength=8 
                           maxlength="8" id="sample6" value="<%=c.getEndereco().getEstado()%>">      
                    <label class="mdl-textfield__label mdl-color-text--orange-50" for="sample6">Estado</label>
                    <!--<ul for="sample6" class="mdl-menu mdl-menu--bottom-left mdl-js-menu">
                        <li class="mdl-menu__item" data-val="BA">Bahia</li>
                        <li class="mdl-menu__item" data-val="SP">Sao Paulo</li>
                        <li class="mdl-menu__item" data-val="RS">Porto Alegre</li>
                    </ul>-->
                </div>

                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label col-tam ">
                    <input class="mdl-textfield__input color-white" type="text" name="CEP" minlength=10 maxlength="10" onkeydown="javascript: fMasc(this, mCEP);"  id="sample3" value="<%=c.getEndereco().getCEP()%>">
                    <label class="mdl-textfield__label mdl-color-text--orange-50" for="sample3">CEP</label>
                    <span class="mdl-textfield__error color-white">CEP incompleto</span>
                </div>

                <div style="position: absolute; left: -135px;"class="toolbar-section">
                    <button class="mdl-button mdl-js-button mdl-button--raised mdl-color--accent mdl-color-text--accent-contrast mdl-js-ripple-effect margin-top" type="submit" name="submit">Confirmar</button>
                </div>
            </form>
            <a style="position: absolute; left: 150px;top: 842px;" class="mdl-button mdl-js-button mdl-button--raised mdl-color--accent mdl-color-text--accent-contrast mdl-js-ripple-effect" href="Perfil">                    
                Voltar
            </a>
        </div>
      </div>
    </div>
    <div class="mdl-grid center-items color-orange"></div>
<jsp:include page="layout/footer.jsp"/> 
