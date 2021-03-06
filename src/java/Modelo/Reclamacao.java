package Modelo;

import Banco.PassagemDAO;
import Banco.ReclamacaoDAO;

public class Reclamacao {
    String descricao, dataHora, codReclamacao;
    char estado; //Em aberto/ Resolucao/ Resolvido

    public Reclamacao() {
    }

    public String getCodReclamacao() {
        return codReclamacao;
    }

    public void setCodReclamacao(String codReclamacao) {
        this.codReclamacao = codReclamacao;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public Reclamacao(String descricao, char estado) {
        this.descricao = descricao;
        this.estado = estado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        if(descricao == null) descricao = "Não efetuada";
        this.descricao = descricao;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }
    
    public boolean ordemResolucao(){
        this.setEstado('E');
        return true;
    }
    
    public boolean resolver(){
        this.setEstado('R');
        return true;
    }
   
    public boolean addOnDb(String id, Modelo.Mensagem Erro, String cpf){
        Passagem p = new Passagem();
        PassagemDAO pd = new PassagemDAO();
        p.setCodigo(Integer.parseInt(id));
        if(pd.verificarPassagem(p, cpf)){
            System.out.println(p.getCheckin());
            if(!p.getCheckin().equals("Pendente")){
                ReclamacaoDAO r = new ReclamacaoDAO(); 
                return r.inserir(this, Integer.parseInt(id));
            }
            else{
                Erro.setErro("Checkin não foi feito");
                return false;
            }
        }
        else{
            Erro.setErro("Passagem não pertence ao cliente ou não existe");
            return false;
        }
    }
    
    public boolean getFromDb(int id){
        ReclamacaoDAO r = new ReclamacaoDAO();
        return r.pesquisar(this, id);
    }
    
    public boolean deletarReclamacao(){
        ReclamacaoDAO r = new ReclamacaoDAO();
        return r.deletar(this);
    }
    
    public boolean atualizarReclamacao(){
        ReclamacaoDAO r = new ReclamacaoDAO();
        return r.update(this);
    }
}
