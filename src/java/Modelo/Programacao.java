package Modelo;

import Banco.ProgramacaoDAO;

public class Programacao {
    int quantidadeEcon, quantidadeExec, id;
    String dataChegada, dataSaida, horaChegada, horaSaida;
    
    public Programacao() {
    }

    public Programacao(String horaChegada, String horaSaida, Voo voo) {
        this.horaChegada = horaChegada;
        this.horaSaida = horaSaida;
    }

    public int getQuantidadeEcon() {
        return quantidadeEcon;
    }

    public void setQuantidadeEcon(int quantidadeEcon) {
        this.quantidadeEcon = quantidadeEcon;
    }

    public String getDataChegada() {
        return dataChegada;
    }

    public void setDataChegada(String dataChegada) {
        this.dataChegada = dataChegada;
    }

    public String getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }

    public int getQuantidadeExec() {
        return quantidadeExec;
    }

    public void setQuantidadeExec(int quantidadeExec) {
        this.quantidadeExec = quantidadeExec;
    }

    public String getHoraChegada() {
        return horaChegada;
    }

    public void setHoraChegada(String horaChegada) {
        this.horaChegada = horaChegada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(String horaSaida) {
        this.horaSaida = horaSaida;
    }

    public boolean reservarAssento(String assento){
        return true;
    }
    
    public boolean inserirProgramacao(){ 
        ProgramacaoDAO p = new ProgramacaoDAO();
        return true;
    }
    
    public boolean pegarProgramacao(int ID){
        ProgramacaoDAO p = new ProgramacaoDAO();
        return true;
    }
}
