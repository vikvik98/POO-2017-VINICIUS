import java.util.Scanner;

public class Cap3_7 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int x;
        x = in.nextInt();

        while(x > 1){

            if (x % 2 == 0){

                x = x / 2;
                System.out.print(x + " ");

            }else{

                x = 3 * x + 1;
                System.out.print(x + " ");
            }
        }
    }
}
