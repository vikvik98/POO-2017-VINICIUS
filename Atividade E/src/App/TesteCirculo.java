package App;

import Model.Circulo;

public class TesteCirculo {
    public static void main(String[] args) {

        Circulo c = new Circulo();

        c.setRaio(2);
        System.out.println("O perimetro do circulo c é = " + c.calcularPerimetro());

    }
}
