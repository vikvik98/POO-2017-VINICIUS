public class Conta {

    int numeroConta;
    double saldo;
    double limite;
    Cliente titular = new Cliente();

    boolean sacar (double quantidade){
        if (quantidade > this.saldo){
            return false;

        }else{
            this.saldo -= quantidade;
            return  true;
        }
    }


    boolean depositar (double quantidade){
        this.saldo += quantidade;
        return true;
    }

    boolean transferirPara(Conta y, double quantidade){
        boolean retirar = this.sacar(quantidade);
        if(retirar == false){
            System.out.println("Não foi possivel transferirPara!");
            return false;
        }else{
            y.depositar(quantidade);
            return true;
        }
    }
}
