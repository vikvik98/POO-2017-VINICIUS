package App;

import Model.Split;

/**
 * Created by aluno on 16/11/17.
 */
public class Aplicação {
    public static void main(String[] args) {
        Split s1 = new Split();
        s1.estado = false;
        s1.potencia = 9000;
        s1.modelo = "LG";


        s1.ligado();
        s1.setarModo();
        s1.setarTemperatura();
        s1.setarVelocidadeVento();
        s1.status();
    }
}
