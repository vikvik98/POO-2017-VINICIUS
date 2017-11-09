/**
 * Created by aluno on 09/11/17.
 */
public class Calculos {
    double pi = 3.14;
    Circulo calculo = new Circulo();

    double diametro = 2 * calculo.raio;
    double circunferencia = (2*pi) * calculo.raio;
    double area = pi * (2 * calculo.raio);


    void area(){
        System.out.println("A area deste circulo é = " + this.area);
    }

    void circufenrica(){
        System.out.println("A circuferencia deste circulo é = " + this.circunferencia);
    }

    void darDiametro(){
        System.out.println("O diametro deste circulo é = " + this.diametro);
    }

}
