package Banco;

import Modelo.Assento;
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
            String sql = "UPDATE PASSAGEM SET CHECKIN=NOW() WHERE IDPASSAGEM = ?";
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
            String sql = "UPDATE PASSAGEM SET CANCELAMENTO=NOW() WHERE IDPASSAGEM = ?";
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
    
    public void pegarPassagem(Passagem p){
        try{
            String sql = "SELECT P.IDPROGRAMACAO, P.DATAHORA_COMPRA, P.CHECKIN, P.CANCELAMENTO, PG.VALOR_FINAL, "
                    + "A.FILEIRA, A.CADEIRA, A.TIPO FROM PASSAGEM AS P INNER JOIN ASSENTO AS A "
                    + "ON P.ASSENTO = A.NUMERO INNER JOIN PAGAMENTO AS PG ON P.IDPASSAGEM=PG.IDPASSAGEM "
                    + "WHERE P.IDPASSAGEM = ?";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, p.getCodigo());
            ResultSet rs = ps.executeQuery();
            if(rs != null && rs.next()){
                p.getProgramacao().pegarProgramacao(rs.getInt("P.IDPROGRAMACAO"));
                p.setAssento(new Assento());
                p.getAssento().setFileira(rs.getInt("A.FILEIRA"));
                p.getAssento().setCadeira(rs.getInt("A.CADEIRA"));
                p.getAssento().setTipo(rs.getString("A.TIPO"));
                p.setHoraCompra(rs.getString("P.DATAHORA_COMPRA"));
                p.setCheckin(rs.getString("P.CHECKIN"));
                p.setCancelamento(rs.getString("P.CANCELAMENTO"));
                p.setValor(rs.getFloat("PG.VALOR_FINAL"));
            }
            ConnectionFactory.closeConnection(conn, ps, rs);
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }  
    }
    public static Passagem[] pegarPassagensDoCliente(String cpf){
        ArrayList<Passagem> passagens = new ArrayList<>();
        try{
            String sql = "SELECT P.IDPASSAGEM, P.IDPROGRAMACAO, P.DATAHORA_COMPRA, P.CHECKIN, P.CANCELAMENTO, PG.VALOR_FINAL, "
                    + "A.FILEIRA, A.CADEIRA, A.TIPO FROM PASSAGEM AS P INNER JOIN ASSENTO AS A "
                    + "ON P.ASSENTO = A.NUMERO INNER JOIN PAGAMENTO AS PG ON P.IDPASSAGEM=PG.IDPASSAGEM "
                    + "WHERE P.CPF = ?";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Passagem p = new Passagem();
                //p.getProgramacao().pegarProgramacao(rs.getInt("P.IDPROGRAMACAO"));
                p.setAssento(new Assento());
                p.getAssento().setFileira(rs.getInt("A.FILEIRA"));
                p.getAssento().setCadeira(rs.getInt("A.CADEIRA"));
                p.getAssento().setTipo(rs.getString("A.TIPO"));
                p.setCodigo(rs.getInt("P.IDPASSAGEM"));
                p.setHoraCompra(rs.getString("P.DATAHORA_COMPRA"));
                p.setCheckin(rs.getString("P.CHECKIN"));
                p.setCancelamento(rs.getString("P.CANCELAMENTO"));
                p.setValor(rs.getFloat("PG.VALOR_FINAL"));
                p.consultarReclamacao();
                passagens.add(p);
            }
            ConnectionFactory.closeConnection(conn, ps, rs);
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
        return (Passagem[]) passagens.toArray();     
    }
    
    public static Passagem[] pegarPassagensNaoCanceladasDoCliente(String cpf){
        ArrayList<Passagem> passagens = new ArrayList<>();
        try{
            String sql = "SELECT P.IDPASSAGEM, P.IDPROGRAMACAO, P.DATAHORA_COMPRA, P.CHECKIN, P.CANCELAMENTO, PG.VALOR_FINAL, "
                    + "A.FILEIRA, A.CADEIRA, A.TIPO FROM PASSAGEM AS P INNER JOIN ASSENTO AS A "
                    + "ON P.ASSENTO = A.NUMERO INNER JOIN PAGAMENTO AS PG ON P.IDPASSAGEM=PG.IDPASSAGEM "
                    + " WHERE P.CPF = ? AND CHECKIN IS NULL AND CANCELAMENTO IS NULL";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Passagem p = new Passagem();
                //p.getProgramacao().pegarProgramacao(rs.getInt("P.IDPROGRAMACAO"));
                p.setAssento(new Assento());
                p.getAssento().setFileira(rs.getInt("A.FILEIRA"));
                p.getAssento().setCadeira(rs.getInt("A.CADEIRA"));
                p.getAssento().setTipo(rs.getString("A.TIPO"));
                p.setCodigo(rs.getInt("P.IDPASSAGEM"));
                p.setHoraCompra(rs.getString("P.DATAHORA_COMPRA"));
                p.setCheckin(rs.getString("P.CHECKIN"));
                p.setCancelamento(rs.getString("P.CANCELAMENTO"));
                p.setValor(rs.getFloat("PG.VALOR_FINAL"));
                passagens.add(p);
                
            }
            ConnectionFactory.closeConnection(conn, ps, rs);
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
        return (Passagem[]) passagens.toArray(new Passagem[passagens.size()]);
    }
    
    public static  Passagem[] pegarPassagensPelaData(String data){
        ArrayList<Passagem> passagens = new ArrayList<>();
        try{
            String sql = "SELECT P.IDPASSAGEM, P.IDPROGRAMACAO, P.DATAHORA_COMPRA, P.CHECKIN, P.CANCELAMENTO, PG.VALOR_FINAL, "
                    + "A.FILEIRA, A.CADEIRA, A.TIPO FROM PASSAGEM AS P INNER JOIN ASSENTO AS A "
                    + "ON P.ASSENTO = A.NUMERO INNER JOIN PAGAMENTO AS PG ON P.IDPASSAGEM=PG.IDPASSAGEM "
                    + " INNER JOIN PROGRAMACAO AS PR ON PR.IDAPROGRAMACAO = P.IDPROGRAMACAO WHERE PR.DATA_SAIDA => ?";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, data);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Passagem p = new Passagem();
                //p.getProgramacao().pegarProgramacao(rs.getInt("P.IDPROGRAMACAO"));
                p.setAssento(new Assento());
                p.getAssento().setFileira(rs.getInt("A.FILEIRA"));
                p.getAssento().setCadeira(rs.getInt("A.CADEIRA"));
                p.getAssento().setTipo(rs.getString("A.TIPO"));
                p.setCodigo(rs.getInt("P.IDPASSAGEM"));
                p.setHoraCompra(rs.getString("P.DATAHORA_COMPRA"));
                p.setCheckin(rs.getString("P.CHECKIN"));
                p.setCancelamento(rs.getString("P.CANCELAMENTO"));
                p.setValor(rs.getFloat("PG.VALOR_FINAL"));
                passagens.add(p);
            }
            ConnectionFactory.closeConnection(conn, ps, rs);
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
        return (Passagem[]) passagens.toArray(new Passagem[passagens.size()]);
    }
    
    public static Passagem[] pegarPassagensComReclamacao(String cpf){
        ArrayList<Passagem> passagens = new ArrayList<>();
        try{
            String sql = "SELECT P.IDPASSAGEM, P.IDPROGRAMACAO, P.DATAHORA_COMPRA, P.CHECKIN, P.CANCELAMENTO, PG.VALOR_FINAL, "
                    + "A.FILEIRA, A.CADEIRA, A.TIPO FROM PASSAGEM AS P INNER JOIN ASSENTO AS A "
                    + "ON P.ASSENTO = A.NUMERO INNER JOIN PAGAMENTO AS PG ON P.IDPASSAGEM=PG.IDPASSAGEM "
                    + "INNER JOIN RECLAMACAO AS R ON R.IDPASSAGEM=P.IDPASSAGEM "
                    + "WHERE P.CPF = ?";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Passagem p = new Passagem();
                p.setAssento(new Assento());
                p.getAssento().setFileira(rs.getInt("A.FILEIRA"));
                p.getAssento().setCadeira(rs.getInt("A.CADEIRA"));
                p.getAssento().setTipo(rs.getString("A.TIPO"));
                p.setCodigo(rs.getInt("P.IDPASSAGEM"));
                p.setHoraCompra(rs.getString("P.DATAHORA_COMPRA"));
                p.setCheckin(rs.getString("P.CHECKIN"));
                p.setCancelamento(rs.getString("P.CANCELAMENTO"));
                p.setValor(rs.getFloat("PG.VALOR_FINAL"));
                p.consultarReclamacao();
                passagens.add(p);
            }
            ConnectionFactory.closeConnection(conn, ps, rs);
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
