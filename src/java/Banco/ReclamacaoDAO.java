package Banco;

import Modelo.Reclamacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReclamacaoDAO {
    public boolean inserir(Reclamacao r, int id){
        int resp = 0;
        try{
            String sql = "INSERT INTO RECLAMACAO(IDPASSAGEM, DESCRICAO, SITU_RECLAMACAO, DATAHORA_RECLAM"
                    + ") VALUES(?, ?, 'Aberto', now())";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, id);
            p.setString(2, r.getDescricao());
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
    
    public boolean update(Reclamacao r){
        int rr = 0;
        try{
            String sql = "UPDATE RECLAMACAO SET DESCRICAO = ? WHERE NUM_RECLAM = ?";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, r.getDescricao());
            p.setString(2, r.getCodReclamacao());
            rr = p.executeUpdate();
            ConnectionFactory.closeConnection(conn, p);
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }  
        finally{
            return (rr>0);
        }
    }
    
    public boolean pesquisar(Reclamacao r, int id){
        try{
            String sql = "SELECT NUM_RECLAM, DESCRICAO, SITU_RECLAMACAO, DATAHORA_RECLAM FROM RECLAMACAO "
                    + "WHERE IDPASSAGEM = ?";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, id);
            ResultSet rs = p.executeQuery();
            if(rs.next()){
                r.setCodReclamacao(rs.getString("NUM_RECLAM"));
                r.setDescricao(rs.getString("DESCRICAO"));
                r.setEstado(rs.getString("SITU_RECLAMACAO").charAt(0));
                r.setDataHora(rs.getString("DATAHORA_RECLAM"));
            }else return false;
            ConnectionFactory.closeConnection(conn, p, rs);
            return true;
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public boolean deletar(Reclamacao r){
        int rr = 0;
        try{
            String sql = "DELETE FROM RECLAMACAO WHERE NUM_RECLAM = ?";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, r.getCodReclamacao());
            rr = p.executeUpdate();
            ConnectionFactory.closeConnection(conn, p);
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }  
        finally{
            return (rr>0);
        }
    }
}
