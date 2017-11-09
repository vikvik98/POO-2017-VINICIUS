/**
 * Created by aluno on 09/11/17.
 */
public class Programa {
    public static void main(String[] args) {

        Split ar = new Split();
        ar.modelo = "Samsung";
        ar.potencia = 9000;

        ar.ligar();
        ar.definirTemperatura(18);
        ar.definirModo("Ventilador");
        ar.informarSplit();
    }
}
