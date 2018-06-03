<%-- 
    Document   : checkin
    Created on : 21/05/2018, 22:10:57
    Author     : Diego Malta
--%>
<jsp:include page="autenticacaoPagina.jsp"/>
<jsp:include page="layout/header.jsp"/>   
    <jsp:include page="layout/navbarLogado.jsp"/>
    <div class="android-content mdl-layout__content">
        <div class="android-be-together-section">
            <div class="formulario color-orange"> 
              <div class="mdl-grid center-items color-orange">
                  <div class="logo-font GoBystrok-title GoBystrok-slogan">Opções de Passagem</div>
                  <form action="checkinOuCancelamento" method="POST" name="checkinForm" class="" onsubmit="return verificarCamposCheckin()">
                      <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label col-tam">
                          <h2 class="mdl-card__title-text color-white">Insira os dados:</h2>
                      </div>

                      <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label col-tam ">
                          <input class="mdl-textfield__input color-white" type="text" name="codPassagem" id="sample3">
                          <label class="mdl-textfield__label mdl-color-text--orange-50" for="sample3">Código da Passagem</label>
                      </div>

                      <div class="toolbar-section">
                          <button class="mdl-button mdl-js-button mdl-button--raised mdl-color--accent mdl-color-text--accent-contrast mdl-js-ripple-effect margin-top" type="submit" name="submit" value="checkin">Fazer Check-in</button>
                          <button class="mdl-button mdl-js-button mdl-button--raised mdl-color--accent mdl-color-text--accent-contrast mdl-js-ripple-effect margin-top" type="submit" name="submit" value="cancelar">Cancelar passagem</button>
                      </div>
                  </form>
              </div>
            </div>
        </div>
        <div class="mdl-grid center-items color-orange"></div>
    </div>
<jsp:include page="layout/footer.jsp"/> 