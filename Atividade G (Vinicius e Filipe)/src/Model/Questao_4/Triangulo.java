package Model.Questao_4;

/**
 * Created by aluno on 14/12/17.
 */
public class Triangulo extends FiguraGeometrica {
    double lado;


    @Override
    public double calcularPerimetro() {
        return lado*3;
    }

    @Override
    public double calcularArea() {
        return (lado*lado)/2;
    }
}
