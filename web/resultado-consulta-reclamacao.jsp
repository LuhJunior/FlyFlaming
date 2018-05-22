<%-- 
    Document   : resultado-consulta-reclamacao
    Created on : 21/05/2018, 22:00:30
    Author     : Diego Malta
--%>

<jsp:include page="layout/header.jsp"/>    
    <jsp:include page="layout/navbar.jsp"/>
    <div class="android-content mdl-layout__content">
        <div class="android-be-together-section">
            <div class="formulario color-orange">     
                <div class="mdl-grid center-items color-orange">
                    <div class="logo-font GoBystrok-title GoBystrok-slogan">Reclama��es</div>
                        <table style="margin-top: 20px;" class="mdl-data-table mdl-js-data-table mdl-shadow--2dp ">
                            <thead>
                                <tr>
                                    <th class="mdl-data-table__cell--non-numeric">C�digo da Reclama��o</th>
                                    <th>Descri��o</th>
                                    <th>Situa��o</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td class="mdl-data-table__cell--non-numeric">1935</td>
                                    <td>Bagagem danificada</td>
                                    <td>Em resolu��o</td>
                                </tr>
                                <tr>
                                    <td class="mdl-data-table__cell--non-numeric">2169</td>
                                    <td>Bagagem extraviada</td>
                                    <td>Resolvido</td>
                                </tr>
                            </tbody>
                        </table>
                    <div class="toolbar-section">
                        <button class="mdl-button mdl-js-button mdl-button--raised mdl-color--accent mdl-color-text--accent-contrast mdl-js-ripple-effect margin-top" type="submit" name="submit">Voltar</button>
                    </div>
                </div>
            </div>
        </div>

        <div class="mdl-grid center-items color-orange"></div>
<jsp:include page="layout/footer.jsp"/> 