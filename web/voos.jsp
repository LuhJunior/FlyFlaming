<%-- 
    Document   : voos
    Created on : 21/05/2018, 22:04:36
    Author     : Diego Malta
--%>

<jsp:include page="layout/header.jsp"/>    
    <jsp:include page="layout/navbar.jsp"/>
<div class="android-content mdl-layout__content">
    <div class="android-be-together-section">
        <div  class="formulario color-orange ">     
            <div style="position: absolute;" class="mdl-grid center-items color-orange">
                    <div class="logo-font GoBystrok-title GoBystrok-slogan">Opções de Voos</div>
                    <table style="margin-top: 20px;" class="mdl-data-table mdl-js-data-table mdl-data-table--selectable mdl-shadow--2dp ">
                        <thead>
                            <tr>
                                <th class="mdl-data-table__cell--non-numeric">Voo</th>
                                <th>Destino</th>
                                <th>Data</th>
                                <th>Hora</th>
                                <th>Executivo</th>
                                <th>Econômico</th>
                                <th>Valor</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td class="mdl-data-table__cell--non-numeric">242</td>
                                <td>São Paulo</td>
                                <td>15/04/2018</td>
                                <td>08:25</td>
                                <td>20</td>
                                <td>36</td>
                                <td>R$ 749,65</td>
                            </tr>
                        </tbody>
                    </table>
                    <button style="margin-top: 40px;" class="mdl-button mdl-js-button mdl-button--raised mdl-color--accent mdl-color-text--accent-contrast mdl-js-ripple-effect mdl-button--mini-fab">
                        Avançar
                    </button>
                    <button style="margin-top: 40px; margin-left: 15px;" class="mdl-button mdl-js-button mdl-button--raised mdl-color--accent mdl-color-text--accent-contrast mdl-js-ripple-effect mdl-button--mini-fab">
                        Voltar
                    </button>
            </div>

        </div>
    </div>
    <div class="android-screen-section mdl-typography--text-center GoBystrok-spacer color-orange"></div>
    <div class="mdl-grid center-items color-orange"></div>
<jsp:include page="layout/footer.jsp"/> 