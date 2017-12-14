package Model.Questao_4;

/**
 * Created by aluno on 14/12/17.
 */
public class Quadrado extends FiguraGeometrica {
    double lado;

    @Override
    public double calcularArea() {
        return lado*lado;
    }

    @Override
    public double calcularPerimetro() {
        return lado*4;
    }
}
