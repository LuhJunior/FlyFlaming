package Controle;

import Modelo.Pagamento;
import Modelo.Passagem;
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
 * @author Junior
 */
@WebServlet(name = "Pagar", urlPatterns = {"/Pagar"})
public class Pagar extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        Pagamento pg = new Pagamento();
        pg.setNumeroCartao(request.getParameter("numCard"));
        pg.setSenha(request.getParameter("Senha"));
        pg.setParcelas(Integer.parseInt(request.getParameter("Parcelas")));
        pg.setPassagem((Passagem) request.getSession().getAttribute("Passagem"));
        Passagem p = (Passagem) request.getSession().getAttribute("PassagemIda");
        RequestDispatcher dispatcher = null;
        if(pg.getPassagem().inserirPassagem(((Modelo.Cliente) request.getSession().getAttribute("clienteAutenticado")).getCpf())){
            System.out.println(pg.getPassagem().getHoraCompra());
            if(pg.pagarPassagem(((Modelo.Cliente)request.getSession().getAttribute("clienteAutenticado")).getCpf())){
                if(p != null){
                    request.getSession().removeAttribute("PassagemIda");
                    p.setCodigoVolta(pg.getPassagem().getCodigo());
                    if(p.inserirVooVolta()) request.setAttribute("Mensagem", "Compra efetuada com sucesso");
                    else request.setAttribute("Erro", "Ocorreu um erro");
                    dispatcher = request.getRequestDispatcher("index");
                }
                else{
                    boolean volta = (boolean) request.getSession().getAttribute("Volta");
                    if(volta) dispatcher = request.getRequestDispatcher("VoosVolta");
                    else dispatcher = request.getRequestDispatcher("index");
                    request.setAttribute("Mensagem", "Compra efetuada com sucesso");
                }
            }
            else{
                System.out.println("deu ruim");
                request.setAttribute("Erro", "Ocorreu um erro");
                dispatcher = request.getRequestDispatcher("index");
            }
        }
        else{
            System.out.println("deu ruim");
            request.setAttribute("Erro", "Ocorreu um erro");
            dispatcher = request.getRequestDispatcher("index");
        }
        dispatcher.forward(request, response);
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
