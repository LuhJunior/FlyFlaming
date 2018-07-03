package Controle;

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
@WebServlet(name = "Perfil", urlPatterns = {"/Perfil"})
public class Perfil extends HttpServlet {

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
        Modelo.Cliente c = (Modelo.Cliente)request.getSession().getAttribute("clienteAutenticado");
        if(c != null){
            String Mensagem = (String) request.getAttribute("Mensagem");
            String Erro = (String) request.getAttribute("Erro");
            request.setAttribute("Erro", Erro);
            request.setAttribute("Mensagem", Mensagem);
            if(c.getFromDb()){
                request.setAttribute("cliente", c);
                RequestDispatcher dispacher = request.getRequestDispatcher("perfil.jsp");
                dispacher.forward(request, response);
            }
            else{
                request.setAttribute("Erro", "ocorreu um erro ao procurar os dados cliente");
                RequestDispatcher dispacher = request.getRequestDispatcher("index");
                dispacher.forward(request, response);
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
