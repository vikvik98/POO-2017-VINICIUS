/**
 * Created by aluno on 23/11/17.
 */
public class Empresa {

    String nome;
    String cnpj;
    int cont = 0;
    Funcionarios[] empregados = new Funcionarios[cont];


    void adiciona(Funcionarios f){

        this.empregados[cont] = f;
        cont++;

    }

    void mostrarEmpregados(){
        for (int i = 0; i < this.empregados.length; i++) {
            System.out.println("Funcionario na posição " + i);
            System.out.println("Nome do funcionario: " + empregados[i].nome);
            System.out.println("Salario do funionario: " + empregados[i].salario);
            
        }
    }
}
