package Controle;

import Banco.VooDAO;
import Modelo.Passagem;
import Modelo.Voo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "VoosVolta", urlPatterns = {"/VoosVolta"})
public class VoosVolta extends HttpServlet {

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
        String Origem = (String) request.getSession().getAttribute("Origem");
        String Destino = (String) request.getSession().getAttribute("Destino");
        String DataVolta = (String) request.getSession().getAttribute("dateVolta");
        request.getSession().removeAttribute("Origem");
        request.getSession().removeAttribute("Destino");
        request.getSession().removeAttribute("dateVolta");
        Passagem p = (Passagem) request.getSession().getAttribute("Passagem");
        request.getSession().removeAttribute("Passagem");
        request.getSession().setAttribute("PassagemIda", p);
        ArrayList<Voo> v = VooDAO.pesquisarVooPelaDataOrigemDestino(Origem, Destino, DataVolta);
        request.setAttribute("Voos", v);
        RequestDispatcher dispatcher = request.getRequestDispatcher("voosVolta.jsp");
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
