package model;

import java.util.List;

public class EditorChefe extends Editor {

    public EditorChefe(String email, String senha, String area) {
        super(email, senha, area);
    }

    public void revisarNoticia(Noticia noticia, List<Noticia> noticias, boolean noticiaPrincipal, boolean noticiaDestaque){
        noticia.setNoticiaPrincipal(noticiaPrincipal);
        if(noticiaDestaque == true){
            noticia.setDestaque(noticiaDestaque);
            noticia.setCor("Vermelho");
        }
        noticia.setCicloDeVida("Publicada");
        noticias.add(noticia);
    }

}
