<%-- 
    Document   : resultado-consulta-reclamacao
    Created on : 21/05/2018, 22:00:30
    Author     : Diego Malta
--%>
<jsp:include page="autenticacaoPagina.jsp"/>
<jsp:include page="layout/header.jsp"/>    
    <jsp:include page="layout/navbarLogado.jsp"/>
    <div class="android-content mdl-layout__content">
        <div class="android-be-together-section">
            <div class="formulario color-orange">     
                <div class="mdl-grid center-items color-orange">
                    <div class="logo-font GoBystrok-title GoBystrok-slogan">Reclamações</div>
                    <% Modelo.Passagem[] p = (Modelo.Passagem[]) request.getAttribute("passagens"); %>
                        <table style="margin-top: 20px;" class="mdl-data-table mdl-js-data-table mdl-shadow--2dp ">
                            <thead>
                                <tr>
                                    <th class="mdl-data-table__cell--non-numeric">Código da Passagem</th>
                                    <th class="mdl-data-table__cell--non-numeric">Código da Reclamação</th>
                                    <th>Descrição</th>
                                    <th>Situação</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%if(p != null){ 
                                    for(int i=0; i<p.length; i++){
                                %>
                                <script>alert("<%=i%>")</script>
                                    <tr>
                                        <td class="mdl-data-table__cell--non-numeric"><%=p[i].getCodigo()%></td>
                                        <td class="mdl-data-table__cell--non-numeric"><%=p[i].getReclamacao().getCodReclamacao()%></td>
                                        <td><%=p[i].getReclamacao().getDescricao()%></td>
                                        <%
                                            String situacao;
                                            if(p[i].getReclamacao().getEstado() == 'A') situacao = "Aberto";
                                            else situacao = "Resolvido";
                                        %>
                                        <td><%=situacao%></td>
                                    </tr>
                                    <%}
                                }else{%>
                                    <script>alert("Não existe passagens com reclamação");</script>
                                <%}%>
                            </tbody>
                        </table>
                    <div class="toolbar-section">
                        <a href="reclamacao.jsp">
                        <button class="mdl-button mdl-js-button mdl-button--raised mdl-color--accent mdl-color-text--accent-contrast mdl-js-ripple-effect margin-top" type="submit" name="submit">Voltar</button>
                        </a>
                    </div>
                </div>
            </div>
        </div>

        <div class="mdl-grid center-items color-orange"></div>
<jsp:include page="layout/footer.jsp"/> 