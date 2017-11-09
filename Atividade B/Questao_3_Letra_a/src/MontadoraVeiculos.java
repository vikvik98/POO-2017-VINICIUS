/**
 * Created by aluno on 09/11/17.
 */
public class MontadoraVeiculos {

    Veiculos veiculo = new Veiculos();
    int anoGarantia;
    int anoFabricacao;

    void informarVeiculo(){

        System.out.println("Modelo do veiculo: " + this.veiculo.modelo);
        System.out.println("Cor do veiculo: " + this.veiculo.cor);
        System.out.println("Anos de garantia: " + this.anoGarantia);
        System.out.println("Ano de fabricação: " + this.anoFabricacao);
    }

    void verificarGarantia(int anoAtual){

        if((anoGarantia+anoFabricacao) <= anoAtual){

            System.out.println("A garantia deste veiculo expirou!!");

        }else {

            System.out.println("Este veiculo ainda esta na garantia!!");

        }

    }

}
