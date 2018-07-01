<%-- 
    Document   : index
    Created on : 21/05/2018, 21:30:37
    Author     : Diego Malta
--%>

<%@page import="Modelo.Assento"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="layout/header.jsp"/>
<jsp:include page="layout/navbarDinamica.jsp"/>
<div class="android-content mdl-layout__content">
    <section id="pesquisarPassagem">
        <div class="android-customized-section">
            <div class="android-customized-section-image">
                <div style="padding-top: 20px;" class="logo-font GoBystrok-title GoBystrok-slogan">Selecione o Assento</div>
                <div style="padding-top: 20px;" class="logo-font GoBystrok-title GoBystrok-slogan"class="GoBystrok-fab padding-form">
                    <form name="formAssento" method="POST" action="AssentoEscolhido">
                        <% Modelo.Voo v = (Modelo.Voo)request.getAttribute("Voo");
                            ArrayList<Modelo.Assento> a = (ArrayList<Modelo.Assento>)request.getAttribute("Assentos");
                            Modelo.Passagem p = (Modelo.Passagem) request.getAttribute("Passagem");
                            if(p != null){
                        %>
                                <input type="hidden" name="Codigo" value="<%=p.getCodigo()%>">
                            <%}%>
                        <input type="hidden" name="NumVoo" value="<%=v.getNumero()%>">
                    <div class="formulario color-orange">
                        <div class="plane color-orange">
                            <div class="cockpit"></div>
                            <div class="exit exit--front fuselage">
                            </div>
                            <ol class="cabin fuselage">
                            <% if(v != null && a != null){
                                    for(int i=1; i<=v.getAviao().getFileiras(); i++){%>
                                        <li class="row row--<%=i%>">
                                            <ol class="seats" type="A">
                                    
                                    <%for(int j=1; j<=v.getAviao().getColunas(); j++){
                                        String letra = new String();
                                        letra = Character.toString((char) j);
                                        letra += Character.toString((char) ('A'+(j-1)));
                                        Assento as = Assento.procurarAssentoArray(i, j, a);
                                        if(as != null){
                                    %>
                                        
                                        <li class="seat">
                                            <input type="checkbox" name="Assento" value="<%=as.getNumero()%>" id="<%=letra%>" />
                                            <label for="<%=letra%>"><%=letra%></label>
                                        </li>
                                        <%}
                                        else{%>
                                            <li class="seat">
                                                <input type="checkbox" disabled id="<%=letra%>" />
                                                <label for="<%=letra%>">Occupied</label>
                                            </li>
                                        <%}%>
                                    <%}%>
                                  
                                        </ol>
                                      </li>
                                    <%}%>
                                <%}%>
                            </ol>
                            <div class="exit exit--back fuselage"></div>  
                            <button class="mdl-button mdl-js-button mdl-button--raised mdl-color--accent mdl-color-text--accent-contrast mdl-js-ripple-effect margin-top" 
                                type="submit" 
                                name="entrar"
                                value="Entrar">Continuar
                            </button>
                        </div>   
                    </div>       
                        </form>
                </div>
            </div>                  
        </div>
    </section>
</div>            
<jsp:include page="layout/footer.jsp"/> 
