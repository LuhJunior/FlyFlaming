<%-- 
    Document   : reclamacao
    Created on : 21/05/2018, 21:57:35
    Author     : Diego Malta
--%>


<jsp:include page="autenticarPagina.jsp"/>
<jsp:include page="layout/header.jsp"/>    
    <jsp:include page="layout/navbarLogado.jsp"/>
    
    <div class="android-content mdl-layout__content">
        <div class="android-be-together-section">
            <div class="formulario color-orange">     
                <div class="mdl-grid center-items color-orange">
                    <% Modelo.Passagem[] p = (Modelo.Passagem[]) request.getAttribute("passagens"); %>
                    <div class="logo-font GoBystrok-title GoBystrok-slogan">Reclamação</div>
                    <form action="Reclamar" method="POST" name="reclamacaoForm" class="" onsubmit="return verificarCamposReclamacao()">
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label col-tam ">
                            <input class="mdl-textfield__input color-white" type="text" name="codPassagem" id="sample3">
                            <label class="mdl-textfield__label mdl-color-text--orange-50" for="sample3">Código da Passagem</label>
                        </div>
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label col-tam ">
                            <textarea class="mdl-textfield__input color-white" type="text" name="descricao" rows="5" id="sample3"></textarea>
                            <label class="mdl-textfield__label mdl-color-text--orange-50" for="sample3">Descrição</label>
                        </div>

                        <div class="toolbar-section">
                            <button class="mdl-button mdl-js-button mdl-button--raised mdl-color--accent mdl-color-text--accent-contrast mdl-js-ripple-effect margin-top" 
                                    type="submit" 
                                    name="submit">Enviar
                            </button>
                            <a  href="ConsultarReclamacao"
                                class="mdl-button mdl-js-button mdl-button--raised mdl-color--accent mdl-color-text--accent-contrast mdl-js-ripple-effect margin-top" 
                                name="Reclamacao">Consultar
                            </a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="mdl-grid center-items color-orange"></div>
    </div>
<jsp:include page="layout/footer.jsp"/> 