package Controle;

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
 * @author Júnior
 */
@WebServlet(name = "CheckarCancelar", urlPatterns = {"/CheckarCancelar"})
public class CheckarCancelar extends HttpServlet {

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
        String selected = request.getParameter("submit");
        String tipo = selected.substring(0, 7);
        System.out.println(tipo);
        Passagem p = new Passagem();
        if(tipo.equals("checkin")){
            int row = Integer.parseInt(selected.substring(8));
            System.out.println(row);
            p.setCodigo(Integer.parseInt(request.getParameterValues("codPassagem[]")[row]));
            System.out.println(p.getCodigo());
            if(p.buscarDados() && p.checkin()){
                request.setAttribute("Mensagem", "Checkin efetuado com sucesso!");
                System.out.println("Que não vai dá pai");
            }   
            else{
                request.setAttribute("Erro", "Ocorreu um erro");
                System.out.println("Não vai dá não");
            }
        }
        else{
            int row = Integer.parseInt(selected.substring(9));
            p.setCodigo(Integer.parseInt(request.getParameterValues("codPassagem[]")[row]));
            if(p.buscarDados() && p.cancelar() && p.estornarValorPassagem()){
                float valor = p.getValor();
                p.buscarDados();
                valor = valor - p.getValor();
                request.setAttribute("Mensagem", "Cancelamento efetuado com sucesso! Valor Estornado: R$"+valor);
                System.out.println("Que não vai dá pai");
            }
            else{
                request.setAttribute("Erro", "Ocorreu um erro");
                System.out.println("Não vai dá não");
            }
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("OpcoesPassagem");
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
