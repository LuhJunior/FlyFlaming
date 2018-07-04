<%-- 
    Document   : autenticacaoPagina
    Created on : 01/06/2018, 12:57:56
    Author     : hspacheco
--%>

<%@page import="Modelo.Tools"%>
<% if(session.getAttribute("clienteAutenticado") == null) { 
    request.setAttribute("Erro", "Login Necessário!");
    request.getSession().setAttribute("URL", Tools.converterURL(request.getRequestURL().toString()));
     %>
    <jsp:forward page="login.jsp" /> 
<% }%>