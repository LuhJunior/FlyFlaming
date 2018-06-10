<%-- 
    Document   : navbarDinamica
    Created on : 01/06/2018, 14:55:21
    Author     : hspacheco
--%>

<%if(session.getAttribute("clienteAutenticado") != null) { %>
    <jsp:include page="navbarLogado.jsp"/> 
<%} else{%>
    <jsp:include page="navbar.jsp"/> 
<%}%>