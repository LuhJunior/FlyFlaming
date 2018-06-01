package Banco;

import Modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO {
    public boolean inserir(Cliente c){
        int r = 0;
        try{
            String sql = "";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }  
        finally{
            return (r>0);
        }
    }
    
    public boolean update(Cliente c){
        int r = 0;
        try{
            String sql = "";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            ConnectionFactory.closeConnection(conn, p, rs);
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }  
        finally{
            return (r>0);
        }
    }
    
    public void pesquisar(Cliente c){
        try{
            String sql = "SELECT * FROM CLIENTE WHERE CPF = ? AND SENHA = ? ";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            ConnectionFactory.closeConnection(conn, p, rs);
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }  
        
    }
    
    public Cliente pesquisarCpfSenha(Cliente c) {
        Cliente cli = new Cliente();
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement p = null;
        ResultSet rs = null;
        
        try {
            
            String sql = "SELECT * FROM CLIENTE WHERE CPF = ? AND SENHA = ? ";
            p = conn.prepareStatement(sql);
            p.setString(1, c.getCpf());
            p.setString(2, c.getSenha());
            
            rs = p.executeQuery();
            
            while(rs.next()) {
                cli.setNome(rs.getString("NOME"));
                cli.setCpf(rs.getString("CPF"));
                cli.setEmail(rs.getString("EMAIL"));
                cli.setSenha(rs.getString("SENHA"));
            }
     
            
        } catch(SQLException e) {
            
            throw new RuntimeException(e);
            
        } finally {
            
            ConnectionFactory.closeConnection(conn, p, rs);
            
        }
        
        return cli;
        
    }
    
    public boolean validarCliente(Cliente c) {
  
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement p = null;
        ResultSet rs = null;
        
        try {
            
            String sql = "SELECT * FROM CLIENTE WHERE CPF = ? AND SENHA = ? ";
            p = conn.prepareStatement(sql);
            p.setString(1, c.getCpf());
            p.setString(2, c.getSenha());
            
            rs = p.executeQuery();
            
            if(rs.next()) {
                return true;
            }
            
            
        } catch(SQLException e) {
            
            throw new RuntimeException(e);
            
        } finally {
            
            ConnectionFactory.closeConnection(conn, p, rs);
            
        }
        
        return false;
        
    }
    
    
    public boolean deletar(Cliente c){
        int r = 0;
        try{
            String sql = "";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            ConnectionFactory.closeConnection(conn, p, rs);
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }  
        finally{
            return (r>0);
        }
    }
}
