package Modelo;

import Banco.ClienteDAO;
import Banco.VooDAO;
import java.util.Arrays;
import java.util.Calendar;

public class Cliente {
    String nome, cpf, email, telefone, senha;
    Calendar dataNascimento;
    Endereco endereco;
    Passagem passagens[];
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
    
    public String getOneNome() {
        String array[] = new String[5];
        array = nome.split(" ");
        return array[0];
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Passagem[] getPassagens() {
        return passagens;
    }

    public void setPassagens(Passagem[] passagens) {
        this.passagens = passagens;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
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
    
    public boolean comprarPassagem(int NumVoo){
        Voo v = new Voo();
        Passagem p = new Passagem();
        v.setNumero(NumVoo);
        if(!v.pegarVoo()) return false;
        p.setProgramacao(v.getProgramacao());
        p.setValor(v.getValor());
        return p.inserirPassagem(this.getCpf());
    }
    
    public boolean addOnDb(){
        ClienteDAO c = new ClienteDAO();
        c.pesquisarEndereco(this);
        if(!c.verificarCEP(this.getEndereco().getCEP())) c.inserirEndereco(this);
        return (c.inserir(this) && c.inserirTelefone(this));
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
        if(this != null){
            c.pesquisarEndereco(this);
            return true;
        }
        return false;
    }
    
    public boolean trocarSenha(){
        ClienteDAO c = new ClienteDAO();
        c.updateSenha(this);
        return true;
    }
    
    public boolean atualizarDados(){
        ClienteDAO c = new ClienteDAO(); 
        if(!c.verificarCEP(this.getEndereco().getCEP())) c.inserirEndereco(this);
        return c.updateCliente(this) && c.updateTelefone(this);
    }
}
