package Banco;

import Modelo.Pagamento;
import Modelo.Passagem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Junior
 */
public class PagamentoDAO {
        public boolean inserir(Pagamento p, String cpf){
        int r = 0;
        try{
            String sql = "INSERT INTO PAGAMENTO VALUES(NULL, ?, NOW(), ?, 'Aberto', ?, ?, ?)";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, p.getPassagem().getCodigo());
            ps.setFloat(2, p.getPassagem().getValor());
            ps.setString(3, p.getNumeroCartao());
            ps.setString(4, p.getSenha());
            ps.setInt(5, p.getParcelas());
            r = ps.executeUpdate();
            ConnectionFactory.closeConnection(conn, ps);
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }  
        return (r>0);

    }
    
    public boolean updateValor(Passagem p){
        int r = 0;
        try{
            String sql = "UPDATE PAGAMENTO SET VALOR_FINAL = VALOR_FINAL * 0.1 WHERE IDPASSAGEM = ? ";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, p.getCodigo());
            r = ps.executeUpdate();
            ConnectionFactory.closeConnection(conn, ps);
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }  
        finally{
            return (r>0);
        }
    }
    
    public void pegarPagamento(Pagamento p){
        try{
            String sql = "SELECT IDPASSAGEM, NUMERO_CARTAO, SENHA, DATAHORA_PAGAMENTO, VALOR_FINAL, SITU_PAGAMENTO WHERE IDPAGAMENTO = ?";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getNota());
            ResultSet rs = ps.executeQuery();
            if(rs != null && rs.next()){
                p.setNumeroCartao(rs.getString("NUMERO_CARTAO"));
                p.setSenha(rs.getString("SENHA"));
                p.getPassagem().setCodigo(rs.getInt("IDPASSAGEM"));
                p.getPassagem().setValor(rs.getFloat("VALOR_FINAL"));
            }
            ConnectionFactory.closeConnection(conn, ps, rs);
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }  
    }
    
    public boolean deletar(){
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
