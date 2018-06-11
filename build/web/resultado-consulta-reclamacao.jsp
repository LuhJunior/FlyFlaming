<%-- 
    Document   : resultado-consulta-reclamacao
    Created on : 21/05/2018, 22:00:30
    Author     : Diego Malta
--%>
<jsp:include page="autenticarPagina.jsp"/>
<jsp:include page="layout/header.jsp"/>    
    <jsp:include page="layout/navbarLogado.jsp"/>
    <div class="android-content mdl-layout__content">
        <div class="android-be-together-section">
            <div class="formulario color-orange">     
                <div class="mdl-grid center-items color-orange">
                    <div class="logo-font GoBystrok-title GoBystrok-slogan">Reclamações</div>
                    <% Modelo.Passagem[] p = (Modelo.Passagem[]) request.getAttribute("passagens"); %>
                    <div class="center-items">
                    <form action="UDReclamacao" method="post" name="UDReclamacaoForm" onsubmit="">
                        <table style="margin-top: 20px;" class="mdl-data-table mdl-shadow--2dp">
                            <thead>
                                <tr>
                                    <th></th>
                                    <th class="mdl-data-table__cell--non-numeric">Código da Passagem</th>
                                    <th>Descrição</th>
                                    <th>Situação</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%if(p != null){ 
                                    for(int i=0; i<p.length; i++){
                                %>
                                    <tr>
                                        <td>
                                            <label class="mdl-checkbox mdl-js-checkbox mdl-js-ripple-effect mdl-data-table__select">
                                                <input type="checkbox" name="selected" class="mdl-checkbox__input"/>
                                            </label>
                                        </td>
                                        <td class="mdl-data-table__cell--non-numeric"><input type="hidden" name="codPassagem" value="<%=p[i].getCodigo()%>"><%=p[i].getCodigo()%></td>
                                        <input type="hidden" name="codReclamacao" value="<%=p[i].getReclamacao().getCodReclamacao()%>">
                                        <td class="mdl-data-table__cell--non-numeric"><%=p[i].getReclamacao().getDescricao()%></td>
                                        <%
                                            String situacao;
                                            if(p[i].getReclamacao().getEstado() == 'A') situacao = "Aberto";
                                            else situacao = "Resolvido";
                                        %>
                                        <td class="mdl-data-table__cell--non-numeric"><%=situacao%></td>
                                    </tr>
                                    <%}
                                }else{%>
                                    <script>alert("Não existe passagens com reclamação");</script>
                                <%}%>
                            </tbody>
                        </table>
                        <button type="submit" name="Editar" class="mdl-button mdl-js-button mdl-button--raised mdl-color--accent mdl-color-text--accent-contrast mdl-js-ripple-effect margin-top">Editar Reclamação</button>
                        <button type="submit" name="excluir" class="mdl-button mdl-js-button mdl-button--raised mdl-color--accent mdl-color-text--accent-contrast mdl-js-ripple-effect margin-top">Excluir Reclamação</button>
                    </form>
                    </div>
                    <div>
                        <a href="reclamacao.jsp">
                        <button class="mdl-button mdl-js-button mdl-button--raised mdl-color--accent mdl-color-text--accent-contrast mdl-js-ripple-effect" type="submit" name="submit">Voltar</button>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
<jsp:include page="layout/footer.jsp"/> 