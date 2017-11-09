/**
 * Created by aluno on 09/11/17.
 */
public class Programa {
    public static void main(String[] args) {

        Calculos c1 = new Calculos();
        c1.calculo.raio = 5;
        c1.calculo.y = 5;
        c1.calculo.x = 0;

        c1.circufenrica();
        c1.area();
        c1.darDiametro();
    }
}
