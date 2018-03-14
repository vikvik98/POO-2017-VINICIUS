package model;


import java.util.List;

public class Timeline {


    public Noticia noticiaPrincipal(List<Noticia> noticias){
        try{
            for (Noticia noticia : noticias){
                if (noticia.isNoticiaPrincipal()){
                    return noticia;
                }

            }
        }catch (NullPointerException e){
            System.out.println("Error: " + e);
        }
        return null;

    }

    public void noticiasDestaque(List<Noticia> noticias, List<Noticia> noticiasDestaque){
        for(Noticia noticia : noticias){
            if (noticia.isDestaque()){
                noticiasDestaque.add(noticia);
            }
        }
    }

    public void noticiasAssociadas(Noticia noticia, List<Noticia> noticias, List<Noticia> noticiasAssociadas){
        int cont = 0; //Contador para saber se passou das 10 noticias
        for(Noticia n : noticias){
            if (noticia.getArea() == n.getArea()){
                noticiasAssociadas.add(n);
                cont += 1;
                if (cont > 10){
                    break;
                }
            }
        }
    }

}
