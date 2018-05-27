package Banco;

import Modelo.Passagem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    
    public void pesquisar(Passagem pa){
        try{
            String sql = "SELECT IDPROGRAMACAO, COD_POLTRONA, DATAHORA_COMPRA, CHECKIN,"
                    + "CANCELAMENTO, VALOR_FINAL, CPF FROM PASSAGEM AS P JOIN PAGAMENTO AS PG ON P.IDPAGAMENTO=PG.PAGAMENTO"
                    + " WHERE IDPASSAGEM = ?";
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
                pa.getCliente().setCpf(rs.getString("CPF"));
            }
            ConnectionFactory.closeConnection(conn, p, rs);
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }  
        
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
