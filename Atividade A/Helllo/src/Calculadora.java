import java.util.Scanner;


public class Calculadora {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        double n1, n2, soma, sub, multi, div;

        System.out.println("Digite um numero:");
        n1 = in.nextDouble();

        System.out.println("Digite outro numero:");
        n2 = in.nextDouble();

        soma = n1 + n2;
        System.out.println("A soma dos numeros eh = " + soma);

        sub = n1 - n2;
        System.out.println("A subtração dos numeros eh = " + sub);

        multi = n1 * n2;
        System.out.println("A multiplicação dos numeros eh = " + multi);

        div = n1 / n2;
        System.out.println("A divisão dos numeros eh = " + div);
    }
}
