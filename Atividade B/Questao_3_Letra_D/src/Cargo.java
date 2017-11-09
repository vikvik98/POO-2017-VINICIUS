/**
 * Created by aluno on 09/11/17.
 */
public class Cargo {
    String cargo;
    double salario;
    Funcionario funcionario = new Funcionario();

    void informarCargo(){
        System.out.println("Cargo de " + this.cargo);
        System.out.println("O salario é de " + this.salario + " reais.");
        System.out.println("Quem cupa este cargo é o " + this.funcionario.nome);
        System.out.println("Que tem " + this.funcionario.idade);
    }

    void ganhaBem(){
        if(salario > 10000){
            System.out.println(this.funcionario.nome + " ganha bem!!");

        }else{
            System.out.println(this.funcionario.nome + " ganha mal!!!");
        }
    }
}
