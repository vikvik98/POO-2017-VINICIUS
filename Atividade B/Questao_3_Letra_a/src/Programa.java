/**
 * Created by aluno on 09/11/17.
 */
public class Programa {

    public static void main(String[] args) {

        MontadoraVeiculos v1 = new MontadoraVeiculos();
        v1.veiculo.modelo = "GOl";
        v1.veiculo.cor = "Vermelho";
        v1.anoGarantia = 3;
        v1.anoFabricacao = 2008;

        v1.informarVeiculo();

        v1.verificarGarantia(2017);
    }
}
