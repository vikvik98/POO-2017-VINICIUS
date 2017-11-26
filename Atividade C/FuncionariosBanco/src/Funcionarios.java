public class Funcionarios {

    private String nome;
    private String departamento;
    private double salario;
    private Data entrada = new Data();
    private String rg;

    public Funcionarios() {
    }

    public Funcionarios(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String getDepartamento() {
        return departamento;
    }

    public double getSalario() {
        return salario;
    }

    public Data getEntrada() {
        return entrada;
    }

    public String getRg() {
        return rg;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEntrada(Data entrada) {
        this.entrada = entrada;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

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
