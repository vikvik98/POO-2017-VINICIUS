
public class ExercicioX {
    public static void main(String[] args) {

        for (int i = 150; i <= 300; i++){
            System.out.println(i);
        }

        int soma = 0;
        for (int i = 1; i <= 1000; i++){
            soma += i;

        }
        System.out.println(soma);

        for (int i = 1; i <= 100; i++){
            if (i % 3 == 0){
                System.out.println(i);
            }
        }

        for (int i = 1; i <= 10; i++){
            long aux = 1;
            long resultado = 0;
            for (int j = 1; j <= i; j++){
                resultado = aux * j;
                aux = resultado;
            }
            System.out.println("O fatorial de " + i + " = " + resultado);
        }
        int n = 0, resultado = 0, aux = 1;
        for (int i = 1; i <= 12; i++){
            if (resultado < 100){
                resultado = n + aux;
                n = aux;
                aux = resultado;
            }else{
                break;
            }
            System.out.println("O fibo de " + i + " = " + resultado);
        }

        }
    }

