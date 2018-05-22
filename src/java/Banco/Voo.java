package flyflaming;

public class Voo {
    String origem, destino;
    float valor;
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

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
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
