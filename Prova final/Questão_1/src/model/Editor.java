package model;

public class Editor extends Pessoa {
    private String area;

    public Editor(String email, String senha, String area) {
        super(email, senha);
        this.area = area;

    }

    public void aprovarNoticia(Noticia noticia, boolean aprovado, String data){
        if (noticia.getArea() == this.getArea()){
            if(aprovado == true){
                noticia.setAprovado(aprovado);
                noticia.setCicloDeVida("Pronto para revisão");
            }else{
                noticia.setCicloDeVida("Desativado");
            }
            noticia.setData(data);
        }

    }


    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
