/**
 * Created by aluno on 09/11/17.
 */
public class ContaBancaria {

    Titular titular = new Titular();

    void informarTitular(){

        System.out.println("Nome: " + this.titular.nome);
        System.out.println("Idade: " + this.titular.idade);
        System.out.println("CPF: " + this.titular.cpf);
        System.out.println("Data da entrada: " + this.titular.dataEntrada);
        System.out.println("Saldo: " + this.titular.saldo);

    }


    void sacar(double valor){
        if(valor <= this.titular.saldo){
            this.titular.saldo -= valor;

        }else{
            System.out.println("Você não tem saldo suficiente para sacar!!");
        }
    }


    void depositar(double valor){
        this.titular.saldo += valor;
    }
}
