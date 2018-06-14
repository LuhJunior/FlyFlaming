package Banco;

import Modelo.Passagem;
import Modelo.Programacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

public class PassagemDAO {
    public boolean inserir(Passagem pa){
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
    
    public boolean update(Passagem pa){
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
    
    public boolean updateCheckin(Passagem pa){
        int r = 0;
        try{
            String sql = "UPDATE PASSAGEM SET CHECKIN=1 WHERE IDPASSAGEM = ?";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, pa.getCodigo());
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
    
    public boolean updateCancelamento(Passagem pa){
        int r = 0;
        try{
            String sql = "UPDATE PASSAGEM SET CANCELAMENTO=1 WHERE IDPASSAGEM = ?";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, pa.getCodigo());
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
    
    public void getFromDb(Passagem pa){
        try{
            String sql = "SELECT IDPROGRAMACAO, COD_POLTRONA, DATAHORA_COMPRA, CHECKIN,"
                    + "CANCELAMENTO, VALOR_FINAL, CPF FROM PASSAGEM AS P JOIN PAGAMENTO AS PG ON P.IDPASSAGEM=PG.IDPASSAGEM"
                    + " WHERE P.IDPASSAGEM = ?";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, pa.getCodigo());
            ResultSet rs = p.executeQuery();
            if(rs != null && rs.next()){
                pa.getProgramacao().getFromDb(rs.getInt("IDPROGRAMACAO"));
                pa.setAssento(rs.getString("COD_POLTRONA"));
                pa.setHoraCompra(rs.getString("DATAHORA_COMPRA"));
                pa.setCheckin(rs.getInt("CHECKIN") == 1);
                pa.setCancelada(rs.getInt("CANCELAMENTO") == 1);
                pa.setValor(rs.getFloat("VALOR_FINAL"));
            }
            ConnectionFactory.closeConnection(conn, p, rs);
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }  
    }
    public Passagem[] getFromDb(String cpf){
        ArrayList<Passagem> passagens = new ArrayList<>();
        try{
            String sql = "SELECT IDPROGRAMACAO, IDPROGRAMACAO, COD_POLTRONA, DATAHORA_COMPRA, CHECKIN,"
                    + "CANCELAMENTO, VALOR_FINAL FROM PASSAGEM AS P JOIN PAGAMENTO AS PG ON P.IDPASSAGEM=PG.IDPASSAGEM"
                    + " WHERE P.CPF = ?";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, cpf);
            ResultSet rs = p.executeQuery();
            while(rs.next()){
                Passagem pa = new Passagem();
                pa.setProgramacao(new Programacao());
                pa.setCodigo(rs.getInt("IDPASSAGEM"));
                pa.getProgramacao().getFromDb(rs.getInt("IDPROGRAMACAO"));
                pa.setAssento(rs.getString("COD_POLTRONA"));
                pa.setHoraCompra(rs.getString("DATAHORA_COMPRA"));
                pa.setCheckin(rs.getInt("CHECKIN") == 1);
                pa.setCancelada(rs.getInt("CANCELAMENTO") == 1);
                pa.setValor(rs.getFloat("VALOR_FINAL"));
                passagens.add(pa);
            }
            ConnectionFactory.closeConnection(conn, p, rs);
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
        return (Passagem[]) passagens.toArray();     
    }
    
    public Passagem[] pegarPassagens(String cpf){
        ArrayList<Passagem> passagens = new ArrayList<>();
        try{
            String sql = "SELECT P.IDPASSAGEM, IDPROGRAMACAO, COD_POLTRONA, DATAHORA_COMPRA, CHECKIN,"
                    + "CANCELAMENTO, VALOR_FINAL FROM PASSAGEM AS P JOIN PAGAMENTO AS PG ON P.IDPASSAGEM=PG.IDPASSAGEM"
                    + " WHERE P.CPF = ?";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, cpf);
            ResultSet rs = p.executeQuery();
            while(rs.next()){
                Passagem pa = new Passagem();
                pa.setProgramacao(new Programacao());
                pa.setCodigo(rs.getInt("IDPASSAGEM"));
                pa.getProgramacao().getFromDb(rs.getInt("IDPROGRAMACAO"));
                pa.setAssento(rs.getString("COD_POLTRONA"));
                pa.setHoraCompra(rs.getString("DATAHORA_COMPRA"));
                pa.setCheckin(rs.getInt("CHECKIN") == 1);
                pa.setCancelada(rs.getInt("CANCELAMENTO") == 1);
                pa.setValor(rs.getFloat("VALOR_FINAL"));
                pa.consultarReclamacao();
                if(!(pa.isCancelada() || pa.isCheckin())) passagens.add(pa);
            }
            ConnectionFactory.closeConnection(conn, p, rs);
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
        return (Passagem[]) passagens.toArray(new Passagem[passagens.size()]);
    }
    
    public Passagem[] pegarPassagensComReclamcao(String cpf){
        ArrayList<Passagem> passagens = new ArrayList<>();
        try{
            String sql = "SELECT P.IDPASSAGEM, IDPROGRAMACAO, COD_POLTRONA, DATAHORA_COMPRA, CHECKIN,"
                    + "CANCELAMENTO, VALOR_FINAL FROM PASSAGEM AS P INNER JOIN PAGAMENTO AS PG ON P.IDPASSAGEM=PG.IDPASSAGEM"
                    + " WHERE P.CPF = ?";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, cpf);
            ResultSet rs = p.executeQuery();
            while(rs.next()){
                Passagem pa = new Passagem();
                pa.setProgramacao(new Programacao());
                pa.setCodigo(rs.getInt("IDPASSAGEM"));
                pa.getProgramacao().getFromDb(rs.getInt("IDPROGRAMACAO"));
                pa.setAssento(rs.getString("COD_POLTRONA"));
                pa.setHoraCompra(rs.getString("DATAHORA_COMPRA"));
                pa.setCheckin(rs.getInt("CHECKIN") == 1);
                pa.setCancelada(rs.getInt("CANCELAMENTO") == 1);
                pa.setValor(rs.getFloat("VALOR_FINAL"));
                pa.consultarReclamacao();
                if(pa.getReclamacao() != null) passagens.add(pa);
            }
            ConnectionFactory.closeConnection(conn, p, rs);
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
        return (Passagem[]) passagens.toArray(new Passagem[passagens.size()]);
    }
    
    public boolean deletar(Passagem pa){
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
