public class ContaCorrente extends Conta {

    public void atualiza(double taxa) {
        this.saldo += this.saldo * taxa * 2;
    }
    public void deposita(double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("Você tentou depositar" +
                    " um valor negativo");
        } else {
            this.saldo += valor;
        }
    }

    @Override
    public void saca(double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("Você tentou sacar um valor negativo");
        }
        if (this.saldo < valor) {
            throw new SaldoInsuficienteException();
        }
        this.saldo -= (valor + 0.10);
    }



}
