/* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hspacheco
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if(request.getParameter("recuperar") != null ) {
            request.getRequestDispatcher("esqueci-senha.jsp").forward(request, response);
        }
        
        System.out.println((char)(('A'+1)));
        String cpf = (String) request.getParameter("CPF");    
        String senha = (String) request.getParameter("Senha");
        
           
        Cliente c = new Cliente();
        c.setCpf(cpf);
        c.setSenha(senha);
        
        HttpSession session = request.getSession();        
        
        if(c.validarCliente()) {

            System.out.println("Cliente valido"); 
            session.setAttribute("clienteAutenticado", c.autenticarCliente());
            response.sendRedirect("index");
            //request.getRequestDispatcher("reclamacao.jsp").forward(request, response);
            
        } else {
            System.out.println("nao valido");  
            response.sendRedirect("login.jsp");
            //request.getRequestDispatcher("login.jsp").forward(request, response);
            
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
