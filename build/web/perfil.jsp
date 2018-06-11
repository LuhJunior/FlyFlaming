<%-- 
    Document   : perfil
    Created on : 10/06/2018, 12:14:18
    Author     : Júnior
--%>

<jsp:include page="autenticarPagina.jsp"/>
<jsp:include page="layout/header.jsp"/>    
    <jsp:include page="layout/navbarLogado.jsp"/>
    <div class="android-content mdl-layout__content">
        <div class="android-be-together-section">
            <div class="formulario-cadastro color-orange"> 
                <div class="mdl-grid center-items color-orange">
                    <% Modelo.Cliente c = (Modelo.Cliente)request.getAttribute("cliente");
                        String men = null;
                        if(c == null) {
                            c = new Modelo.Cliente();
                            men = (String)request.getAttribute("Mensagem");
                    %><script>alert(men)</script> <%
                        }
                        if(c.getTelefone() == null) c.setTelefone("");
                        if(c.getEndereco() == null) c.setEndereco(new Modelo.Endereco());
                    %>
                    <div class="logo-font GoBystrok-title GoBystrok-slogan">Perfil</div>
                    <div center-items>
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label col-tam">
                            <h2 class="mdl-card__title-text color-white">Dados Pessoais</h2>
                        </div>

                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label col-tam ">
                            <input class="mdl-textfield__input color-white" type="text" name="Nome" maxlength="50" id="sample3" value="<%=c.getNome()%>" readonly="">
                            <label class="mdl-textfield__label mdl-color-text--orange-50" for="sample3">Nome</label>
                        </div>

                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label col-tam ">
                            <input class="mdl-textfield__input color-white" type="text" name="CPF" maxlength="11" pattern = "-?[0-9]*(\.[0-9]+)?" id="sample3" value="<%=c.getCpf()%>" readonly="">
                            <label class="mdl-textfield__label mdl-color-text--orange-50" for="sample3">CPF</label>
                        </div>

                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label col-tam ">
                            <input class="mdl-textfield__input color-white" type="email" name="Email" id="sample3" value="<%=c.getEmail()%>" readonly="">
                            <label class="mdl-textfield__label mdl-color-text--orange-50" for="sample3">Email</label>
                        </div>
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label col-tam ">
                            <input class="mdl-textfield__input color-white" type="text" name="Telefone" 
                                 minlength="9" maxlength="15" id="sample3" value="<%=c.getTelefone()%>" readonly="">
                            <label class="mdl-textfield__label mdl-color-text--orange-50" for="sample3">Telefone</label>
                            <span class="mdl-textfield__error color-white">Use somente números</span>
                        </div>

                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label col-tam" readonly="">
                            <h2 class="mdl-card__title-text color-white">Endereço</h2>
                        </div>

                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label col-tam ">
                            <input class="mdl-textfield__input color-white" type="text" name="Rua" id="sample5" value="<%=c.getEndereco().getRua()%>" readonly="">     
                            <label class="mdl-textfield__label mdl-color-text--orange-50" for="sample5">Rua</label>
                        </div>  

                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label col-tam " value="<%=c.getEndereco().getBairro()%>" readonly="">
                            <input class="mdl-textfield__input color-white" type="text" name="Bairro" id="sample3">
                            <label class="mdl-textfield__label mdl-color-text--orange-50" for="sample3">Bairro</label>
                        </div>  

                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label col-tam ">
                            <input class="mdl-textfield__input color-white" type="text" name="Cidade" id="sample5" value="<%=c.getEndereco().getCidade()%>" readonly="">     
                            <label class="mdl-textfield__label mdl-color-text--orange-50" for="sample5">Cidade</label>
                        </div>

                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label col-tam ">
                            <input class="mdl-textfield__input color-white" name="Estado" type="text" minlength=8 
                                   maxlength="8" id="sample6" value="<%=c.getEndereco().getEstado()%>" readonly="">      
                            <label class="mdl-textfield__label mdl-color-text--orange-50" for="sample6">Estado</label>
                        </div>

                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label col-tam ">
                            <input class="mdl-textfield__input color-white" type="text" name="CEP" id="sample3" value="<%=c.getEndereco().getCEP()%>" readonly="">
                            <label class="mdl-textfield__label mdl-color-text--orange-50" for="sample3">CEP</label>
                        </div>

                        <div class="toolbar-section">
                            <a href="updateCliente"> <button class="mdl-button mdl-js-button mdl-button--raised mdl-color--accent mdl-color-text--accent-contrast mdl-js-ripple-effect margin-top">Alterar Dados</button></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    <div class="android-screen-section mdl-typography--text-center GoBystrok-spacer"></div>
    <div class="android-screen-section mdl-typography--text-center GoBystrok-spacer"></div>
    <div class="mdl-grid center-items color-orange"></div>
<jsp:include page="layout/footer.jsp"/> 
