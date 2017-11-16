package App;

import Model.Circulo;

import javax.swing.*;

/**
 * Created by aluno on 16/11/17.
 */
public class Aplicacao {
    public static void main(String[] args) {
        Circulo c1 = new Circulo();
        Circulo c2 = new Circulo();

        c1.raio = 5.0;
        c1.x = 10;
        c1.y = 20;

        c2.raio = 6.0;
        c2.x = 15;
        c2.y = 30;

        double distancia = Math.sqrt(Math.pow((c1.x - c2.x), 2) + Math.pow((c1.y - c2.y), 2) );

        c1.status();
        JOptionPane.showMessageDialog(null,"A distancia entre o circulo C1 e o C2 é = " + distancia);
    }
}
