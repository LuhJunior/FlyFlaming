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
        ArrayList<Voo> v = VooDAO.pesquisarVooPelaDataOrigemDestino(Origem, Destino, DataIda), v2 = null;
        if(Escolha.equals("IdaeVolta")){
            v2 = VooDAO.pesquisarVooPelaDataOrigemDestino(Destino, Origem, DataVolta);
            if(!v2.isEmpty()){
                request.getSession().setAttribute("Origem", Destino);
                request.getSession().setAttribute("Destino", Origem);
                request.getSession().setAttribute("dateVolta", DataVolta);
                request.getSession().setAttribute("Volta", true);
            }
            else{
                request.getSession().setAttribute("Volta", false);
                request.setAttribute("Erro", "Não existe voos de volta cadastrados para as opções escolhidas");
            }
        }
        else{
            request.getSession().setAttribute("Volta", false);
        }
        request.setAttribute("Voos", v);
        request.setAttribute("Voos2", v2);
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
