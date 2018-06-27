package Banco;

import Modelo.Aeronave;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AeronaveDAO {
    public boolean inserir(Aeronave a){
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
    
    public boolean update(Aeronave a){
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
    
    public void pesquisar(Aeronave a){
        try{
            String sql = "SELECT * FROM AERONAVE WHERE PREFIXO = ?";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, a.getPrefixo());
            ResultSet rs = p.executeQuery();
            if(rs.next()){
                a.setFileiras(rs.getInt("QNTD_FILEIRA"));
                a.setColunas(rs.getInt("QNTD_COLUNA"));
                a.setCapacEconomica(rs.getInt("TOTALCADEIRAS_ECON"));
                a.setCapacPrimeira(rs.getInt("TOTACADEIRAS_EXEC"));
            }
            ConnectionFactory.closeConnection(conn, p, rs);
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }  
        
    }
    
    public boolean deletar(Aeronave a){
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
