<%-- 
    Document   : autenticacaoPagina
    Created on : 01/06/2018, 12:57:56
    Author     : hspacheco
--%>

<% if(session.getAttribute("clienteAutenticado") == null) { %>
    <jsp:forward page="loginExigido.jsp" /> 
<% }%>