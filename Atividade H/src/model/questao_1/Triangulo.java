package model.questao_1;

/**
 * Created by aluno on 18/12/17.
 */
public class Triangulo implements FiguraGeometrica, Comparavel {
    double lado;
    double base;

    @Override
    public int comparar(Triangulo t, Quadrado q) {
        if (q.calculaArea() > t.calculaArea()){
            return -1;
        }
        if (q.calculaArea() < t.calculaArea()){
            return 1;
        }
        return 0;
    }

    @Override
    public double calculaPerimetro() {
        return this.lado*3;
    }

    @Override
    public double calculaArea() {
        return (base*lado)/2;
    }
}
