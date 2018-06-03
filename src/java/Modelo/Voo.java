package Modelo;

public class Voo {
    int numero;
    String origem, destino, data, hora;
    double valor;
    Aeronave aviao;

    public Voo() {
    }

    public Voo(String origem, String destino, float valor, Aeronave aviao) {
        this.origem = origem;
        this.destino = destino;
        this.valor = valor;
        this.aviao = aviao;
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public double getValor() {
        return valor;
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
    
    boolean addOnDb(){ 
        return true;
    }
    
    boolean getFromDb(){
        return true;
    }
}
