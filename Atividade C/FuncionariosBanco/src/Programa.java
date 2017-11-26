public class Programa {
    public static void main(String[] args) {

        Empresa mister = new Empresa();
        mister.empregados = new Funcionarios[10];

        Funcionarios f1 = new Funcionarios();
        f1.setNome("Paulo Não Muda Nada");
        f1.setDepartamento("B2");
        f1.setSalario(1000.00);
        f1.setRg("666-666-66");
        mister.adiciona(f1);

        Funcionarios f2 = new Funcionarios();
        f2.setNome("Jesus Tortao");
        f2.setDepartamento("B2");
        f2.setSalario(3000.00);
        f2.setRg("111-111-11");
        mister.adiciona(f2);

        mister.mostrarEmpregados();
        mister.contem(f1);
    }
}
