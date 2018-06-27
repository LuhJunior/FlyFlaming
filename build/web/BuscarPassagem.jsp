<%-- 
    Document   : index
    Created on : 21/05/2018, 21:30:37
    Author     : Diego Malta
--%>

<jsp:include page="layout/header.jsp"/>
<jsp:include page="layout/navbarDinamicaIndex.jsp"/>
<div class="android-content mdl-layout__content">
    <section id="pesquisarPassagem">
        <div class="android-customized-section">
            <div class="android-customized-section-image">
                <div style="padding-top: 20px;" class="logo-font GoBystrok-title GoBystrok-slogan">Passagens Disponíveis</div>
                <div class="GoBystrok-fab padding-form">
                    <div class="center-items">
                    <table class="mdl-data-table mdl-js-data-table mdl-shadow--2dp ">
                        <thead>
                            <tr>
                                <th class="mdl-data-table__cell--non-numeric">Voo</th>
                                <th>Origem</th>
                                <th>Destino</th>
                                <th>Data</th>
                                <th>Hora</th>
                                <th>Executivo</th>
                                <th>Econômico</th>
                                <th>Valor</th>
                            </tr>
                        </thead>
                        <tbody>
                            <form name="passagemEscolhida" method="POST" action="/FlyFlaming/EscolhendoAcento">
                                <tr>
                                    <td class="mdl-data-table__cell--non-numeric"> </td>
                                    <td>235</td>
                                    <td>teste</td>
                                    <td>teste</td>
                                    <td>teste</td>
                                    <td>teste</td>
                                    <td>teste</td>
                                    <td>teste</td>
                                    <td>
                                        <button class="mdl-button mdl-js-button mdl-button--raised mdl-color--accent mdl-color-text--accent-contrast mdl-js-ripple-effect" 
                                        type="submit" 
                                        name="comprar"
                                        value="comprar"><i class="material-icons">
                                            add_shopping_cart
                                        </i>
                                        </button>
                                    </td>
                                </tr>
                            </form>
                        </tbody>
                    </table>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>
</div>
<jsp:include page="layout/footer.jsp"/>  
