<%-- 
    Document   : checkin
    Created on : 21/05/2018, 22:10:57
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
                    <div class="logo-font GoBystrok-title GoBystrok-slogan">Opções de Passagem</div>
                    <div class="center-items">
                        <form action="checkinOuCancelamento" method="POST" name="checkinForm" class="" onsubmit="return verificarCamposCheckin()">
                            <table style="margin-top: 20px;" class="mdl-data-table mdl-shadow--2dp">
                                <thead>
                                    <tr>
                                        <th></th>
                                        <th class="mdl-data-table__cell--non-numeric">Código da Passagem</th>
                                        <th>Assento</th>
                                        <th>Data e Hora da Compra</th>
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
                                            <td class="mdl-data-table__cell--non-numeric"><%=p[i].getAssento()%></td>
                                            <td class="mdl-data-table__cell--non-numeric"><%=p[i].getHoraCompra()%></td>
                                        </tr>
                                        <%}
                                    }else{%>
                                        <script>alert("Não existe passagens compradas");</script>
                                    <%}%>
                                </tbody>
                            </table>
                            <button class="mdl-button mdl-js-button mdl-button--raised mdl-color--accent mdl-color-text--accent-contrast mdl-js-ripple-effect margin-top" type="submit" name="submit" value="checkin">Fazer Check-in</button>
                            <button class="mdl-button mdl-js-button mdl-button--raised mdl-color--accent mdl-color-text--accent-contrast mdl-js-ripple-effect margin-top" type="submit" name="submit" value="cancelar">Cancelar passagem</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="mdl-grid center-items color-orange"></div>
    </div>
<jsp:include page="layout/footer.jsp"/> 
<% String men = (String)request.getAttribute("VaiDa");%>
<% if(men != null){%>
    <script>alert("<%=men%>");</script>
<%}%>