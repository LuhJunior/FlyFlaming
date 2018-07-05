<%-- 
    Document   : footer
    Created on : 21/05/2018, 21:34:46
    Author     : Diego Malta
--%>    
            
        <footer class="mdl-mini-footer">
          <div class="mdl-mini-footer__left-section">
            <ul class="mdl-mini-footer__link-list">
              <li><a href="#">COPYRIGHT © 2017 FLYFLAMING</a></li>
              <li><a href="#">Help</a></li>
              <li><a href="#">Privacy & Terms</a></li>
            </ul>
          </div>
        </footer>
    </div>
    </div>
    <% String Mensagem = (String) request.getAttribute("Mensagem");
    String Erro = (String) request.getAttribute("Erro");
    if(Mensagem != null){%>
    <script>ShowMensagemSucesso("<%=Mensagem%>");</script>
    <%}
        if(Erro != null){%>
        <script>ShowMensagemErro("<%=Erro%>");</script>
    <%}%>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://code.getmdl.io/1.3.0/material.min.js"></script>
    <script type="text/javascript" src="vendor/GoBystrok.js"></script>
  </body>
</html>