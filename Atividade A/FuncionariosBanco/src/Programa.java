public class Programa {
    public static void main(String[] args) {

        Funcionarios f1 = new Funcionarios();
        f1.nome = "Paulo Não Muda Nada";
        f1.departamento = "B2";
        f1.salario = 1000.00;
        f1.entrada.dia = 23;
        f1.entrada.mes = 05;
        f1.entrada.ano = 2017;
        f1.rg = "666-666-66";

        f1.mostrarDados();

        f1.recebeAumento(200);

        f1.mostrarDados();
    }
}
