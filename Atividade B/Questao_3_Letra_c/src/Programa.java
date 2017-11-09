/**
 * Created by aluno on 09/11/17.
 */
public class Programa {
    public static void main(String[] args) {

        Apartamento ap = new Apartamento();
        ap.proprietario.nome = "Daniel";
        ap.proprietario.idade = 18;
        ap.metrosQuadrados = 200.00;
        ap.nomeApartamento = "B2";
        ap.preco = 500000;

        ap.informarApartamento();
        ap.checarMilhonario();
    }
}
