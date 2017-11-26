public class Programa {
    public static void main(String[] args) {

        Casa c1 = new Casa();
        Porta p1 = new Porta();
        p1.situação = true;
        Porta p2 = new Porta();
        p2.situação = false;
        Porta p3 = new Porta();
        p3.situação = true;

        c1.pinta("Verde");
        c1.adicionaPorta(p1);
        c1.adicionaPorta(p2);
        c1.adicionaPorta(p3);

        c1.status();


    }
}
