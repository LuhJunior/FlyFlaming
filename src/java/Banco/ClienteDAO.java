package Banco;

import Modelo.Cliente;
import Modelo.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO {
    public boolean inserir(Cliente c){
        int r = 0;
        try{
            String sql = "INSERT INTO CLIENTE (CPF, NOME, EMAIL, SENHA, CEP, RUA, BAIRRO, CIDADE, ESTADO) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, c.getCpf());
            p.setString(2, c.getNome());
            p.setString(3, c.getEmail());
            p.setString(4, c.getSenha());
            p.setString(5, c.getEndereco().getCEP());
            p.setString(6, c.getEndereco().getRua());
            p.setString(7, c.getEndereco().getBairro());
            p.setString(8, c.getEndereco().getCidade());
            p.setString(9, c.getEndereco().getEstado());
            r = p.executeUpdate();
            ConnectionFactory.closeConnection(conn, p);
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }  
        finally{
            return (r>0);
        }
    }
    
    public boolean updateCliente(Cliente c){
        int r = 0;
        try{
            String sql = "UPDATE CLIENTE SET NOME = ?, EMAIL = ?, CEP = ?, RUA = ?, BAIRRO = ?, CIDADE = ?, ESTADO = ?"
                    + " WHERE CPF=?";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, c.getNome());
            p.setString(2, c.getEmail());
            p.setString(3, c.getEndereco().getCEP());
            p.setString(4, c.getEndereco().getRua());
            p.setString(5, c.getEndereco().getBairro());
            p.setString(6, c.getEndereco().getCidade());
            p.setString(7, c.getEndereco().getEstado());
            p.setString(8, c.getCpf());
            r = p.executeUpdate();
            ConnectionFactory.closeConnection(conn, p);
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }  
        finally{
            return (r>0);
        }
    }
    
    public boolean updateSenha(Cliente c){
        int r = 0;
        try{
            String sql = "UPDATE CLIENTE SET SENHA=? WHERE CPF=?";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, c.getSenha());
            p.setString(2, c.getCpf());
            r = p.executeUpdate();
            ConnectionFactory.closeConnection(conn, p);
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }  
        finally{
            return (r>0);
        }
    }
    
    public boolean updateTelefone(Cliente c){
        int r = 0;
        try{
            System.out.println("batata");
            String sql = "UPDATE TELEFONE SET NUMERO = ? WHERE CPF = ?";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, c.getTelefone());
            p.setString(2, c.getCpf());
            r = p.executeUpdate();
            ConnectionFactory.closeConnection(conn, p);
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
            String sql = "SELECT * FROM CLIENTE AS C INNER JOIN TELEFONE AS T ON C.CPF=T.CPF WHERE C.CPF = ? AND SENHA = ? ";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, c.getCpf());
            p.setString(2, c.getSenha());
            ResultSet rs = p.executeQuery();
            if(rs.next()){
                c.setNome(rs.getString("C.NOME"));
                c.setEmail(rs.getString("C.EMAIL"));
                c.setTelefone(rs.getString("T.NUMERO"));
                c.setEndereco(new Endereco());
                c.getEndereco().setCEP(rs.getString("C.CEP"));
                c.getEndereco().setRua(rs.getString("C.RUA"));
                c.getEndereco().setBairro(rs.getString("BAIRRO"));
                c.getEndereco().setCidade(rs.getString("CIDADE"));
                c.getEndereco().setEstado(rs.getString("ESTADO"));
            }
            ConnectionFactory.closeConnection(conn, p, rs);
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }  
    }
    
    public void pesquisarTelefone(Cliente c){
        try{
            String sql = "SELECT NUMERO FROM TELEFONE WHERE CPF = ?";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, c.getCpf());
            ResultSet rs = p.executeQuery();
            if(rs.next()){
                c.setTelefone(rs.getString("NUMERO"));
            }
            ConnectionFactory.closeConnection(conn, p, rs);
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        } 
    }
    
    public boolean inserirTelefone(Cliente c){
        int resp = 0;
        try{
            String sql = "INSERT INTO TELEFONE (CPF, NUMERO) VALUES(?, ?)";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, c.getCpf());
            p.setString(2, c.getTelefone());
            resp = p.executeUpdate();
            ConnectionFactory.closeConnection(conn, p);
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }  
        finally{
            return (resp>0);
        }
    }
    
    public void pesquisarEndereco(Cliente c){
        try{
            String sql = "SELECT RUA, BAIRRO, C.NOME AS CIDADE, ESTADO FROM ENDERECO AS E "
                    + "INNER JOIN CIDADE AS C ON C.IDCIDADE=E.IDCIDADE WHERE E.CEP = ?";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, c.getEndereco().getCEP());
            ResultSet rs = p.executeQuery();
            if(rs.next()){
                c.getEndereco().setRua(rs.getString("RUA"));
                c.getEndereco().setBairro(rs.getString("BAIRRO"));
                c.getEndereco().setCidade(rs.getString("CIDADE"));
                c.getEndereco().setEstado(rs.getString("ESTADO"));
            }
            ConnectionFactory.closeConnection(conn, p, rs);
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }  
    }
    
    public boolean verificarCEP(String CEP){
        try{
            String sql = "SELECT * FROM ENDERECO WHERE CEP = ?";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, CEP);
            ResultSet rs = p.executeQuery();
            if(rs.next()){
                ConnectionFactory.closeConnection(conn, p, rs);
                return true;
            }
            else{
                ConnectionFactory.closeConnection(conn, p, rs);
                return false;
            }
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }    
    
    public boolean inserirEndereco(Cliente c){
        int resp = 0;
        try{
            String sql = "INSERT INTO ENDERECO(RUA, BAIRRO, IDCIDADE, CEP) VALUES(?, ?, ?,"
                    + " (SELECT IDCIDADE FROM CIDADE WHERE NOME = ? AND ESTADO = ?), ?)";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, c.getCpf());
            p.setString(2, c.getEndereco().getRua());
            p.setString(3, c.getEndereco().getBairro());
            p.setString(4, c.getEndereco().getCidade());
            p.setString(5, c.getEndereco().getEstado());
            p.setString(6, c.getEndereco().getCEP());
            resp = p.executeUpdate();
            ConnectionFactory.closeConnection(conn, p);
        }
        catch(SQLException e){
            System.out.println("Não vai dá não!");
            throw new RuntimeException(e);
        }  
        finally{
            return (resp>0);
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
            if(rs.next()){
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
        }catch(SQLException e) {
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
