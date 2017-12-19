package model.questao_1;

/**
 * Created by aluno on 18/12/17.
 */
public class Quadrado implements FiguraGeometrica,Comparavel{
    double lado;

    @Override
    public int comparar(Triangulo t, Quadrado q) {
        if (q.calculaArea() < t.calculaArea()){
            return -1;
        }
        if (q.calculaArea() > t.calculaArea()){
            return 1;
        }
        return 0;
    }

    @Override
    public double calculaArea() {
        return this.lado*this.lado;
    }

    @Override
    public double calculaPerimetro() {
        return this.lado*4;
    }
}
