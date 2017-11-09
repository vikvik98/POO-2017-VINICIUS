public class Funcionarios {
    String nome;
    String departamento;
    double salario;
    Data entrada = new Data();
    String rg;

    void recebeAumento(double valor){
        this.salario += valor;
    }

    double ganhoAnual(){
        return (salario * 12);
    }

    void mostrarDados(){
        System.out.println("O salario atual de " + this.nome + " = " + this.salario);
        System.out.println("O salario anual de " + this.nome + " = " + this.ganhoAnual());
        System.out.println("Data de entrada " + this.entrada.dia + "/" + this.entrada.mes + "/" + this.entrada.ano);
    }
}
