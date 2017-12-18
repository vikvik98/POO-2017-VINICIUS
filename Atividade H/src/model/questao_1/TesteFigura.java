package model.questao_1;

/**
 * Created by aluno on 18/12/17.
 */
public class TesteFigura {
    public static void main(String[] args) {
        Quadrado q = new Quadrado();
        q.lado = 10;
        Triangulo t = new Triangulo();
        t.lado = 10;
        t.base = 5;
        System.out.println(q.calculaArea());
        System.out.println(t.calculaArea());
        System.out.println(q.calculaPerimetro());
        System.out.println(t.calculaPerimetro());
    }
}
