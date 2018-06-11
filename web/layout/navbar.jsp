<%-- 
    Document   : navbar
    Created on : 21/05/2018, 21:36:00
    Author     : Diego Malta
--%>
<body>
    <div class="mdl-layout mdl-js-layout mdl-layout--fixed-header ">
        <div class="mdl-layout__header mdl-layout__header--waterfall GoBystrok-navbar">
            <div aria-expanded="false" role="button" tabindex="0" class="mdl-layout__drawer-button GoBystrok-navbar"><i class="material-icons">+</i></div>
            <div class="mdl-layout__header-row">
              <span class="android-title mdl-layout-title GoBystrok-brand ">
                FlyFlaming
              </span>
              <!-- Add spacer, to align navigation to the right in desktop -->
              <div class="android-header-spacer mdl-layout-spacer"></div>
              <div class="android-search-box mdl-textfield mdl-js-textfield mdl-textfield--expandable mdl-textfield--floating-label mdl-textfield--align-right mdl-textfield--full-width">
                <label class="mdl-button mdl-js-button mdl-button--icon" for="search-field">
                  <i class="material-icons">search</i>
                </label>
                <div class="mdl-textfield__expandable-holder">
                  <input class="mdl-textfield__input" type="text" id="search-field">
                </div>
              </div>
              <!-- Navigation -->
              <div class="android-navigation-container">
                <nav class="android-navigation mdl-navigation GoBystrok-navigation-color">
                  <a class="mdl-navigation__link" href="index.jsp">HOME</a>
                  <a class="mdl-navigation__link mdl-typography--text-uppercase" href="opcoesPassagem">Passagem</a>
                  <a class="mdl-navigation__link mdl-typography--text-uppercase" href="reclamacao.jsp">RECLAMAÇÃO</a>
                  <a href="login.jsp">
                    <button class="mdl-button mdl-js-button mdl-button--raised mdl-color--accent mdl-color-text--accent-contrast mdl-js-ripple-effect mdl-button--mini-fab">
                      Entrar
                    </button>
                  </a>

                </nav>
              </div>
              <span class="android-mobile-title mdl-layout-title GoBystrok-brand">
                  FlyFlaming
              </span>
              <button class="android-more-button mdl-button mdl-js-button mdl-button--icon mdl-js-ripple-effect" id="more-button">
                <i class="material-icons">more_vert</i>
              </button>
              <ul class="mdl-menu mdl-js-menu mdl-menu--bottom-right mdl-js-ripple-effect" for="more-button">
                <li class="mdl-menu__item">Facebook</li>
                <li class="mdl-menu__item">Twitter</li>
                <li class="mdl-menu__item">Instagram</li>
              </ul>
            </div>
          </div>

          <div class="android-drawer mdl-layout__drawer ">
            <span class="mdl-layout-title GoBystrok-navbar-right GoBystrok-brand">
                FlyFlaming
            </span>
            <nav class="mdl-navigation">
              <a class="mdl-navigation__link" href="opcoesPassagem">Opções de Passagem</a>
              <a class="mdl-navigation__link" href="consulta-reclamacao.jsp">Acompanhar Reclamação</a> 
              <div class="android-drawer-separator"></div>
              <span class="mdl-navigation__link" href="">Dúvidas</span>
              <a class="mdl-navigation__link" href="">Contato</a>                                                             
              <div class="android-drawer-separator"></div>
              <span class="mdl-navigation__link" href="">Usuário</span>
              <a class="mdl-navigation__link" href="signin.jsp">Cadastre-se</a>
            </nav>
          </div>