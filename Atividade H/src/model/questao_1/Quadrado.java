package model.questao_1;

/**
 * Created by aluno on 18/12/17.
 */
public class Quadrado implements FiguraGeometrica{
    double lado;
    @Override
    public double calculaArea() {
        return this.lado*this.lado;
    }

    @Override
    public double calculaPerimetro() {
        return this.lado*4;
    }
}
