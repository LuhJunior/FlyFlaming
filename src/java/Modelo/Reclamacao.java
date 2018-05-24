package Modelo;

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
   
    public boolean addOnDb(String id){
        ReclamacaoDAO r = new ReclamacaoDAO(); 
        return r.inserir(this, Integer.parseInt(id));
    }
    
    public boolean getFromDb(int id){
        ReclamacaoDAO r = new ReclamacaoDAO();
        r.pesquisar(this, id);
        return true;
    }

}
