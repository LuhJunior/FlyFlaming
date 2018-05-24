package Modelo;

public class Passagem {
    String assento;
    boolean paga, checkin;
    float valor;
    Programacao programacao;
    Cliente cliente;
    Reclamacao reclamacao;

    public Passagem() {
    }

    public Passagem(String assento, boolean paga, boolean checkin, float valor, Programacao programacao, Cliente cliente, Reclamacao reclamacao) {
        this.assento = assento;
        this.paga = paga;
        this.checkin = checkin;
        this.valor = valor;
        this.programacao = programacao;
        this.cliente = cliente;
        this.reclamacao = reclamacao;
    }

    public String getAssento() {
        return assento;
    }

    public void setAssento(String assento) {
        this.assento = assento;
    }

    public boolean isPaga() {
        return paga;
    }

    public void setPaga(boolean paga) {
        this.paga = paga;
    }

    public boolean isCheckin() {
        return checkin;
    }

    public void setCheckin(boolean checkin) {
        this.checkin = checkin;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Programacao getProgramacao() {
        return programacao;
    }

    public void setProgramacao(Programacao programacao) {
        this.programacao = programacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Reclamacao getReclamacao() {
        return reclamacao;
    }

    public void setReclamacao(Reclamacao reclamacao) {
        this.reclamacao = reclamacao;
    }
    
    boolean cancelar(){
        return true;
    }
    
    boolean checkin(){
        return true;
    }
    
    boolean pagar(){
        return true;
    }
    
    boolean fazerReclamcao(String reclamacao){
        return true;
    }
    
    Reclamacao consultarReclamacao(String codReclamacao){
        return new Reclamacao();
    }
    
    boolean addOnDb(){ 
        return true;
    }
    
    boolean getFromDb(){
        return true;
    }
}
