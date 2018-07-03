package Modelo;

import Banco.PagamentoDAO;

public class Pagamento {
    String nota, numeroCartao, senha;
    int parcelas;
    Passagem passagem;

    public Pagamento(String numeroCartao, String senha, int parcelas, Passagem passagem) {
        this.numeroCartao = numeroCartao;
        this.senha = senha;
        this.parcelas = parcelas;
        this.passagem = passagem;
    }

    public Pagamento() {
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    public Passagem getPassagem() {
        return passagem;
    }

    public void setPassagem(Passagem passagem) {
        this.passagem = passagem;
    }
    
    public boolean pagarPassagem(String cpf){ 
        System.out.println(cpf);
        PagamentoDAO p = new PagamentoDAO();
        return p.inserir(this, cpf);
    }
}
