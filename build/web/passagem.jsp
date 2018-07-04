<%-- 
    Document   : checkin
    Created on : 21/05/2018, 22:10:57
    Author     : Diego Malta
--%>
<jsp:include page="autenticarPagina.jsp"/>
<jsp:include page="layout/header.jsp"/>   
    <jsp:include page="layout/navbarLogado.jsp"/>
    <div class="android-content mdl-layout__content">
         <% Modelo.Passagem[] p = (Modelo.Passagem[]) request.getAttribute("passagens");
         if(p == null) p = new Modelo.Passagem[0];%>
        <div class="android-be-together-section" style="height: <%=600+90*p.length%>px;">
            <div class="formulario color-orange" style="top: 5%;width: 1200px; left: 30px; height: <%=80*p.length%>px;"> 
                <div class="mdl-grid center-items color-orange">
                    <div class="logo-font GoBystrok-title GoBystrok-slogan" style="padding-left: 50px;">Passagens</div>
                    <div class="center-items">
                        <form action="CheckarCancelar" method="POST" name="" class="" onsubmit="return verificarCheckarCancelar()">
                            <table style="margin-top: 20px;" class="mdl-data-table mdl-shadow--2dp">
                                <thead>
                                    <tr>
                                        <th class="mdl-data-table__cell--non-numeric">Código</th>
                                        <th class="mdl-data-table__cell--non-numeric">Fileira</th>
                                        <th class="mdl-data-table__cell--non-numeric">Coluna</th>
                                        <th class="mdl-data-table__cell--non-numeric">Checkin</th>
                                        <th class="mdl-data-table__cell--non-numeric">Cancelamento</th>
                                        <th class="mdl-data-table__cell--non-numeric">Valor</th>
                                        <th class="mdl-data-table__cell--non-numeric">Data e Hora da Compra</th>
                                        <th class="mdl-data-table__cell--non-numeric">Volta</th>
                                        <th class="mdl-data-table__cell--non-numeric">Opções</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%if(p != null && p.length>0){ 
                                        for(int i=0; i<p.length; i++){
                                    %>
                                        <tr>
                                            <td class="mdl-data-table__cell--non-numeric"><input type="hidden" name="codPassagem[<%=i%>]" value="<%=p[i].getCodigo()%>"><%=p[i].getCodigo()%></td>
                                            <td class="mdl-data-table__cell--non-numeric"><input type="hidden" name="Fileira[<%=i%>]" value="<%=p[i].getAssento().getFileira()%>"><%=p[i].getAssento().getFileira()%></td>
                                            <td class="mdl-data-table__cell--non-numeric"><input type="hidden" name="Cadeira[<%=i%>]" value="<%=p[i].getAssento().getCadeira()%>"><%=p[i].getAssento().getCadeira()%></td>
                                            <td class="mdl-data-table__cell--non-numeric"><input type="hidden" name="Checkin[<%=i%>]" value="<%=p[i].getCheckin()%>"><%=p[i].getCheckin()%></td>
                                            <td class="mdl-data-table__cell--non-numeric"><input type="hidden" name="Cancelamento[<%=i%>]" value="<%=p[i].getCancelamento()%>"><%=p[i].getCancelamento()%></td>
                                            <td class="mdl-data-table__cell--non-numeric"><input type="hidden" name="Valor[<%=i%>]" value="<%=p[i].getValor()%>"><%=p[i].getValor()%></td>
                                            <td class="mdl-data-table__cell--non-numeric"><input type="hidden" name="Data[<%=i%>]" value="<%=p[i].getHoraCompra()%>"><%=p[i].getHoraCompra()%></td>
                                            <%if(p[i].getCodigoVolta()>0){%>
                                                <td class="mdl-data-table__cell--non-numeric"><input type="hidden" name="Volta[<%=i%>]" value="<%=p[i].getCodigoVolta()%>"><%=p[i].getCodigoVolta()%></td>
                                            <%}else{%>
                                                <td class="mdl-data-table__cell--non-numeric"><input type="hidden" name="Volta[<%=i%>]" value="<%=p[i].getCodigoVolta()%>"></td>
                                            <%}%>    
                                            <td>
                                                <button class="mdl-button mdl-js-button mdl-button--raised mdl-color--accent mdl-color-text--accent-contrast mdl-js-ripple-effect" type="submit" name="submit" value="checkin-<%=i%>">Check-in</button>
                                                <button class="mdl-button mdl-js-button mdl-button--raised mdl-color--accent mdl-color-text--accent-contrast mdl-js-ripple-effect" type="submit" name="submit" value="cancelar-<%=i%>">Cancelar</button>
                                            </td>
                                        </tr>
                                        <%}
                                    }else{%>
                                        <tr>
                                            <td class="mdl-data-table__cell--non-numeric" colspan="7">Não Existe Passagens Compradas</td>
                                        </tr> 
                                    <%}%>
                                </tbody>
                            </table> 
                        </form>
                    </div>
                </div>
            </div>
        </div>
        
<jsp:include page="layout/footer.jsp"/> 
<% String Mensagem = (String) request.getAttribute("Mensagem");
    String Erro = (String) request.getAttribute("Erro");
    if(Mensagem != null){%>
    <script>ShowMensagemSucesso("<%=Mensagem%>");</script>
<%}
    if(Erro != null){%>
    <script>ShowMensagemErro("<%=Erro%>");</script>
<%}%>