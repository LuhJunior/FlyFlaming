<%-- 
    Document   : pagamento
    Created on : 21/05/2018, 21:53:44
    Author     : Diego Malta
--%>
<jsp:include page="autenticarPagina.jsp"/>
    <jsp:include page="layout/header.jsp"/>    
        <jsp:include page="layout/navbarLogado.jsp"/>
            <div class="android-content mdl-layout__content">
                <div class="android-be-together-section" style="height: 900px;">
                    <div class="formulario color-orange ">     
                        <div class="mdl-grid center-items color-orange">
                                <div class="logo-font GoBystrok-title GoBystrok-slogan">Pagamento</div>
                            <form method="POST" name="pagamentoForm" action="Pagar" onsubmit="return verificarCamposPagamento()">
                                <% Modelo.Passagem p = (Modelo.Passagem)request.getSession().getAttribute("Passagem");
                                    if(p != null)
                                %>
                                    <input type="hidden" name="Codigo" value="<%=p.getCodigo()%>">
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label col-tam ">
                                    <input class="mdl-textfield__input color-white" type="text" name="numCard" minlength="19" maxlength="19" onkeypress="fMasc(this, mCartao)" id="sample3">
                                    <label class="mdl-textfield__label mdl-color-text--orange-50" for="sample3">Número do Cartão</label>
                                    <span class="mdl-textfield__error color-white">Tamanho inválido</span>
                                </div>
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label col-tam ">
                                    <input class="mdl-textfield__input color-white" type="password" minlength="4" maxlength="8" name="Senha" id="sample3">
                                    <label class="mdl-textfield__label mdl-color-text--orange-50" for="sample3">Senha</label>
                                    <span class="mdl-textfield__error color-white">Use no mínimo 4 dígitos</span>
                                </div>
                                <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label col-tam ">
                                    <input class="mdl-textfield__input color-white" type="text" pattern = "-?[0-9]*(\.[0-9]+)?" name="valor" value="<%=p.getValor()%>" id="sample3">
                                    <label class="mdl-textfield__label mdl-color-text--orange-50" for="sample3">Valor R$</label>
                                </div>
                                <div id="parcelasDiv" class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label col-tam">
                                    <input class="mdl-textfield__input color-white" type="number" name="Parcelas" pattern="-?[1-6]?" value="1" maxlength="1" id="sample7" readonly>
                                    <label class="mdl-textfield__label mdl-color-text--orange-50" for="sample7">Parcelas</label>
                                    <ul for="sample7" class="mdl-menu mdl-menu--bottom-left mdl-js-menu" id="valores">
                                        <li class="mdl-menu__item" onclick="pagamentoForm.Parcelas.value = 1">1</li>
                                        <li class="mdl-menu__item" onclick="pagamentoForm.Parcelas.value = 2">2</li>
                                        <li class="mdl-menu__item" onclick="pagamentoForm.Parcelas.value = 3">3</li>
                                        <li class="mdl-menu__item" onclick="pagamentoForm.Parcelas.value = 4">4</li>
                                        <li class="mdl-menu__item" onclick="pagamentoForm.Parcelas.value = 5">5</li>
                                        <li class="mdl-menu__item" onclick="pagamentoForm.Parcelas.value = 6">6</li>
                                    </ul>    
                                    <span class="mdl-textfield__error color-white">Use números de 1 a 6</span>
                                </div>
                                <div class="toolbar-section">
                                    <button class="mdl-button mdl-js-button mdl-button--raised mdl-color--accent mdl-color-text--accent-contrast mdl-js-ripple-effect margin-top" type="submit" name="submit">Pagar</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
<jsp:include page="layout/footer.jsp"/> 