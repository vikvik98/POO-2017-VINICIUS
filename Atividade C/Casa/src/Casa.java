public class Casa {

    String cor;
    Porta[] portas = new Porta[10];
    int qntPortas = 0;


    void pinta(String s){
        this.cor = s;
    }

    int quantasPortasEstaoAberta(){
        int cont = 0;
        for (Porta x : portas) {
            if (x != null){
                if(x.situação == true){
                    cont++;
                }

            }
        }
        return cont;
    }

    void adicionaPorta(Porta p){
        for (Porta x : this.portas) {
            x = p;
        }
        this.qntPortas++;
    }

    void status(){
        System.out.println("Cor = " + cor);
        System.out.println("Quantidade total de portas = " + qntPortas);
        System.out.println("Quantidade de portas abertas = " + quantasPortasEstaoAberta());
    }
}
