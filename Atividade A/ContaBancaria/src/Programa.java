public class Programa {
    public static void main(String[] args) {

        Conta minhaConta;
        minhaConta = new Conta();
        minhaConta.titular.nome = "Vinicius Tortao";
        minhaConta.saldo = 400.00;

        Conta conta2 = new Conta();
        conta2.titular.nome = "Daneal Cabeça De Caramelo";
        conta2.saldo = 500.00;

        minhaConta.sacar(300.00);
        minhaConta.depositar(400.00);

        conta2.sacar(200);
        conta2.depositar(100);

        minhaConta.transferirPara(conta2, 300);

        System.out.println("A conta de " + minhaConta.titular.nome + " possui R$ " + minhaConta.saldo + " de saldo.");
        System.out.println("A conta de " + conta2.titular.nome + " possui R$ " + conta2.saldo + " de saldo.");
    }
}
