<%-- 
    Document   : voosVolta
    Created on : 01/07/2018, 16:33:56
    Author     : Junior
--%>

<%@page import="java.util.ArrayList"%>
<jsp:include page="layout/header.jsp"/>    
    <jsp:include page="layout/navbarDinamica.jsp"/>
<div class="android-content mdl-layout__content">
    <div class="android-be-together-section" style="height: 1000px;">
        <div  class="formulario color-orange" style="right: 1%; left: 1%; overflow: auto; top: 5%;">     
            <div style="position: relative;  " class="mdl-grid center-items color-orange">
                <div class="logo-font GoBystrok-title GoBystrok-slogan">Escolha o Voo de Volta</div>
                <form name="ComprarPassagemForm" method="POST" action="ComprarPassagem">
                    <table style="margin-top: 20px;" class="mdl-data-table mdl-shadow--2dp">
                        <thead>
                            <tr>
                                <th class="mdl-data-table__cell--non-numeric">Número do Voo</th>
                                <th>Origem</th>
                                <th>Destino</th>
                                <th>Valor</th>
                                <th>Data Saída</th>
                                <th>Data Chegada</th>
                                <th>Hora Saída</th>
                                <th>Hora Chegada</th>
                                <th>Executivo</th>
                                <th>Econômico</th>
                                <th>Opção<th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td class="mdl-data-table__cell--non-numeric" colspan="11">Voos de Volta</td>
                            </tr> 
                            <% ArrayList<Modelo.Voo> v = (ArrayList<Modelo.Voo>)request.getAttribute("Voos");
                            if(v != null && !v.isEmpty()){
                                int i=0;
                                for(Modelo.Voo voo: v){%>
                                    <tr>
                                        <td class="mdl-data-table__cell--non-numeric"><input type="hidden" name="NumVoo[<%=i%>]" value="<%=voo.getNumero()%>"><%=voo.getNumero()%></td>

                                        <td><input type="hidden" name="Origem[<%=i%>]" value="<%=voo.getOrigem()%>"><%=voo.getOrigem()%></td>
                                        <td><%=voo.getDestino()%></td>
                                        <td>R$ <%=voo.getValor()%></td>
                                        <td><%=voo.getProgramacao().getDataSaida()%></td>
                                        <td><%=voo.getProgramacao().getDataChegada() %></td>
                                        <td><%=voo.getProgramacao().getHoraSaida()%></td>
                                        <td><%=voo.getProgramacao().getHoraChegada()%></td>
                                        <td><%=voo.getProgramacao().getQuantidadeExec() %></td>
                                        <td><%=voo.getProgramacao().getQuantidadeEcon()%></td>

                                        <td><button name="Comprar" type="submit" value="<%=i%>" class="mdl-button mdl-js-button mdl-button--raised mdl-color--accent mdl-color-text--accent-contrast mdl-js-ripple-effect">Comprar</button></td>
                                    </tr>
                                    <%i++;}}
                            else {%>
                                <tr>
                                <td class="mdl-data-table__cell--non-numeric mdl-card__title-text" colspan="11">Não há Voos de Volta para a data escolhida</td>
                                </tr> 
                            <%}%>
                        </tbody>
                    </table>
                </form>
                <a href="index"><button style="margin-top: 40px; margin-left: 15px;" class="mdl-button mdl-js-button mdl-button--raised mdl-color--accent mdl-color-text--accent-contrast mdl-js-ripple-effect mdl-button--mini-fab">
                    Voltar
                </button></a>
            </div>
        </div>
    </div>
    <div class="mdl-grid center-items color-orange"></div>
<jsp:include page="layout/footer.jsp"/> 
