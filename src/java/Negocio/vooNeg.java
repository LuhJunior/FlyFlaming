package Negocio;

/**
 *
 * @author Diego Malta
 */
public class vooNeg {
    private int numVoo;
    private double valorPassagem;
    private String destino, origem, prefixo, data, hora;
    private vooNeg semana[] = new vooNeg[5];
            
    public vooNeg[] pesquisarVoosSemana() {        
        this.semana[0] = new vooNeg(265, 485.26, "São Paulo", "Salvador", "265-SP", "12/05/2018", "12:25");
        this.semana[1] = new vooNeg(895, 857.98, "Belo Horizonte", "Sergipe", "895-BH", "25/05/2018", "22:05");
        this.semana[2] = new vooNeg(654, 485.26, "São Paulo", "Rio de Janeiro", "654-SP", "22/05/2018", "08:40");   
        
        return semana;
    }
    
    public vooNeg[] getSemana() {
        return semana;
    }

    public void setSemana(vooNeg[] semana) {
        this.semana = semana;
    }
    
    public vooNeg() {
    }

    public vooNeg(int numVoo, double valorPassagem, String destino, String origem, String prefixo, String data, String hora) {
        this.numVoo = numVoo;
        this.valorPassagem = valorPassagem;
        this.destino = destino;
        this.origem = origem;
        this.prefixo = prefixo;
        this.data = data;
        this.hora = hora;
    }

    public int getNumVoo() {
        return numVoo;
    }

    public void setNumVoo(int numVoo) {
        this.numVoo = numVoo;
    }

    public double getValorPassagem() {
        return valorPassagem;
    }

    public void setValorPassagem(float valorPassagem) {
        this.valorPassagem = valorPassagem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getPrefixo() {
        return prefixo;
    }

    public void setPrefixo(String prefixo) {
        this.prefixo = prefixo;
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
    
    
}
