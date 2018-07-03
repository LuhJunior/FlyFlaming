<%-- 
    Document   : updateReclamacao
    Created on : 14/06/2018, 17:23:02
    Author     : Júnior
--%>
<jsp:include page="autenticarPagina.jsp"/>
<jsp:include page="layout/header.jsp"/>    
    <jsp:include page="layout/navbarLogado.jsp"/>
    <div class="android-content mdl-layout__content">
        <div class="android-be-together-section">
            <div class="formulario color-orange">     
                <div class="mdl-grid center-items color-orange">
                    <% Modelo.Reclamacao r = (Modelo.Reclamacao) request.getAttribute("reclamacao");
                        String Mensagem = (String) request.getAttribute("Mensagem");
                        if(Mensagem != null){%> <script>alert("<%=Mensagem%>")</script><%}%>
                    <div class="logo-font GoBystrok-title GoBystrok-slogan">Reclamação</div>
                    <form action="AtualizarReclamacao" method="POST" name="atualizarReclamacaoForm" class="" onsubmit="">
                        <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label col-tam ">
                            <input type="hidden" name="codReclamacacao" value="<%=r.getCodReclamacao()%>">
                            <textarea class="mdl-textfield__input color-white" type="text" name="descricao" rows="5" id="sample3"><%=r.getDescricao()%></textarea>
                            <label class="mdl-textfield__label mdl-color-text--orange-50" for="sample3">Descrição</label>
                        </div>
                        <div class="toolbar-section">
                            <button class="mdl-button mdl-js-button mdl-button--raised mdl-color--accent mdl-color-text--accent-contrast mdl-js-ripple-effect margin-top" 
                                    type="submit" 
                                    name="submit">Atualizar
                            </button>
                        </div>
                        <div class="toolbar-section">
                            <button class="mdl-button mdl-js-button mdl-button--raised mdl-color--accent mdl-color-text--accent-contrast mdl-js-ripple-effect margin-top" 
                                    type="submit" 
                                    name="submit">Voltar
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="mdl-grid center-items color-orange"></div>
<jsp:include page="layout/footer.jsp"/> 
