package Modelo;

public class Reclamacao {
    String descricao;
    char estado; //Em aberto/ Resolucao/ Resolvido

    public Reclamacao() {
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
    
    boolean ordemResolucao(){
        this.setEstado('E');
        return true;
    }
    
    boolean resolver(){
        this.setEstado('R');
        return true;
    }
   
    boolean addOnDb(){ 
        return true;
    }
    
    boolean getFromDb(){
        return true;
    }
}
