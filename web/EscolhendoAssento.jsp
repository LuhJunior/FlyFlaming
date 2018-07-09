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
        <div class="android-be-together-section" style="height: 1300px;">
            <% Modelo.Voo v = (Modelo.Voo)request.getAttribute("Voo");
                ArrayList<Modelo.Assento> a = (ArrayList<Modelo.Assento>)request.getAttribute("Assentos");
                Modelo.Passagem p = (Modelo.Passagem) request.getAttribute("Passagem");
            %>
            <div  class="formulario color-orange" style="right: 25%; left: 25%; top: 3%; height: <%=400+40*(v.getAviao().getFileiras())%>px;">    
                <div style="position:relative;" class="mdl-grid center-items" style="top: 10%; right: 20%; left: 20%">
                    <div class="logo-font GoBystrok-title GoBystrok-slogan">Selecione o Assento</div>
                    <form name="formAssento" method="POST" action="AssentoEscolhido">
                        <% if(p != null){%>
                            <input type="hidden" name="Codigo" value="<%=p.getCodigo()%>">
                        <%}%>
                        <input type="hidden" name="NumVoo" value="<%=v.getNumero()%>">
                        <div class="">
                            <div class="plane">
                                <div class="cockpit"></div>
                                <div class="exit exit--front fuselage"></div>
                                <ol class="cabin fuselage">
                                    <% if(v != null && a != null){
                                        for(int i=1; i<=v.getAviao().getFileiras(); i++){%>
                                            <li class="row row--<%=i+1%>">
                                                <ol class="seats" type="A">

                                            <%for(int j=1; j<=v.getAviao().getColunas(); j++){
                                                String letra = new String();
                                                letra = Integer.toString((char) j);
                                                letra += Character.toString((char) ('A'+(i-1)));
                                                Assento as = Assento.procurarAssentoArray(i, j, a);
                                                if(as != null){
                                                    if(as.getTipo().equals("Executivo")) letra = "E"+letra;
                                            %>

                                                <li class="seat">
                                                    <input style="display: none;" type="radio" class="test" name="Assento" value="<%=as.getNumero()%>" id="<%=letra%>" />
                                                    <label for="<%=letra%>"><%=letra%></label>
                                                </li>
                                                <%}
                                                else{%>
                                                    <li class="seat seatt">
                                                        <input style="display: none;" type="radio" disabled id="<%=letra%>" />
                                                        <label for="<%=letra%>">X</label>
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
<jsp:include page="layout/footer.jsp"/> 
