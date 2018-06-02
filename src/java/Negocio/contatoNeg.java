package Negocio;

/**
 *
 * @author Diego Malta
 */
public class contatoNeg {
    private String nome, email, assunto, descricao;

    public contatoNeg(String nome, String email, String assunto, String descricao) {
        this.nome = nome;
        this.email = email;
        this.assunto = assunto;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}
