package Model.Questao_6;

/**
 * Created by aluno on 14/12/17.
 */
public class ContaCorrente extends Conta {
    int numConta;
    double saldo;

    @Override
    public void debito(double valor) {
        this.saldo -= valor;
    }

    @Override
    public void saque(double valor) {
        this.saldo -= valor;
    }
}
