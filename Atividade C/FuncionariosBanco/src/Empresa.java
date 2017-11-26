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
            if(empregados[i] != null){
                System.out.println("Funcionario na posição " + i);
                System.out.println("Nome do funcionario: " + empregados[i].getNome());
                System.out.println("Salario do funionario: " + empregados[i].getSalario());
            }

        }
    }

    boolean contem(Funcionarios f){
        for (Funcionarios x: empregados) {
            if(x == f){
                System.out.println("Contem!!");
                return true;
            }
        }
        return false;
    }
}
