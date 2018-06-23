package Modelo;

public class PassagemExecutiva extends Passagem{

    public PassagemExecutiva() {
    }

    @Override
    public boolean isPaga() {
        return paga;
    }

    @Override
    public void setPaga(boolean paga) {
        this.paga = paga;
    }

    @Override
    public float getValor() {
        return valor;
    }

    @Override
    public void setValor(float valor) {
        this.valor = valor;
    }

    @Override
    public Programacao getProgramacao() {
        return programacao;
    }

    @Override
    public void setProgramacao(Programacao programacao) {
        this.programacao = programacao;
    }

    @Override
    public Reclamacao getReclamacao() {
        return reclamacao;
    }

    @Override
    public void setReclamacao(Reclamacao reclamacao) {
        this.reclamacao = reclamacao;
    }
    
}
