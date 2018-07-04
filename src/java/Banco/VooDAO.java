package Banco;

import Modelo.Voo;
import Banco.ConnectionFactory;
import Modelo.Aeronave;
import Modelo.Assento;
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
    
       
    public static ArrayList<Voo> pesquisarVooPelaDataOrigemDestino(String Origem, String Destino, String dataIda){
        ArrayList<Voo> v = new ArrayList<>();
        try{
            String sql = "SELECT V.PREFIXO AS PREFIXO, V.NUM_VOO AS 'NUMERO DO VOO', C1.NOME AS 'CIDADE DE ORIGEM', "
                    + "C2.NOME AS 'CIDADE DE DESTINO', V.VALOR_PASSAGEM AS VALOR, DATE(P.DATAHORA_CHEGADA) "
                    + "AS 'DATA DE CHEGADA', TIME(P.DATAHORA_CHEGADA) AS 'HORA DE CHEGADA', "
                    + "DATE(P.DATAHORA_SAIDA) AS 'DATA DE SAIDA', TIME(P.DATAHORA_SAIDA) AS 'HORA DE SAIDA'"
                    + ", SUM(CASE WHEN A.TIPO = 'Executivo' THEN 1 END) AS EXEC, "
                    + "SUM(CASE WHEN A.TIPO = 'Economico' THEN 1 END) AS ECON FROM VOO AS V INNER JOIN ASSENTO AS A "
                    + "ON A.AERONAVE = V.PREFIXO INNER JOIN PROGRAMACAO AS P " 
                    + "ON V.NUM_VOO = P.NUM_VOO INNER JOIN CIDADE AS C1 " 
                    + "ON V.CID_ORIGEM = C1.IDCIDADE INNER JOIN CIDADE AS C2 "
                    + "ON V.CID_DESTINO = C2.IDCIDADE WHERE DATE(P.DATAHORA_SAIDA) = ? "
                    + "AND C1.NOME = ? AND C2.NOME = ? AND A.NUMERO NOT IN "
                    + "(SELECT PASSAGEM.ASSENTO FROM PASSAGEM WHERE PASSAGEM.IDPROGRAMACAO=P.IDPROGRAMACAO);";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, dataIda);
            ps.setString(2, Origem);
            ps.setString(3, Destino);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Voo auxV = new Voo();
                auxV.setNumero(rs.getInt("NUMERO DO VOO"));
                auxV.setOrigem(rs.getString("CIDADE DE ORIGEM"));
                auxV.setDestino(rs.getString("CIDADE DE DESTINO"));
                auxV.setValor(rs.getFloat("VALOR"));
                auxV.setProgramacao(new Programacao());
                auxV.getProgramacao().setDataChegada(rs.getString("DATA DE CHEGADA"));
                auxV.getProgramacao().setDataSaida(rs.getString("DATA DE SAIDA"));
                auxV.getProgramacao().setHoraChegada(rs.getString("HORA DE CHEGADA"));
                auxV.getProgramacao().setHoraSaida(rs.getString("HORA DE SAIDA"));
                auxV.getProgramacao().setQuantidadeExec(rs.getInt("EXEC"));
                auxV.getProgramacao().setQuantidadeEcon(rs.getInt("ECON"));
                v.add(auxV);
            }
            ConnectionFactory.closeConnection(conn, ps, rs);
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
        return v;
    }
    
    
    public static ArrayList<Voo> pesquisarVoosPelaData(String data){
        ArrayList<Voo> v = new ArrayList<>();
        try{
            String sql = "SELECT V.PREFIXO AS PREFIXO, V.NUM_VOO AS 'NUMERO DO VOO', C1.NOME AS 'CIDADE DE ORIGEM', "
                        + "C2.NOME AS 'CIDADE DE DESTINO', V.VALOR_PASSAGEM AS VALOR, DATE(P.DATAHORA_CHEGADA) "
                        + "AS 'DATA DE CHEGADA', TIME(P.DATAHORA_CHEGADA) AS 'HORA DE CHEGADA', "
                        + "DATE(P.DATAHORA_SAIDA) AS 'DATA DE SAIDA', TIME(P.DATAHORA_SAIDA) AS 'HORA DE SAIDA'"
                        + ", P.EXEC_DISPONIVEL AS EXEC, "
                        + "P.ECON_DISPONIVEL AS ECON FROM VOO AS V INNER JOIN PROGRAMACAO AS P " 
                        + "ON V.NUM_VOO = P.NUM_VOO INNER JOIN CIDADE AS C1 " 
                        + "ON V.CID_ORIGEM = C1.IDCIDADE INNER JOIN CIDADE AS C2 "
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
                auxV.setValor(rs.getFloat("VALOR"));
                auxV.setProgramacao(new Programacao());
                auxV.getProgramacao().setDataChegada(rs.getString("DATA DE CHEGADA"));
                auxV.getProgramacao().setDataSaida(rs.getString("DATA DE SAIDA"));
                auxV.getProgramacao().setHoraChegada(rs.getString("HORA DE CHEGAD)"));
                auxV.getProgramacao().setHoraSaida(rs.getString("HORA DE SAIDA"));
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
    
    public static ArrayList<Voo> pesquisarVoosDaSemana(){
        ArrayList<Voo> v = new ArrayList<>();
        try{
            String sql = "SELECT V.PREFIXO AS PREFIXO, V.NUM_VOO AS 'NUMERO DO VOO', C1.NOME AS 'CIDADE DE ORIGEM', "
                        + "C2.NOME AS 'CIDADE DE DESTINO', V.VALOR_PASSAGEM AS VALOR, DATE(P.DATAHORA_CHEGADA) "
                        + "AS 'DATA DE CHEGADA', TIME(P.DATAHORA_CHEGADA) AS 'HORA DE CHEGADA', "
                        + "DATE(P.DATAHORA_SAIDA) AS 'DATA DE SAIDA', TIME(P.DATAHORA_SAIDA) AS 'HORA DE SAIDA'"
                        + ", P.EXEC_DISPONIVEL AS EXEC, "
                        + "P.ECON_DISPONIVEL AS ECON FROM VOO AS V INNER JOIN PROGRAMACAO AS P " 
                        + "ON V.NUM_VOO = P.NUM_VOO INNER JOIN CIDADE AS C1 " 
                        + "ON V.CID_ORIGEM = C1.IDCIDADE INNER JOIN CIDADE AS C2 "
                        + "ON V.CID_DESTINO = C2.IDCIDADE WHERE DATE(P.DATAHORA_SAIDA) BETWEEN "
                        + "DATE_ADD(DATE(NOW()), INTERVAL -WEEKDAY(DATE(NOW())) DAY) AND "
                        + "DATE_ADD(DATE(NOW()), INTERVAL 7-WEEKDAY(DATE(NOW())) DAY);";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            while(rs.next()){
                Voo auxV = new Voo();
                auxV.setNumero(rs.getInt("NUMERO DO VOO"));
                auxV.setOrigem(rs.getString("CIDADE DE ORIGEM"));
                auxV.setDestino(rs.getString("CIDADE DE DESTINO"));
                auxV.setValor(rs.getFloat("VALOR"));
                auxV.setProgramacao(new Programacao());
                auxV.getProgramacao().setDataChegada(rs.getString("DATA DE CHEGADA"));
                auxV.getProgramacao().setDataSaida(rs.getString("DATA DE SAIDA"));
                auxV.getProgramacao().setHoraChegada(rs.getString("HORA DE CHEGADA"));
                auxV.getProgramacao().setHoraSaida(rs.getString("HORA DE SAIDA"));
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
    
    public static ArrayList<Voo> pesquisarVoos(){
        ArrayList<Voo> v = new ArrayList<>();
        try{
            String sql = "SELECT V.PREFIXO AS PREFIXO, V.NUM_VOO AS 'NUMERO DO VOO', C1.NOME AS 'CIDADE DE ORIGEM', "
                        + "C2.NOME AS 'CIDADE DE DESTINO', V.VALOR_PASSAGEM AS VALOR, DATE(P.DATAHORA_CHEGADA) "
                        + "AS 'DATA DE CHEGADA', TIME(P.DATAHORA_CHEGADA) AS 'HORA DE CHEGADA', "
                        + "DATE(P.DATAHORA_SAIDA) AS 'DATA DE SAIDA', TIME(P.DATAHORA_SAIDA) AS 'HORA DE SAIDA'"
                        + ", P.EXEC_DISPONIVEL AS EXEC, "
                        + "P.ECON_DISPONIVEL AS ECON FROM VOO AS V INNER JOIN PROGRAMACAO AS P " 
                        + "ON V.NUM_VOO = P.NUM_VOO INNER JOIN CIDADE AS C1 " 
                        + "ON V.CID_ORIGEM = C1.IDCIDADE INNER JOIN CIDADE AS C2 "
                        + "ON V.CID_DESTINO = C2.IDCIDADE;";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            while(rs.next()){
                Voo auxV = new Voo();
                auxV.setNumero(rs.getInt("NUMERO DO VOO"));
                auxV.setOrigem(rs.getString("CIDADE DE ORIGEM"));
                auxV.setDestino(rs.getString("CIDADE DE DESTINO"));
                auxV.setValor(rs.getFloat("VALOR"));
                auxV.setProgramacao(new Programacao());
                auxV.getProgramacao().setDataChegada(rs.getString("DATA DE CHEGADA"));
                auxV.getProgramacao().setDataSaida(rs.getString("DATA DE SAIDA"));
                auxV.getProgramacao().setHoraChegada(rs.getString("HORA DE CHEGADA"));
                auxV.getProgramacao().setHoraSaida(rs.getString("HORA DE SAIDA"));
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
            String sql = "SELECT V.PREFIXO AS PREFIXO, V.NUM_VOO AS 'NUMERO DO VOO', C1.NOME AS 'CIDADE DE ORIGEM', "
                        + "C2.NOME AS 'CIDADE DE DESTINO', V.VALOR_PASSAGEM AS VALOR, DATE(P.DATAHORA_CHEGADA) "
                        + "AS 'DATA DE CHEGADA', TIME(P.DATAHORA_CHEGADA) AS 'HORA DE CHEGADA', "
                        + "DATE(P.DATAHORA_SAIDA) AS 'DATA DE SAIDA', TIME(P.DATAHORA_SAIDA) AS 'HORA DE SAIDA'"
                        + ", P.EXEC_DISPONIVEL AS EXEC, P.IDPROGRAMACAO, "
                        + "P.ECON_DISPONIVEL AS ECON FROM VOO AS V INNER JOIN PROGRAMACAO AS P " 
                        + "ON V.NUM_VOO = P.NUM_VOO INNER JOIN CIDADE AS C1 " 
                        + "ON V.CID_ORIGEM = C1.IDCIDADE INNER JOIN CIDADE AS C2 "
                        + "ON V.CID_DESTINO = C2.IDCIDADE WHERE V.NUM_VOO = ?;";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, v.getNumero());
            ResultSet rs = p.executeQuery();
            if(rs.next()){
                v.setAviao(new Aeronave());
                v.getAviao().setPrefixo(rs.getString("PREFIXO"));
                v.setNumero(rs.getInt("NUMERO DO VOO"));
                v.setOrigem(rs.getString("CIDADE DE ORIGEM"));
                v.setDestino(rs.getString("CIDADE DE DESTINO"));
                v.setValor(rs.getFloat("VALOR"));
                v.setProgramacao(new Programacao());
                v.getProgramacao().setId(rs.getInt("P.IDPROGRAMACAO"));
                v.getProgramacao().setDataChegada(rs.getString("DATA DE CHEGADA"));
                v.getProgramacao().setDataSaida(rs.getString("DATA DE SAIDA"));
                v.getProgramacao().setHoraChegada(rs.getString("HORA DE CHEGADA"));
                v.getProgramacao().setHoraSaida(rs.getString("HORA DE SAIDA"));
                v.getProgramacao().setQuantidadeExec(rs.getInt("EXEC"));
                v.getProgramacao().setQuantidadeEcon(rs.getInt("ECON"));
                v.getProgramacao().setId(rs.getInt("P.IDPROGRAMACAO"));
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
