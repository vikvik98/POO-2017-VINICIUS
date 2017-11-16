package Model;

import javax.swing.*;
import java.math.*;

public class Circulo {

    public double raio;
    public double pi = 3.14;
    public double comprimento, area;
    public int x = 0;
    public int y = 0;

    public double CalcArea(){
        double v = raio*raio*pi;
        return v;

    }

    public double CalcCircunferenca(){
        double c = 2*pi*raio;
        return c;
    }

    public void aumentarRaio(double n){
        this.raio = raio + n;
    }

    public void diminutirRaio(double z){
        this.raio = raio - z;
    }


    public void status(){
        JOptionPane.showMessageDialog(null, "A area do circulo é = " + CalcArea());
        JOptionPane.showMessageDialog(null, "A circunferencia é = " + CalcCircunferenca());

    }

    public void distanciaEntrePontos(){
        Math.sqrt(x);
        Math.pow(x,y);
    }


}
