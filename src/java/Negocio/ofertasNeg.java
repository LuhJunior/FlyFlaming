package Negocio;

/**
 *
 * @author Diego Malta
 */
public class ofertasNeg {
    private String local, descricao, imagem;

    public ofertasNeg(String local, String descricao, String imagem) {
        this.local = local;
        this.descricao = descricao;
        this.imagem = imagem;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
    
    
}
