<%-- 
    Document   : index
    Created on : 21/05/2018, 21:30:37
    Author     : Diego Malta
--%>

<%@page import="java.util.ArrayList"%>
<jsp:include page="layout/header.jsp"/>
    <jsp:include page="layout/navbarDinamicaIndex.jsp"/>
        <div class="android-content mdl-layout__content">
            <section id="pesquisarPassagem">
                <a name="top"></a>
                <div class="android-be-together-section mdl-typography--text-center" style="height: 1000px;">
                    <div class="logo-font android-slogan GoBystrok-slogan">Fly Flaming</div>
                    <div class="logo-font android-sub-slogan GoBystrok-sub-slogan">Simplificando o controle da sua viagem. Como sempre deveria ter sido.</div>

                    <div class="android-fab color-orange padding-form" style="top: 370px; right: 280px; height: 500px;">
                        <div class="mdl-card__title mdl-card--expand">
                            <h2 class="mdl-card__title-text color-white">Comprar passagem</h2>
                        </div>
                        <form name="compraPassagem" method="POST" action="PesquisarVoo" onsubmit="">
                            <div class = "mdl-grid layout-center">
                                <div class = "mdl-cell mdl-cell--5-col graybox">
                                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                        <input class="mdl-textfield__input color-white" type="text" name="Origem" id="Origem">
                                        <label class="mdl-textfield__label mdl-color-text--orange-50" for="Origem">Origem</label>
                                    </div>
                                </div>
                                <div class = "mdl-cell mdl-cell--5-col graybox">
                                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                        <input class="mdl-textfield__input color-white" type="text" name="Destino" id="Destino">
                                        <label class="mdl-textfield__label mdl-color-text--orange-50" for="Destino">Destino</label>
                                    </div>
                                </div>
                            </div>

                            <div class="mdl-grid layout-center">
                                <div class="mdl-cell mdl-cell--5-col graybox">
                                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                        <input class="mdl-textfield__input mdl-color-text--orange-50" type="date" name="dateIda" id="dateIda">
                                        <label class="mdl-textfield__label mdl-color-text--orange-50" for="dateIda"></label>
                                    </div>
                                </div>
                                <div class="mdl-cell mdl-cell--5-col graybox">
                                    <div id="VoltaS" class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                        <input class="mdl-textfield__input mdl-color-text--orange-50" type="date" name="dateVolta" id="dateVolta">
                                        <label class="mdl-textfield__label mdl-color-text--orange-50" for="dateVolta"></label>
                                    </div>
                                </div>
                            </div>

                            <div class="mdl-grid">
                                <div class="mdl-cell mdl-cell--7-col graybox">
                                    <label class="mdl-radio mdl-js-radio" for="option1">
                                        <input type="radio" id="option1" name="escolha" value="IdaeVolta" class="mdl-radio__button mdl-color-text--orange-50" checked>
                                        <span class="mdl-radio__label mdl-color-text--orange-50">Ida e Volta</span>
                                    </label>
                                    <span style="padding-left: 20px;">
                                        <label class="mdl-radio mdl-js-radio" for="option2">
                                            <input type="radio" id="option2" name="escolha" value="Ida" class="mdl-radio__button mdl-color-text--orange-50">
                                            <span class="mdl-radio__label mdl-color-text--orange-50">Somente Ida</span>
                                        </label>
                                    </span>
                                </div>
                            </div>

                            <button type="submit" name="submit" class="mdl-button mdl-js-button mdl-button--raised mdl-color--accent mdl-color-text--accent-contrast mdl-js-ripple-effect margin-top">
                              Procure seu voo
                            </button>
                        </form>
                    </div>
                </div>
            </section>
            <section id="ofertasPassagens">
                <div class="" style="height: 1400px;">
                <div class="android-screen-section mdl-typography--text-center GoBystrok-spacer"></div>
                <div class="mdl-typography--display-1-color-contrast mdl-typography--text-center GoBystrok-title-section GoBystrok-title">Ofertas Imperd�veis!</div>
                    <% ArrayList<Modelo.Voo> vs = (ArrayList<Modelo.Voo> ) request.getAttribute("voosDaSemana");
                    %>
                    <!-- SECTION OFERTAS - ROW  -->
                    <div class="mdl-grid layout-center padding-sale">  
                    <% if(vs != null){
                        for (Modelo.Voo v: vs){%>  
                            <div class="mdl-cell mdl-cell--4-col margin-negative">
                                <div class="demo-card-square mdl-card mdl-shadow--2dp">
                                <div class="mdl-card__title mdl-card--expand">
                                    <h2 class="mdl-card__title-text"><%=v.getDestino()%></h2>
                                </div>
                                <div style="font-size: 14px;" class="mdl-card__supporting-text">
                                    <%="A partir de R$ <strong>"+v.getValorFormat()+"</strong> � vista"%>
                                </div>
                                <div class="mdl-card__actions mdl-card--border">
                                    <a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
                                      Comprar
                                    </a>
                                </div>
                            </div>                    
                        </div>
                    <%}}%>

                    </div> <!-- ./END SECTION OFERTAS - ROW 1 -->
                </div>
                <div class="android-customized-section-image">
                    <div class="layout-center">
                        <div style="left: 430px;" class="logo-font GoBystrok-title GoBystrok-slogan">Voos da semana</div>
                        <div class="GoBystrok-fab padding-form">
                            <div class="center-items">
                                <% ArrayList<Modelo.Voo> v = (ArrayList<Modelo.Voo> ) request.getAttribute("voos");%>
                                <table style="left: 70px;"class="mdl-data-table mdl-js-data-table mdl-shadow--2dp ">
                                    <thead>
                                        <tr>
                                            <%if(v == null || v.isEmpty()){%> <th>Voo</th><%}
                                            else{%> <th class="mdl-data-table__cell--non-numeric">Voo</th><%}%>
                                            <th>Origem</th>
                                            <th>Destino</th>
                                            <th>Data</th>
                                            <th>Hora</th>
                                            <th>Executivo</th>
                                            <th>Econ�mico</th>
                                            <th>Valor</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <%if(v != null && !v.isEmpty()){
                                            for (Modelo.Voo aux: v){%>
                                                <tr>
                                                    <td><%=aux.getNumero()%></td>
                                                    <td><%=aux.getOrigem()%></td>
                                                    <td><%=aux.getDestino()%></td>
                                                    <td><%=aux.getProgramacao().getDataSaida()%></td>
                                                    <td><%=aux.getProgramacao().getHoraSaida()%></td>
                                                    <td><%=aux.getProgramacao().getQuantidadeExec()%></td>
                                                    <td><%=aux.getProgramacao().getQuantidadeEcon()%></td>
                                                    <td><%="R$ " + aux.getValorFormat()%></td>
                                                </tr>
                                          <%}
                                        }
                                        else{%>
                                            <tr>
                                                <td colspan="8">N�o h� Voos esta Semana</td>
                                            </tr> 
                                        <%}%>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
<jsp:include page="layout/footer.jsp"/>  

