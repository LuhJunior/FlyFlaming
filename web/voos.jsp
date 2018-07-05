<%-- 
    Document   : voos
    Created on : 21/05/2018, 22:04:36
    Author     : Diego Malta
--%>

<%@page import="java.util.ArrayList"%>
<jsp:include page="layout/header.jsp"/>    
    <jsp:include page="layout/navbarDinamica.jsp"/>
<div class="android-content mdl-layout__content">
    <% ArrayList<Modelo.Voo> v = (ArrayList<Modelo.Voo>)request.getAttribute("Voos");
        ArrayList<Modelo.Voo> v2 = (ArrayList<Modelo.Voo>)request.getAttribute("Voos2");
        int vt = v.size();
        int vt2 = 0;
        if(v2 != null) vt2 = v2.size();%>
    <div class="android-be-together-section" style="height: <%=600+120*(vt+vt2)%>px;">
        <div  class="formulario color-orange" style="width: 1250px; right:1000px; left: 5px; overflow: auto; top: 5%;">     
            <div style="position: relative;  " class="mdl-grid center-items color-orange">
                <div class="logo-font GoBystrok-title GoBystrok-slogan">Opções de Voos</div>
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
                                <td class="mdl-data-table__cell--non-numeric" colspan="11">Voos de Ida</td>
                            </tr> 
                            <%if(v != null && !v.isEmpty()){
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
                                <td class="mdl-data-table__cell--non-numeric" colspan="11">Não há Voos de ida para a data escolhida</td>
                                </tr> 
                            <%}%>
                            
                            <%if(v2 != null){%>
                                <tr>
                                    <td class="mdl-data-table__cell--non-numeric" colspan="11">Voos de Volta</td>
                                </tr> 
                                <%if(v2 !=null && !v2.isEmpty()){

                                int i=0;%>
                                <%for(Modelo.Voo voo: v2){%>
                            <tr>
                                <td class="mdl-data-table__cell--non-numeric"><input type="hidden" name="NumVoo2[<%=i%>]" value="<%=voo.getNumero()%>"><%=voo.getNumero()%></td>
                                <td><%=voo.getOrigem()%></td>
                                <td><%=voo.getDestino()%></td>
                                <td>R$ <%=voo.getValor()%></td>
                                <td><%=voo.getProgramacao().getDataSaida()%></td>
                                <td><%=voo.getProgramacao().getDataChegada() %></td>
                                <td><%=voo.getProgramacao().getHoraSaida()%></td>
                                <td><%=voo.getProgramacao().getHoraChegada()%></td>
                                <td><%=voo.getProgramacao().getQuantidadeExec() %></td>
                                <td><%=voo.getProgramacao().getQuantidadeEcon()%></td>

                                <td><button name="Comprar2" type="submit" value="<%=i%>" class="mdl-button mdl-js-button mdl-button--raised mdl-color--accent mdl-color-text--accent-contrast mdl-js-ripple-effect">Comprar</button></td>

                            </tr>
                            <%i++;}}
                            else{%>
                                <tr>
                                    <td class="mdl-data-table__cell--non-numeric" style="align-content: center;" colspan="11">Não há Voos de volta para a data escolhida</td>
                                </tr> 
                            <%}
                            }%>
                        </tbody>
                    </table>
                </form>
                <a href="index"><button style="margin-top: 40px; margin-left: 15px;" class="mdl-button mdl-js-button mdl-button--raised mdl-color--accent mdl-color-text--accent-contrast mdl-js-ripple-effect mdl-button--mini-fab">
                    Voltar
                </button></a>
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