package model;

public class Noticia {

    private String titulo;
    private String autor;
    private String area;
    private String cor;
    private String cicloDeVida;
    private String data;
    private String resumo;
    private boolean aprovado;
    private boolean noticiaPrincipal;
    private boolean destaque;



    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public boolean isAprovado() {
        return aprovado;
    }

    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }

    public boolean isNoticiaPrincipal() {
        return noticiaPrincipal;
    }

    public void setNoticiaPrincipal(boolean noticiaPrincipal) {
        this.noticiaPrincipal = noticiaPrincipal;
    }

    public boolean isDestaque() {
        return destaque;
    }

    public void setDestaque(boolean destaque) {
        this.destaque = destaque;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getCicloDeVida() {
        return cicloDeVida;
    }

    public void setCicloDeVida(String cicloDeVida) {
        this.cicloDeVida = cicloDeVida;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }
}