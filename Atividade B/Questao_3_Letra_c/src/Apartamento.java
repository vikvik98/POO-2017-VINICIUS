/**
 * Created by aluno on 09/11/17.
 */
public class Apartamento {
    double metrosQuadrados;
    String nomeApartamento;
    Proprietario proprietario = new Proprietario();
    double preco;

    void informarApartamento(){

        System.out.println("Nome do apartamento: " + this.nomeApartamento);
        System.out.println("Metros quadrados do apartamento: " + this.metrosQuadrados);
        System.out.println("Preço do apartamento: " + this.preco);
        System.out.println("Proprietario do apartamento: " + this.proprietario.nome);
        System.out.println("Idade do proprietario: " + this.proprietario.idade);
    }


    void checarMilhonario(){
        if(preco > 1000000){
            System.out.println("O proprietario " + this.proprietario.nome + " é milhonario.");
        }else{
            System.out.println("O proprietario " + this.proprietario.nome + "  não é milhonario.");
        }
    }
}
