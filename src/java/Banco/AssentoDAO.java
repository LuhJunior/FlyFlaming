package Banco;

import Modelo.Assento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Júnior
 */
public class AssentoDAO {

    public boolean inserir(Assento a){
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
    
    public boolean update(Assento a){
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
    
    public void pegarAssento(Assento a){
        try{
            String sql = "SELECT FILEIRA, CADEIRA, TIPO FROM ASSENTO WHERE NUMERO = ?";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, a.getNumero());
            ResultSet rs = p.executeQuery();
            if(rs != null && rs.next()){
                a.setFileira(rs.getInt("FILEIRA"));
                a.setCadeira(rs.getInt("CADEIRA"));
                a.setTipo(rs.getString("TIPO"));
            }
            ConnectionFactory.closeConnection(conn, p, rs);
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }  
    }
    public ArrayList<Assento> pegarAssentos(){
        ArrayList<Assento> assentos = new ArrayList<>();
        try{
            String sql = "SELECT FILEIRA, CADEIRA, TIPO FROM ASSENTO";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            while(rs.next()){
                Assento a = new Assento();
                a.setFileira(rs.getInt("FILEIRA"));
                a.setCadeira(rs.getInt("CADEIRA"));
                a.setTipo(rs.getString("TIPO"));
                assentos.add(a);
            }
            ConnectionFactory.closeConnection(conn, p, rs);
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
        return assentos;
    }
    
    public static ArrayList<Assento> pegarAssentos(String aeronave, int voo){
        ArrayList<Assento> assentos = new ArrayList<>();
        try{
            String sql = "SELECT NUMERO, FILEIRA, CADEIRA, TIPO FROM ASSENTO AS A INNER JOIN AERONAVE AS AV ON "
                    + "AV.PREFIXO = A.AERONAVE INNER JOIN VOO AS V ON V.PREFIXO = AV.PREFIXO INNER JOIN PROGRAMACAO AS PG ON "
                    + "PG.NUM_VOO = V.NUM_VOO WHERE AERONAVE = ? AND V.NUM_VOO = ? AND A.NUMERO "
                    + "NOT IN (SELECT PASSAGEM.ASSENTO FROM PASSAGEM WHERE PASSAGEM.IDPROGRAMACAO=PG.IDPROGRAMACAO)";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, aeronave);
            p.setInt(2, voo);
            ResultSet rs = p.executeQuery();            
            while(rs.next()){
                Assento a = new Assento();
                a.setNumero(rs.getInt("NUMERO"));
                a.setFileira(rs.getInt("FILEIRA"));
                a.setCadeira(rs.getInt("CADEIRA"));
                a.setTipo(rs.getString("TIPO"));
                assentos.add(a);
            }
            ConnectionFactory.closeConnection(conn, p, rs);
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
        return assentos;
    }
    
    public boolean deletar(Assento a){
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
