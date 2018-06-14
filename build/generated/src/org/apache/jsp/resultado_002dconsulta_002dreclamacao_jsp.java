package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class resultado_002dconsulta_002dreclamacao_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "autenticarPagina.jsp", out, false);
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "layout/header.jsp", out, false);
      out.write("    \r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "layout/navbarLogado.jsp", out, false);
      out.write("\r\n");
      out.write("    <div class=\"android-content mdl-layout__content\">\r\n");
      out.write("        <div class=\"android-be-together-section\">\r\n");
      out.write("            <div class=\"formulario color-orange\">     \r\n");
      out.write("                <div class=\"mdl-grid center-items color-orange\" style=\"left: 10%;right: 10%;\">\r\n");
      out.write("                    <div class=\"logo-font GoBystrok-title GoBystrok-slogan\">Reclamações</div>\r\n");
      out.write("                    ");
 Modelo.Passagem[] p = (Modelo.Passagem[]) request.getAttribute("passagens"); 
      out.write("\r\n");
      out.write("                    <div class=\"center-items\">\r\n");
      out.write("                    <form action=\"UDReclamacao\" method=\"post\" name=\"UDReclamacaoForm\" onsubmit=\"\">\r\n");
      out.write("                        <table style=\"margin-top: 20px;\" class=\"mdl-data-table mdl-shadow--2dp\">\r\n");
      out.write("                            <thead>\r\n");
      out.write("                                <tr>\r\n");
      out.write("                                    <th class=\"mdl-data-table__cell--non-numeric\">Código da Passagem</th>\r\n");
      out.write("                                    <th>Descrição</th>\r\n");
      out.write("                                    <th>Situação</th>\r\n");
      out.write("                                    <th>Opções</th>\r\n");
      out.write("                                </tr>\r\n");
      out.write("                            </thead>\r\n");
      out.write("                            <tbody>\r\n");
      out.write("                                ");
if(p != null){ 
                                    for(int i=0; i<p.length; i++){
                                
      out.write("\r\n");
      out.write("                                    <tr>\r\n");
      out.write("                                        ");

                                            String situacao;
                                            if(p[i].getReclamacao().getEstado() == 'A') situacao = "Aberto";
                                            else situacao = "Resolvido";
                                        
      out.write("\r\n");
      out.write("                                        <td name=\"codPassagem[]\" value=\"");
      out.print(p[i].getCodigo());
      out.write("\" class=\"mdl-data-table__cell--non-numeric\">");
      out.print(p[i].getCodigo());
      out.write("</td>\r\n");
      out.write("                                        <td name=\"codReclamacao[]\" value=\"");
      out.print(p[i].getReclamacao().getDescricao());
      out.write("\" class=\"mdl-data-table__cell--non-numeric\">");
      out.print(p[i].getReclamacao().getDescricao());
      out.write("</td>\r\n");
      out.write("                                        <td name=\"codReclamacao[]\" value=\"");
      out.print(situacao);
      out.write("\" class=\"mdl-data-table__cell--non-numeric\">");
      out.print(situacao);
      out.write("</td>\r\n");
      out.write("                                        <td>\r\n");
      out.write("                                            <button type=\"submit\" value=\"Editar-");
      out.print(i);
      out.write("\" class=\"mdl-button mdl-js-button mdl-button--raised mdl-color--accent mdl-color-text--accent-contrast mdl-js-ripple-effect\">Editar</button>\r\n");
      out.write("                                            <button type=\"submit\" value=\"Excluir-");
      out.print(i);
      out.write("\" class=\"mdl-button mdl-js-button mdl-button--raised mdl-color--accent mdl-color-text--accent-contrast mdl-js-ripple-effect\">Excluir</button>\r\n");
      out.write("                                        </td>   \r\n");
      out.write("                                    </tr>\r\n");
      out.write("                                    ");
}
                                }else{
      out.write("\r\n");
      out.write("                                    <script>alert(\"Não existe passagens com reclamação\");</script>\r\n");
      out.write("                                ");
}
      out.write("\r\n");
      out.write("                            </tbody>\r\n");
      out.write("                        </table>\r\n");
      out.write("                    </form>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div>\r\n");
      out.write("                        <a href=\"reclamacao.jsp\">\r\n");
      out.write("                        <button class=\"mdl-button mdl-js-button mdl-button--raised mdl-color--accent mdl-color-text--accent-contrast mdl-js-ripple-effect\" type=\"submit\" name=\"submit\">Voltar</button>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "layout/footer.jsp", out, false);
      out.write(' ');
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
