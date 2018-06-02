package Modelo;

import Banco.ClienteDAO;
import java.util.Calendar;

public class Cliente {
    String nome, cpf, email, telefone, senha;
    Calendar dataNascimento;

    public Cliente() {
    }

    public Cliente(String nome, String cpf, String email, String telefone, Calendar dataNascimento, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    public boolean comprarPassagem(){
        return true;
    }
    
    public boolean addOnDb(){ 
        return true;
    }
    
    public boolean validarCliente() {
        ClienteDAO cli = new ClienteDAO();
        return cli.validarCliente(this);
    }
    
    public Cliente autenticarCliente() {
        ClienteDAO cli = new ClienteDAO();
        return cli.pesquisarCpfSenha(this);
    }
    
    public boolean getFromDb(){
        ClienteDAO c = new ClienteDAO();
        c.pesquisar(this);
        return (c != null);
    }
    
    public boolean trocarSenha(){
        ClienteDAO c = new ClienteDAO();
        c.updateSenha(this);
        return true;
    }
}
