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
                <div class="mdl-grid center-items color-orange" style="left: 10%;right: 10%;">
                    <div class="logo-font GoBystrok-title GoBystrok-slogan">Reclamações</div>
                    <% Modelo.Passagem[] p = (Modelo.Passagem[]) request.getAttribute("passagens");
                        String Mensagem = (String) request.getAttribute("Mensagem");
                        if(Mensagem != null){%> <script>alert("<%=Mensagem%>")</script><%}%>
                    <div class="center-items">
                    <form action="UpdateDeleteReclamacao" method="post" name="UpdateDeleteReclamacaoForm" onsubmit="">
                        <table style="margin-top: 20px;" class="mdl-data-table mdl-shadow--2dp">
                            <thead>
                                <tr>
                                    <th class="mdl-data-table__cell--non-numeric">Código da Passagem</th>
                                    <th>Descrição</th>
                                    <th>Situação</th>
                                    <th>Opções</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%if(p != null){ 
                                    for(int i=0; i<p.length; i++){
                                %>
                                    <tr>
                                        <%
                                            String situacao;
                                            if(p[i].getReclamacao().getEstado() == 'A') situacao = "Aberto";
                                            else situacao = "Resolvido";
                                        %>
                                        <td class="mdl-data-table__cell--non-numeric"><input type="hidden" name="codPassagem[<%=i%>]" value="<%=p[i].getCodigo()%>"><%=p[i].getCodigo()%></td>
                                        <td class="mdl-data-table__cell--non-numeric"><input type="hidden" name="descricao[<%=i%>]" value="<%=p[i].getReclamacao().getDescricao()%>"><%=p[i].getReclamacao().getDescricao()%></td>
                                        <td class="mdl-data-table__cell--non-numeric"><input type="hidden" name="codReclamacao[<%=i%>]" value="<%=situacao%>"><%=situacao%></td>
                                        <td>
                                            <button name="submit" type="submit" value="Editar-<%=i%>" class="mdl-button mdl-js-button mdl-button--raised mdl-color--accent mdl-color-text--accent-contrast mdl-js-ripple-effect">Editar</button>
                                            <button name="submit" type="submit" value="Excluir-<%=i%>" class="mdl-button mdl-js-button mdl-button--raised mdl-color--accent mdl-color-text--accent-contrast mdl-js-ripple-effect">Excluir</button>
                                        </td>   
                                    </tr>
                                    <%}
                                }else{%>
                                    <script>alert("Não existe passagens com reclamação");</script>
                                <%}%>
                            </tbody>
                        </table>
                    </form>
                    </div>
                </div>
                <div style="padding: 50px;">
                    <a class="mdl-button mdl-js-button mdl-button--raised mdl-color--accent mdl-color-text--accent-contrast mdl-js-ripple-effect" href="reclamacao.jsp">                    
                        Voltar
                    </a>
                </div>
            </div>
        </div>
<jsp:include page="layout/footer.jsp"/> 