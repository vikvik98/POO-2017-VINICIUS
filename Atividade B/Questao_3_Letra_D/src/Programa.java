/**
 * Created by aluno on 09/11/17.
 */
public class Programa {
    public static void main(String[] args) {

        Cargo c = new Cargo();
        c.cargo = "Medico";
        c.salario = 100000;
        c.funcionario.nome = "Jesus";
        c.funcionario.idade = 19;

        c.informarCargo();
        c.ganhaBem();
    }
}
