package Controle;

import Modelo.Cliente;
import Modelo.Endereco;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Júnior
 */
@WebServlet(name = "UpdateDadosCliente", urlPatterns = {"/UpdateDadosCliente"})
public class UpdateDadosCliente extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cliente c = new Cliente();
        if(request.getSession().getAttribute("clienteAutenticado") != null){
            c.setNome(request.getParameter("Nome"));
            c.setCpf(((Cliente)request.getSession().getAttribute("clienteAutenticado")).getCpf());
            c.setEmail(request.getParameter("Email"));
            c.setTelefone(request.getParameter("Telefone"));
            c.setEndereco(new Endereco());
            c.getEndereco().setRua(request.getParameter("Rua"));
            c.getEndereco().setBairro(request.getParameter("Bairro"));
            c.getEndereco().setCidade(request.getParameter("Cidade"));
            c.getEndereco().setEstado(request.getParameter("Estado"));
            c.getEndereco().setCEP(request.getParameter("CEP"));
            if(c.atualizarDados()){
                request.setAttribute("Mensagem", "Alteração efetuada com sucesso!");
                RequestDispatcher dispatcher = request.getRequestDispatcher("Perfil");
                dispatcher.forward(request, response);
            }
            else{
                request.setAttribute("Erro", "Ocorreu um erro");
                RequestDispatcher dispatcher = request.getRequestDispatcher("Perfil");
                dispatcher.forward(request, response);
            }
        }
        else{
            request.setAttribute("Erro", "Login necessário");
            RequestDispatcher dispacher = request.getRequestDispatcher("login.jsp");
            dispacher.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
