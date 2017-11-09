public class Programa {
    public static void main(String[] args) {
        Carros c1 = new Carros();
        c1.cor = "Verde";
        c1.modelo = "Gol";
        c1.velocidadeAtual = 0;
        c1.velocidadeMaxima = 120;

        c1.ligar();

        c1.acelerar(30);
        System.out.println(c1.velocidadeAtual);

        System.out.println(c1.marcha());


    }
}
