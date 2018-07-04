package Modelo;

import Banco.PagamentoDAO;
import Banco.PassagemDAO;
import Banco.ReclamacaoDAO;
import java.util.Calendar;

public class Passagem {
    int codigo, codigoVolta;
    boolean paga;
    float valor;
    String horaCompra, checkin, cancelamento;
    Programacao programacao;
    Assento assento;
    Reclamacao reclamacao;

    public Passagem() {
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        if(checkin == null) checkin = "Pendente";
        this.checkin = checkin;
    }

    public int getCodigoVolta() {
        return codigoVolta;
    }

    public void setCodigoVolta(int codigoVolta) {
        this.codigoVolta = codigoVolta;
    }

    public String getCancelamento() {
        return cancelamento;
    }

    public void setCancelamento(String cancelada) {
        if(cancelada == null) cancelada = "Pedente";
        this.cancelamento = cancelada;
    }

    public Assento getAssento() {
        return assento;
    }

    public void setAssento(Assento assento) {
        this.assento = assento;
    }

    public String getHoraCompra() {
        return horaCompra;
    }

    public void setHoraCompra(String horaCompra) {
        this.horaCompra = horaCompra;
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
    
    public boolean fazerReclamcao(String reclamacao){
        return true;
    }
    
    public boolean consultarReclamacao(){
        this.setReclamacao(new Reclamacao());
        if(!this.getReclamacao().getFromDb(this.codigo)) this.setReclamacao(null);
        return true;
    }
    
    public boolean pagarPassagem(){ 
        PassagemDAO p = new PassagemDAO();
        return p.pagar(this);
    }

    public boolean inserirPassagem(String cpf){ 
        PassagemDAO p = new PassagemDAO();
        return p.inserir(this, cpf);
    }
    
    public boolean inserirVooVolta(){
        PassagemDAO p = new PassagemDAO();
        return p.updateVooVolta(this);
    }
    
    public boolean inserirPassagemSemAssento(String cpf, String tAssento){ 
        PassagemDAO p = new PassagemDAO();
        p.inserirSemAssento(this, cpf, tAssento);
        return true;
    }
    
    public boolean atualizaAssento(){
        PassagemDAO p = new PassagemDAO();
        return p.updateAssento(this);
    }
    
    public static Passagem[] buscarDados(String cpf){
        return PassagemDAO.pegarPassagensDoCliente(cpf);
    }
    
    public static Passagem[] buscarPassagens(String cpf){
        return PassagemDAO.pegarPassagensNaoCanceladasDoCliente(cpf);
    }
    
    public static Passagem[] buscarPassagensPelaData(String data){
        return PassagemDAO.pegarPassagensPelaData(data);
    }
    
    public static Passagem[] buscarPassagensComReclamacao(String cpf){
        return PassagemDAO.pegarPassagensComReclamacao(cpf);
    }
    
    public boolean buscarDados(){
        this.setProgramacao(new Programacao());
        PassagemDAO p = new PassagemDAO();
        p.pegarPassagem(this);
        return true;
    }
    
    public static boolean cancelarPassagemSemCheckin(){
        return PassagemDAO.updatePassagemCancelamento();
    }
    
    public float pegarPercentEstorno(){
        PassagemDAO p = new PassagemDAO();
        return p.pegarPercent(this);
    }
    
    public boolean estornarValorPassagem(){
        PagamentoDAO p = new PagamentoDAO();
        return p.updateValor(this);
    }
}
