package Modelo;

import Modelo.Voo;
import java.util.Calendar;

public class Programacao {
    Calendar horaChegada, horaSaida;
    Voo voo;

    public Programacao() {
    }

    public Programacao(Calendar horaChegada, Calendar horaSaida, Voo voo) {
        this.horaChegada = horaChegada;
        this.horaSaida = horaSaida;
        this.voo = voo;
    }

    public Calendar getHoraChegada() {
        return horaChegada;
    }

    public void setHoraChegada(Calendar horaChegada) {
        this.horaChegada = horaChegada;
    }

    public Calendar getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(Calendar horaSaida) {
        this.horaSaida = horaSaida;
    }

    public Voo getVoo() {
        return voo;
    }

    public void setVoo(Voo voo) {
        this.voo = voo;
    }
    
    public boolean reservarAssento(String assento){
        return true;
    }
    
    public boolean addOnDb(){ 
        return true;
    }
    
    public boolean getFromDb(int id){
        
        return true;
    }
}
