package Banco;

import Modelo.Voo;
import Banco.ConnectionFactory;
import Modelo.Programacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VooDAO {
    public VooDAO(){}
    public boolean inserir(Voo v){
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
    
    public boolean update(Voo v){
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
    
    public ArrayList<Voo> pesquisarVoosPelaData(String data){
        ArrayList<Voo> v = new ArrayList<>();
        try{
            String sql = "SELECT V.PREFIXO AS PREFIXO, V.NUM_VOO AS 'NUMERO DO VOO', C1.NOME AS 'CIDADE DE ORIGEM',"
                        + "C2.NOME AS 'CIDADE DE DESTINO', V.VALORPASSAGEM AS VALOR, P.DATAHORA_CHEGADA"
                        + "AS 'DATA DE CHEGADA', P.DATAHORA_SAIDA AS 'DATA DE SAIDA', P.EXEC_DISPONIVEL AS EXEC,"
                        + "P.ECON_DISPONIVEL AS ECON FROM VOO AS V INNER JOIN PROGRAMACAO AS P" 
                        + "ON V.NUM_VOO = P.NUM_VOO INNER JOIN CIDADE AS C1" 
                        + "ON V.CID_ORIGEM = C1.IDCIDADE INNER JOIN CIDADE AS C2"
                        + "ON V.CID_DESTINO = C2.IDCIDADE WHERE 'DATA DE SAIDA' >= ?;";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, data);
            ResultSet rs = p.executeQuery();
            while(rs.next()){
                Voo auxV = new Voo();
                auxV.setNumero(rs.getInt("NUMERO DO VOO"));
                auxV.setOrigem(rs.getString("CIDADE DE ORIGEM"));
                auxV.setDestino(rs.getString("CIDADE DE DESTINO"));
                auxV.setValor(rs.getDouble("VALOR"));
                auxV.setProgramacao(new Programacao());
                auxV.getProgramacao().setDataChegada(rs.getString("DATE(DATA DE CHEGADA)"));
                auxV.getProgramacao().setDataSaida(rs.getString("DATE(DATA DE SAIDA)"));
                auxV.getProgramacao().setHoraChegada(rs.getString("TIME(DATA DE CHEGADA)"));
                auxV.getProgramacao().setHoraSaida(rs.getString("TIME(DATA DE SAIDA)"));
                auxV.getProgramacao().setQuantidadeExec(rs.getInt("EXEC"));
                auxV.getProgramacao().setQuantidadeEcon(rs.getInt("ECON"));
                v.add(auxV);
            }
            ConnectionFactory.closeConnection(conn, p, rs);
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }  
        return v;
    }
    
    public ArrayList<Voo> pesquisarVoos(){
        ArrayList<Voo> v = new ArrayList<>();
        try{
            String sql = "SELECT V.PREFIXO AS PREFIXO, V.NUM_VOO AS 'NUMERO DO VOO', C1.NOME AS 'CIDADE DE ORIGEM',"
                        + "C2.NOME AS 'CIDADE DE DESTINO', V.VALORPASSAGEM AS VALOR, DATE(P.DATAHORA_CHEGADA)"
                        + "AS 'DATA DE CHEGADA', DATE(P.DATAHORA_SAIDA) AS 'DATA DE SAIDA', P.EXEC_DISPONIVEL AS EXEC,"
                        + "P.ECON_DISPONIVEL AS ECON FROM VOO AS V INNER JOIN PROGRAMACAO AS P" 
                        + "ON V.NUM_VOO = P.NUM_VOO INNER JOIN CIDADE AS C1" 
                        + "ON V.CID_ORIGEM = C1.IDCIDADE INNER JOIN CIDADE AS C2"
                        + "ON V.CID_DESTINO = C2.IDCIDADE;";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            while(rs.next()){
                Voo auxV = new Voo();
                auxV.setNumero(rs.getInt("NUMERO DO VOO"));
                auxV.setOrigem(rs.getString("CIDADE DE ORIGEM"));
                auxV.setDestino(rs.getString("CIDADE DE DESTINO"));
                auxV.setValor(rs.getDouble("VALOR"));
                auxV.setProgramacao(new Programacao());
                auxV.getProgramacao().setHoraChegada(rs.getString("DATA DE CHEGADA"));
                auxV.getProgramacao().setHoraSaida(rs.getString("DATA DE SAIDA"));
                auxV.getProgramacao().setQuantidadeExec(rs.getInt("EXEC"));
                auxV.getProgramacao().setQuantidadeEcon(rs.getInt("ECON"));
                v.add(auxV);
            }
            ConnectionFactory.closeConnection(conn, p, rs);
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }  
        return v;
    }
    
    public void pesquisar(Voo v){
        try{
            String sql = "SELECT V.PREFIXO AS PREFIXO, V.NUM_VOO AS 'NUMERO DO VOO', C1.NOME AS 'CIDADE DE ORIGEM',"
                        + "C2.NOME AS 'CIDADE DE DESTINO', V.VALORPASSAGEM AS VALOR, DATE(P.DATAHORA_CHEGADA)"
                        + "AS 'DATA DE CHEGADA', DATE(P.DATAHORA_SAIDA) AS 'DATA DE SAIDA', P.EXEC_DISPONIVEL AS EXEC,"
                        + "P.ECON_DISPONIVEL AS ECON FROM VOO AS V INNER JOIN PROGRAMACAO AS P" 
                        + "ON V.NUM_VOO = P.NUM_VOO INNER JOIN CIDADE AS C1" 
                        + "ON V.CID_ORIGEM = C1.IDCIDADE INNER JOIN CIDADE AS C2"
                        + "ON V.CID_DESTINO = C2.IDCIDADE WHERE 'NUMERO DO VOO' = ?;";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, v.getNumero());
            ResultSet rs = p.executeQuery();
            if(rs.next()){
                v.setNumero(rs.getInt("NUMERO DO VOO"));
                v.setOrigem(rs.getString("CIDADE DE ORIGEM"));
                v.setDestino(rs.getString("CIDADE DE DESTINO"));
                v.setValor(rs.getDouble("VALOR"));
                v.setProgramacao(new Programacao());
                v.getProgramacao().setHoraChegada(rs.getString("DATA DE CHEGADA"));
                v.getProgramacao().setHoraSaida(rs.getString("DATA DE SAIDA"));
                v.getProgramacao().setQuantidadeExec(rs.getInt("EXEC"));
                v.getProgramacao().setQuantidadeEcon(rs.getInt("ECON"));
            }
            ConnectionFactory.closeConnection(conn, p, rs);
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }  
        
    }
    
    public boolean deletar(Voo v){
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
