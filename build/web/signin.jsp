<%@page import="java.util.ArrayList"%>
<%@page import="Negocio.ofertasNeg"%>
<jsp:include page="layout/header.jsp"/>
    <jsp:include page="layout/navbarDinamicaIndex.jsp"/>
        <div class="android-content mdl-layout__content">
            <section id="pesquisarPassagem">
                <a name="top"></a>
                <div class="android-be-together-sectionA mdl-typography--text-center">
                    <div style="color: transparent" class="logo-font android-slogan GoBystrok-slogan">Fly Flaming</div>
                    <div style="color: transparent" class="logo-font android-sub-slogan GoBystrok-sub-slogan">Simplificando o controle da sua viagem. Como sempre deveria ter sido.</div>
                    
                <div class="formulario-cadastro color-orange"> 
                    <div class="mdl-grid center-items color-orange">
                        <% String men = (String)request.getAttribute("Mensagem");%>
                        <% if(men != null){%>
                            <script>alert("<%=men%>");</script>
                        <%}%>
                        <div class="logo-font GoBystrok-title GoBystrok-slogan">Cadastrar-se</div>
                        <form action="cadastrarCliente" method="POST" name="cadastrarCliente" class="" onsubmit="return verificarCamposCadastro()">

                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label col-tam">
                                <h2 class="mdl-card__title-text color-white">Dados Pessoais</h2>
                            </div>
                            
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label col-tam ">
                                <input class="mdl-textfield__input color-white" type="text" name="Nome" maxlength="50" id="samwqwqple3">
                                <label class="mdl-textfield__label mdl-color-text--orange-50" for="sample3">Nome</label> 
                            </div>
                            

                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label col-tam ">
                                <input class="mdl-textfield__input color-white" type="text" name="CPF" maxlength="11" pattern = "-?[0-9]*(\.[0-9]+)?" id="saweweple3">
                                <label class="mdl-textfield__label mdl-color-text--orange-50" for="sample3">CPF</label>
                                <span class="mdl-textfield__error color-white">Use somente números</span>
                            </div>

                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label col-tam ">
                                <input class="mdl-textfield__input color-white" type="password" name="Senha" id="senha"
                                    minlength="8" maxlength="16">
                                <label class="mdl-textfield__label mdl-color-text--orange-50" for="sample3">Senha</label>
                            </div>
                            
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label col-tam ">
                                <input class="mdl-textfield__input color-white" type="password" name="Senha" id="senha2"
                                    minlength="8" maxlength="16">
                                <label class="mdl-textfield__label mdl-color-text--orange-50" for="sample3">Confirme sua senha</label>
                            </div>

                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label col-tam ">
                                <input class="mdl-textfield__input color-white" type="email" name="Email" id="samplreree3">
                                <label class="mdl-textfield__label mdl-color-text--orange-50" for="sample3">Email</label>
                                <span class="mdl-textfield__error color-white">Formato de email inválido</span>
                            </div>
                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label col-tam ">
                                <input class="mdl-textfield__input color-white" type="text" name="Telefone" 
                                       pattern = "-?[0-9]*(\.[0-9]+)?" minlength="9" maxlength="15" id="samdsdsple3">
                                <label class="mdl-textfield__label mdl-color-text--orange-50" for="sample3">Telefone</label>
                                <span class="mdl-textfield__error color-white">Use somente números</span>
                            </div>

                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label col-tam">
                                <h2 class="mdl-card__title-text color-white">Endereço</h2>
                            </div>

                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label col-tam ">
                                <input class="mdl-textfield__input color-white" type="text" name="Rua" id="sampdsdsle5">     
                                <label class="mdl-textfield__label mdl-color-text--orange-50" for="samplsae5">Rua</label>
                            </div>  

                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label col-tam ">
                                <input class="mdl-textfield__input color-white" type="text" name="Bairro" id="samprewrele3">
                                <label class="mdl-textfield__label mdl-color-text--orange-50" for="sample3">Bairro</label>
                            </div>  

                            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label col-tam ">
                                <input class="mdl-textfield__input color-white" type="text" name="Cidade" id="sampdsdswle5">     
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
                                <input class="mdl-textfield__input color-white" type="text" name="CEP" pattern = "-?[0-9]*(\.[0-9]+)?" id="sawqwqmple3">
                                <label class="mdl-textfield__label mdl-color-text--orange-50" for="sample3">CEP</label>
                                <span class="mdl-textfield__error color-white">Use somente números</span>
                            </div>

                            <div class="">
                                <button type="submit" name="submit" class="mdl-button mdl-js-button mdl-button--raised mdl-color--accent mdl-color-text--accent-contrast mdl-js-ripple-effect margin-top">
                                    Cadastrar
                                </button>
                            </div>
                    </form>
                </div>                    
            </div>
        </section>
<jsp:include page="layout/footer.jsp"/>  