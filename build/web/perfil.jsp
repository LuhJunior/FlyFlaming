<%-- 
    Document   : perfil
    Created on : 10/06/2018, 12:14:18
    Author     : Júnior
--%>

<jsp:include page="autenticarPagina.jsp"/>
<jsp:include page="layout/header.jsp"/>    
    <jsp:include page="layout/navbarLogado.jsp"/>
    <div class="android-content mdl-layout__content">
        <div class="android-be-together-section">
            <div class="formulario-cadastro color-orange"> 
                <div class="mdl-grid center-items color-orange">
                    <% Modelo.Cliente c = (Modelo.Cliente)request.getAttribute("cliente");
                        String men = (String)request.getAttribute("Mensagem");
                        String men2 = (String)request.getAttribute("Mensagem2");
                        if(c == null) {
                            c = new Modelo.Cliente();
                        }
                        if(men != null){
                    %><script>alert("<%=men%>")</script> <%
                        }
                        if(men2 != null){
                    %><script>alert("<%=men2%>")</script> <%
                        }
                        if(c.getTelefone() == null) c.setTelefone("");
                        if(c.getEndereco() == null) c.setEndereco(new Modelo.Endereco());
                    %>
                    <div class="logo-font GoBystrok-title GoBystrok-slogan">Perfil</div>
                    
                        <table style="margin-top: 100px;" class="mdl-data-table mdl-shadow--2dp">
                            <tr>
                                <td>Dados Pessoais</td>
                            </tr>
                            <tr>
                                <td>Nome:</td>
                                <td><%=c.getNome()%></td>
                            </tr>
                            <tr>
                                <td>CPF:</td>
                                <td><%=c.getCpf()%></td>
                            </tr>
                            <tr>
                                <td>E-Mail:</td>
                                <td><%=c.getEmail()%></td>
                            </tr>
                            <tr>
                                <td>Telefone:</td>
                                <td><%=c.getTelefone()%></td>
                            </tr>
                            <tr>
                                <td>Endereço</td>
                            </tr>
                            <tr>
                                <td>Rua:</td>
                                <td><%=c.getEndereco().getRua()%></td>
                            </tr>  
                            <tr>
                                <td>Bairro:</td>
                                <td><%=c.getEndereco().getBairro()%></td>
                            </tr>  
                            <tr>
                                <td>Cidade:</td>
                                <td><%=c.getEndereco().getCidade()%></td>     
                            </tr>
                            <tr>
                                <td>Estado:</td>
                                <td><%=c.getEndereco().getEstado()%></td>
                            </tr>
                            <tr>
                                <td>CEP:</td>
                                <td><%=c.getEndereco().getCEP()%></td>
                            <tr>
                        </table>
                        <div class="toolbar-section">
                            <a href="updateCliente"> <button class="mdl-button mdl-js-button mdl-button--raised mdl-color--accent mdl-color-text--accent-contrast mdl-js-ripple-effect margin-top">Alterar Dados</button></a>
                        </div>
                </div>
            </div>
        </div>
    <div class="android-screen-section mdl-typography--text-center GoBystrok-spacer"></div>
    <div class="android-screen-section mdl-typography--text-center GoBystrok-spacer"></div>
    <div class="mdl-grid center-items color-orange"></div>
<jsp:include page="layout/footer.jsp"/> 
