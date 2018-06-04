package Modelo;

public class PassagemExecutiva extends Passagem{

    public PassagemExecutiva() {
    }

    public PassagemExecutiva(String assento, boolean paga, boolean checkin, float valor, Programacao programacao, Cliente cliente, Reclamacao reclamacao) {
        super(assento, paga, checkin, valor, programacao, cliente, reclamacao);
    }

    @Override
    public String getAssento() {
        return assento;
    }

    @Override
    public void setAssento(String assento) {
        this.assento = assento;
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
    public boolean isCheckin() {
        return checkin;
    }

    @Override
    public void setCheckin(boolean checkin) {
        this.checkin = checkin;
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
