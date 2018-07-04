package Modelo;


public class Mensagem {
    String Mensagem, Erro;

    public Mensagem(String Mensagem, String Erro) {
        this.Mensagem = Mensagem;
        this.Erro = Erro;
    }

    public Mensagem() {
    }

    public String getMensagem() {
        return Mensagem;
    }

    public void setMensagem(String Mensagem) {
        this.Mensagem = Mensagem;
    }

    public String getErro() {
        return Erro;
    }

    public void setErro(String Erro) {
        this.Erro = Erro;
    }
    
}
