package Banco;

import Modelo.Programacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProgramacaoDAO {
    public boolean inserir(Programacao pr){
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
    
    public boolean update(Programacao pr){
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
    
    public void pesquisar(Programacao p){
        try{
            String sql = "SELECT NUM_VOO, DATE(DATAHORA_SAIDA) AS DATA_SAIDA, TIME(DATAHORA_SAIDA) AS HORA_SAIDA, DATE(DATAHORA_CHEGADA) AS DATA_CHEGADA, TIME(DATAHORA_CHEGADA) AS HORA_CHEGADA FROM PROGRAMACAO WHERE IDPROGRAMACAO=?";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, p.getId());
            System.out.println(p.getId());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                p.setDataSaida(rs.getString("DATA_SAIDA"));
                p.setHoraSaida(rs.getString("HORA_SAIDA"));
                System.out.println(p.getHoraSaida());
                p.setDataChegada(rs.getString("DATA_CHEGADA"));
                p.setHoraChegada(rs.getString("HORA_CHEGADA"));
            }
            ConnectionFactory.closeConnection(conn, ps, rs);
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }    
    }
    
    public boolean deletar(Programacao pr){
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
