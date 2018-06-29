package Modelo;

import Banco.VooDAO;
import Banco.VooDAO;
import Modelo.Aeronave;
import Modelo.Programacao;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Voo {
    int numero;
    String origem, destino;
    double valor;
    //ArrayList<Programacao> programacao;
    Programacao programacao;
    Aeronave aviao;

    public Voo() {
    }

    public Voo(String origem, String destino, float valor, Aeronave aviao) {
        this.origem = origem;
        this.destino = destino;
        this.valor = valor;
        this.aviao = aviao;
    }

    public Programacao getProgramacao() {
        return programacao;
    }

    public void setProgramacao(Programacao programacao) {
        this.programacao = programacao;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public double getValor() {
        return valor;
    }
    
    public String getValorFormat() {
        DecimalFormat df = new DecimalFormat("#0.00");  
        return df.format(this.valor);
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Aeronave getAviao() {
        return aviao;
    }

    public void setAviao(Aeronave aviao) {
        this.aviao = aviao;
    }
    
    public boolean inserirVoo(){
        return true;
    }
    
    public boolean pegarVoo(){
        VooDAO v = new VooDAO();
        v.pesquisar(this);
        return true;
    }
    
    public static ArrayList<Voo> pegarVooPelaData(String data){
        return VooDAO.pesquisarVoosPelaData(data);
    }
    
    public static ArrayList<Voo> pegarVoosDaSemana(){
        ArrayList<Voo> arrayVooOfertas = new ArrayList<Voo>(VooDAO.pesquisarVoosDaSemana().subList(0,9));
        return arrayVooOfertas;
    }
    
    public static ArrayList<Voo> pegarVoos(){
        return VooDAO.pesquisarVoos();
    }
    
}
