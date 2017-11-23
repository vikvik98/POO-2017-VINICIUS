public class Programa {
    public static void main(String[] args) {

        Empresa mister = new Empresa();
        mister.empregados = new Funcionarios[10];

        Funcionarios f1 = new Funcionarios();
        f1.nome = "Paulo Não Muda Nada";
        f1.departamento = "B2";
        f1.salario = 1000.00;
        f1.entrada.dia = 23;
        f1.entrada.mes = 05;
        f1.entrada.ano = 2017;
        f1.rg = "666-666-66";
        mister.adiciona(f1);

        Funcionarios f2 = new Funcionarios();
        f2.nome = "Jesus Tortao";
        f2.departamento = "B2";
        f2.salario = 3000.00;
        f2.entrada.dia = 23;
        f2.entrada.mes = 05;
        f2.entrada.ano = 2017;
        f2.rg = "111-111-11";
        mister.adiciona(f2);

        mister.mostrarEmpregados();
    }
}
