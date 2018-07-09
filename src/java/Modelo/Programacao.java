package Modelo;

import Banco.ProgramacaoDAO;
import java.sql.Date;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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

    public String getDataChegada() throws ParseException {
        String outputText = "";
        if(dataChegada != null){
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");  
            SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date data = fmt.parse(dataChegada); 
            outputText = outputFormat.format(data); 
        }
        return outputText;
    }

    public void setDataChegada(String dataChegada) {
        this.dataChegada = dataChegada;
    }

    public String getDataSaida() throws ParseException {
        String outputText = "";
        if(dataSaida != null){
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");  
            SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date data = fmt.parse(dataSaida); 
            outputText = outputFormat.format(data); 
        }
        return outputText;
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
    
    public boolean pegarProgramacao(){
        ProgramacaoDAO p = new ProgramacaoDAO();
        p.pesquisar(this);
        return true;
    }
}
