package model;

public class Jornalista extends Pessoa{
    private String nome;

    public Jornalista(String nome, String email, String senha) {
        super(email,senha);
        this.nome = nome;
    }

    public void criarNoticia(Noticia noticia,String titulo, String area, String cor, String data, String resumo){
        noticia.setAutor(this.getNome());
        noticia.setTitulo(titulo);
        noticia.setArea(area);
        noticia.setCor(cor);
        noticia.setCicloDeVida("Criada");
        noticia.setData(data);
        noticia.setResumo(resumo);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
