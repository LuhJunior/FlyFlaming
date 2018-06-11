package Modelo;

import Banco.PassagemDAO;
import Banco.ReclamacaoDAO;
import java.util.Calendar;

public class Passagem {
    int codigo;
    String assento;
    boolean paga, checkin, cancelada;
    float valor;
    String horaCompra;
    Programacao programacao;
    Reclamacao reclamacao;

    public Passagem() {
    }

    public Passagem(String assento, boolean paga, boolean checkin, float valor, Programacao programacao, Cliente cliente, Reclamacao reclamacao) {
        this.assento = assento;
        this.paga = paga;
        this.checkin = checkin;
        this.valor = valor;
        this.programacao = programacao;
        this.reclamacao = reclamacao;
    }

    public boolean isCancelada() {
        return cancelada;
    }

    public void setCancelada(boolean cancelada) {
        this.cancelada = cancelada;
    }

    public String getHoraCompra() {
        return horaCompra;
    }

    public void setHoraCompra(String horaCompra) {
        this.horaCompra = horaCompra;
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

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int Codigo) {
        this.codigo = Codigo;
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

    public Reclamacao getReclamacao() {
        return reclamacao;
    }

    public void setReclamacao(Reclamacao reclamacao) {
        this.reclamacao = reclamacao;
    }
    
    public boolean cancelar(){
        PassagemDAO p = new PassagemDAO();
        p.updateCancelamento(this);
        return true;
    }
    
    public boolean checkin(){
        PassagemDAO p = new PassagemDAO();
        return p.updateCheckin(this);
    }
    
    public boolean pagar(){
        return true;
    }
    
    public boolean fazerReclamcao(String reclamacao){
        return true;
    }
    
    public boolean consultarReclamacao(){
        this.setReclamacao(new Reclamacao());
        this.getReclamacao().getFromDb(this.codigo);
        return true;
    }
    
    public boolean inserirDados(){ 
        return true;
    }
    
    public static Passagem[] buscarDados(String cpf){
        PassagemDAO p = new PassagemDAO();
        return p.getFromDb(cpf);
    }
    
    public static Passagem[] buscarPassagens(String cpf){
        PassagemDAO p = new PassagemDAO();
        return p.pegarPassagens(cpf);
    }
    
    public static Passagem[] buscarPassagensComReclamacao(String cpf){
        PassagemDAO p = new PassagemDAO();
        return p.pegarPassagensComReclamcao(cpf);
    }
    
    public boolean buscarDados(){
        this.setProgramacao(new Programacao());
        PassagemDAO p = new PassagemDAO();
        p.getFromDb(this);
        return true;
    }
}
