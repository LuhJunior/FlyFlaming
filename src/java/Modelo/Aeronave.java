package Modelo;

import Banco.AeronaveDAO;

public class Aeronave {
    String prefixo;
    int capacPrimeira, capacEconomica, fileiras, colunas;
    Companhia empresa;

    public Aeronave() {
    }

    public Aeronave(String prefixo, int capacPrimeira, int capacEconomica, int fileiras, int colunas) {
        this.prefixo = prefixo;
        this.capacPrimeira = capacPrimeira;
        this.capacEconomica = capacEconomica;
        this.fileiras = fileiras;
        this.colunas = colunas;
    }

    public String getPrefixo() {
        return prefixo;
    }

    public void setPrefixo(String prefixo) {
        this.prefixo = prefixo;
    }

    public int getCapacPrimeira() {
        return capacPrimeira;
    }

    public void setCapacPrimeira(int capacPrimeira) {
        this.capacPrimeira = capacPrimeira;
    }

    public int getCapacEconomica() {
        return capacEconomica;
    }

    public void setCapacEconomica(int capacEconomica) {
        this.capacEconomica = capacEconomica;
    }

    public int getFileiras() {
        return fileiras;
    }

    public void setFileiras(int fileiras) {
        this.fileiras = fileiras;
    }

    public int getColunas() {
        return colunas;
    }

    public void setColunas(int colunas) {
        this.colunas = colunas;
    }

    public Companhia getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Companhia empresa) {
        this.empresa = empresa;
    }
    int qtdLugaresDiponiveis(){
        return 40;
    }
    boolean verificarAssento(String assento){
        return true;
    }

    public boolean pegarAeronave(){
        AeronaveDAO a = new AeronaveDAO();
        a.pesquisar(this);
        return true;
    }
    
    boolean addOnDb(){ 
        return true;
    }
    
    boolean getFromDb(){
        return true;
    }
}
