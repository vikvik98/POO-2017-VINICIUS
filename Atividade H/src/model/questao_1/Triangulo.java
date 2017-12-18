package model.questao_1;

/**
 * Created by aluno on 18/12/17.
 */
public class Triangulo implements FiguraGeometrica {
    double lado;
    double base;
    @Override
    public double calculaPerimetro() {
        return this.lado*3;
    }

    @Override
    public double calculaArea() {
        return (base*lado)/2;
    }
}
