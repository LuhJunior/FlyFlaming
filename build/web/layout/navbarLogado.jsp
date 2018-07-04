<%-- 
    Document   : navbar
    Author     : hspacheco
--%>

<body>
    <div class="mdl-layout mdl-js-layout mdl-layout--fixed-header ">
        <div class="mdl-layout__header mdl-layout__header--waterfall GoBystrok-navbar">
            <div aria-expanded="false" role="button" tabindex="0" class="mdl-layout__drawer-button GoBystrok-navbar"><i class="material-icons">menu</i></div>
            <div class="mdl-layout__header-row">
              <span class="android-title mdl-layout-title GoBystrok-brand ">
                FlyFlaming
              </span>
              <!-- Add spacer, to align navigation to the right in desktop -->
              <div class="android-header-spacer mdl-layout-spacer"></div>
              
              <!-- Navigation -->
              <div class="android-navigation-container">
                <nav class="android-navigation mdl-navigation GoBystrok-navigation-color">
                    <a class="mdl-navigation__link" href="index">HOME</a>
                    <a class="mdl-navigation__link mdl-typography--text-uppercase" href="OpcoesPassagem">Passagem</a>
                    <a class="mdl-navigation__link mdl-typography--text-uppercase" href="reclamacao.jsp">Reclama��o</a>
                    <% Modelo.Cliente cliente = (Modelo.Cliente) session.getAttribute("clienteAutenticado"); %>
                    <a style="margin-top: 8px;" class="mdl-typography--text-uppercase">Ol�, <%=cliente.getOneNome()%></a> 
                    <a style="padding-left: 8px;" href="FinalizarSessao">
                      <button class="mdl-button mdl-js-button mdl-button--raised mdl-color--accent mdl-color-text--accent-contrast mdl-js-ripple-effect mdl-button--mini-fab">
                        Sair
                      </button>
                    </a>
                </nav>
              </div>
              <span class="android-mobile-title mdl-layout-title GoBystrok-brand">
                  FlyFlaming
              </span>
            </div>
          </div>

          <div class="android-drawer mdl-layout__drawer ">
            <span class="mdl-layout-title GoBystrok-navbar-right GoBystrok-brand">
                FlyFlaming
            </span>
            <nav class="mdl-navigation">
              <!--  <a class="mdl-navigation__link" href="ExibirPassagens">Exibir Passagens</a>-->
              <a class="mdl-navigation__link" href="OpcoesPassagem">Op��es de Passagem</a>
              <a class="mdl-navigation__link" href="ConsultarReclamacao">Acompanhar Reclama��o</a>
              <a class="mdl-navigation__link" href="trocar-senha.jsp">Trocar Senha</a>                                                      
              <div class="android-drawer-separator"></div>
              <span class="mdl-navigation__link" href="">Usu�rio</span>
              <a class="mdl-navigation__link" href="Perfil">Perfil</a>
            </nav>
          </div>