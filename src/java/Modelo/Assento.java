package Modelo;

import Banco.AssentoDAO;

/**
 *
 * @author Júnior
 */
public class Assento {
    int fileira, cadeira, numero;
    String tipo;

    public Assento() {
    }

    public Assento(int fileira, int cadeira, int numero, String tipo) {
        this.fileira = fileira;
        this.cadeira = cadeira;
        this.numero = numero;
        this.tipo = tipo;
    }

    public int getFileira() {
        return fileira;
    }

    public void setFileira(int fileira) {
        this.fileira = fileira;
    }

    public int getCadeira() {
        return cadeira;
    }

    public void setCadeira(int cadeira) {
        this.cadeira = cadeira;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public void pegarAssento(){
        AssentoDAO a = new AssentoDAO();
        a.pegarAssento(this);
    }
}
