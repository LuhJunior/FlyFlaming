<%-- 
    Document   : navbarDinamicaIndex
    Created on : 10/06/2018, 02:37:55
    Author     : Júnior
--%>

<%if(session.getAttribute("clienteAutenticado") != null) { %>
    <jsp:include page="navbarIndexLogado.jsp"/> 
<%} else{%>
    <jsp:include page="navbarIndex.jsp"/> 
<%}%>
