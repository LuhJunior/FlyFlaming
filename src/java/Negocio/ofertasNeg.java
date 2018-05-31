package Negocio;

/**
 *
 * @author Diego Malta
 */
public class ofertasNeg {
    private String local, descricao, imagem;
    private ofertasNeg semana[] = new ofertasNeg[6];
            
    public ofertasNeg[] pesquisarOfertaSemana() {        
        this.semana[0] = new ofertasNeg("Bahia", "A partir de R$ 200,00 à vista", "");
        this.semana[1] = new ofertasNeg("Belo Horizonte", "A partir de R$ 250,00 à vista", "");
        this.semana[2] = new ofertasNeg("Rio de Janeiro", "A partir de R$ 123,00 à vista", "");
        this.semana[3] = new ofertasNeg("New York", "A partir de R$ 658,23 à vista", "");
        this.semana[4] = new ofertasNeg("Brasilia", "A partir de R$ 80,15 à vista", "");
        this.semana[5] = new ofertasNeg("Londres", "A partir de R$ 289,78 à vista", "");
        
        return semana;
    }

    public ofertasNeg[] getSemana() {
        return semana;
    }

    public void setSemana(ofertasNeg[] semana) {
        this.semana = semana;
    }
    
    public ofertasNeg() {}
    
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
