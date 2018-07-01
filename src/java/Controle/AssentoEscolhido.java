/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Assento;
import Modelo.Cliente;
import Modelo.Passagem;
import Modelo.Voo;
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
@WebServlet(name = "AssentoEscolhido", urlPatterns = {"/AssentoEscolhido"})
public class AssentoEscolhido extends HttpServlet {

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
        int NumVoo = Integer.parseInt(request.getParameter("NumVoo"));
        Voo v = new Voo();
        Passagem p = new Passagem();
        v.setNumero(NumVoo);
        v.pegarVoo();
        Assento a = new Assento();
        System.out.println(request.getParameter("Assento"));
        a.setNumero(Integer.parseInt(request.getParameter("Assento")));
        a.pegarAssento();
        if(request.getParameter("Codigo") == null){
            p.setAssento(a);
            p.setProgramacao(v.getProgramacao());
            p.setValor(v.getValor());
            System.out.println(p.getAssento().getNumero());
            if(p.inserirPassagem(c.getCpf())){
                request.setAttribute("Mensagem", "Passagem Comprada com Sucesso!");
                RequestDispatcher dispatcher = request.getRequestDispatcher("ExibirPassagens");
                
                dispatcher.forward(request, response);
            }
            else{
                request.setAttribute("Mensagem", "Ocorreu um erro!");
                RequestDispatcher dispatcher = request.getRequestDispatcher("ExibirPassagens");
                dispatcher.forward(request, response);
            }
        }
        else{
            p.setCodigo(Integer.parseInt(request.getParameter("Codigo")));
            p.buscarDados();
            p.setAssento(a);
            if(p.atualizaAssento()){
                request.setAttribute("Mensagem", "Assento Escolhido com Sucesso!");
                RequestDispatcher dispatcher = request.getRequestDispatcher("passagens.jsp");
                dispatcher.forward(request, response);
            }
            else{
                request.setAttribute("Mensagem", "Ocorreu um erro!");
                RequestDispatcher dispatcher = request.getRequestDispatcher("passagens.jsp");
                dispatcher.forward(request, response);
            }
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
