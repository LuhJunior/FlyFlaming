<%-- 
    Document   : passagens
    Created on : 27/06/2018, 02:55:20
    Author     : Junior
--%>

<jsp:include page="autenticarPagina.jsp"/>
<jsp:include page="layout/header.jsp"/>   
    <jsp:include page="layout/navbarLogado.jsp"/>
    <div class="android-content mdl-layout__content">
        <div class="android-be-together-section" style="height: 1000px">
            <div class="formulario color-orange" style="right: 16%; left: 16%; overflow: auto;"> 
                <div class="mdl-grid center-items">
                    <% Modelo.Passagem[] p = (Modelo.Passagem[]) request.getAttribute("Passagens"); 
                        String Mensagem = (String) request.getAttribute("Mensagem");
                        if(Mensagem != null){%> <script>alert("<%=Mensagem%>")</script><%}%>
                    <div class="logo-font GoBystrok-title GoBystrok-slogan">Opções de Passagem</div>
                    <div class="center-items">
                        <form action="CheckarCancelar" method="POST" name="checkinForm" class=""  onsubmit="return verificarCamposCheckin()">
                            <table style="margin-top: 20px;" class="mdl-data-table mdl-shadow--2dp">
                                <thead>
                                    <tr>
                                        <th class="mdl-data-table__cell--non-numeric">Código da Passagem</th>
                                        <th>Fileira</th>
                                        <th>Cadeira da Fileira</th>
                                        <th>Valor</th>
                                        <th>Data e Hora da Compra</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%if(p != null){ 
                                        for(int i=0; i<p.length; i++){
                                    %>
                                        <tr>
                                            <td class="mdl-data-table__cell--non-numeric"><input type="hidden" name="codPassagem[<%=i%>]" value="<%=p[i].getCodigo()%>"><%=p[i].getCodigo()%></td>
                                            <td class="mdl-data-table__cell--non-numeric"><input type="hidden" name="Fileira[<%=i%>]" value="<%=p[i].getAssento().getFileira()%>"><%=p[i].getAssento().getFileira()%></td>
                                            <td class="mdl-data-table__cell--non-numeric"><input type="hidden" name="Cadeira[<%=i%>]" value="<%=p[i].getAssento().getCadeira()%>"><%=p[i].getAssento().getCadeira()%></td>
                                            <td class="mdl-data-table__cell--non-numeric"><input type="hidden" name="Valor[<%=i%>]" value="<%=p[i].getValor()%>"><%=p[i].getValor()%></td>
                                            <td class="mdl-data-table__cell--non-numeric"><input type="hidden" name="Data[<%=i%>]" value="<%=p[i].getHoraCompra()%>"><%=p[i].getHoraCompra()%></td>
                                            
                                            
                                            <!--//    <button class="mdl-button mdl-js-button mdl-button--raised mdl-color--accent mdl-color-text--accent-contrast mdl-js-ripple-effect margin-top" type="submit" name="submit" value="checkin-<%=i%>">Escolher</button>!-->
                                            
                                            
                                        </tr>
                                        <%}
                                    }else{%>
                                        <script>alert("Não sem check-in ou cancelamento feitos");</script>
                                    <%}%>
                                </tbody>
                            </table> 
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="mdl-grid center-items color-orange"></div>
    </div>
<jsp:include page="layout/footer.jsp"/> 
<% String men = (String)request.getAttribute("Mensagem");%>
<% if(men != null){%>
    <script>swal("<%=men%>");</script>
<%}%>