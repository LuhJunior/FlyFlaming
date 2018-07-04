/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Assento;
import Modelo.Cliente;
import Modelo.Voo;
import Modelo.Cliente;
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
@WebServlet(name = "ComprarPassagem", urlPatterns = {"/ComprarPassagem"})
public class ComprarPassagem extends HttpServlet {

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
        Cliente c = (Cliente) request.getSession().getAttribute("clienteAutenticado");
        String num = request.getParameter("Comprar");
        int NumVoo;
        if(num != null){
            NumVoo = Integer.parseInt(request.getParameter("NumVoo["+num+"]"));
        }
        else{
            num = request.getParameter("Comprar2");
            NumVoo = Integer.parseInt(request.getParameter("NumVoo["+num+"]"));
        }
        Voo v = new Voo();
        v.setNumero(NumVoo);
        v.pegarVoo();
        v.getAviao().pegarAeronave();
        if(c != null){    
            request.setAttribute("Voo", v);
            request.setAttribute("Assentos", Assento.pegarAssentosAeronave(v.getAviao().getPrefixo(), v.getNumero()));
            RequestDispatcher dispatcher = request.getRequestDispatcher("EscolhendoAssento.jsp");
            dispatcher.forward(request, response);
        }
        else{
            request.setAttribute("Erro", "Login Nescessário");
            request.getSession().setAttribute("URL", "EscolhendoAssento.jsp");
            request.getSession().setAttribute("Voo", v);
            request.getSession().setAttribute("Assentos", Assento.pegarAssentosAeronave(v.getAviao().getPrefixo(), v.getNumero()));
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
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
