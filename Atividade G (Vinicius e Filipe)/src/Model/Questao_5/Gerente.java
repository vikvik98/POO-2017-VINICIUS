package Model.Questao_5;

/**
 * Created by aluno on 14/12/17.
 */
public class Gerente extends Funcionario  {
    double perBonificacao;

    @Override
    public double getBonificacao() {
        return super.bonicacao*(perBonificacao /100);

    }
}
