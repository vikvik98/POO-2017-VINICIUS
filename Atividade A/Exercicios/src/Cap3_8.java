import java.util.Scanner;

public class Cap3_8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        n = in.nextInt();

        for (int i = 1; i < n; i++) {
            System.out.print(i + " ");
            for(int j = 1; j <= i; j++){
                System.out.print(i*j);

            }
        }
    }
}


