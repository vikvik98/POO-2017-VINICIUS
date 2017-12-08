public class Funcionario extends Pessoa {
    private int matricula;
    private double salario;

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getMatricula() {
        return matricula;
    }

    public double getSalario() {
        return salario;
    }

    public double getPrimeiraParcela(){
        return salario * 0.6;
    }

    public double getSegundaParcela(){
        return salario * 0.4;
    }
}
