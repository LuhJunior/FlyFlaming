package Controle;

import Banco.VooDAO;
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
@WebServlet(name = "PesquisarVoo", urlPatterns = {"/PesquisarVoo"})
public class PesquisarVoo extends HttpServlet {

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
        String Origem = request.getParameter("Origem");
        String Destino = request.getParameter("Destino");
        String DataIda = request.getParameter("dateIda");
        String DataVolta = request.getParameter("dateVolta");
        String Escolha = request.getParameter("escolha");
        System.out.println(Escolha);
        System.out.println(Origem +'\n'+Destino);
        ArrayList<Voo> v = VooDAO.pesquisarVooPelaDataOrigemDestino(Origem, Destino, DataIda);
        request.setAttribute("Voos", v);
        if(v.isEmpty()) request.setAttribute("Mensagem", "Que não vai dá pai");
        else request.setAttribute("Mensagem", "Não vai dá não");
        RequestDispatcher dispatcher = request.getRequestDispatcher("voos.jsp");
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
