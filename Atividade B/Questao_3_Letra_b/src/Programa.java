/**
 * Created by aluno on 09/11/17.
 */
public class Programa {

    public static void main(String[] args) {

        ContaBancaria cliente = new ContaBancaria();
        cliente.titular.nome = "Paulo";
        cliente.titular.idade = 17;
        cliente.titular.cpf = "789.879.578-52";
        cliente.titular.dataEntrada = "05/07/2017";
        cliente.titular.saldo = 0;

        cliente.informarTitular();

        cliente.depositar(1000);
        cliente.sacar(500);

        cliente.informarTitular();
    }
}
