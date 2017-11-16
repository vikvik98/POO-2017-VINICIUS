package Model;

import javax.swing.JOptionPane;
public class Split {


    public double temperatura;
    public String modelo;
    public int potencia;
    public boolean estado;
    public int velocidadeVento;
    public String modo;


    public boolean ligado(){
        if(estado == false){
            JOptionPane.showMessageDialog(null,"O split acaba de ser ligado!!");
            estado = true;
            return true;
        }else{
            JOptionPane.showMessageDialog(null,"O Model.Split já está ligado!!");
            return false;
        }

    }

    public void setarTemperatura(){
        double x = Double.parseDouble(JOptionPane.showInputDialog("Digite a temperatura que você deseja:"));
        temperatura = x;
    }

    public void setarModo(){
        String x = JOptionPane.showInputDialog("Digite o modo que você deseja:");
        modo = x;

    }

    public void setarVelocidadeVento(){
        int x = Integer.parseInt(JOptionPane.showInputDialog("Digite a velocidade do vento desejada:"));
        velocidadeVento = x;
    }

    public void status(){
        if(estado == true) {
            JOptionPane.showMessageDialog(null, "O estado do Model.Split está = Ligado");

        }else{
            JOptionPane.showMessageDialog(null, "O estado do Model.Split está = Desligado");
        }
        JOptionPane.showMessageDialog(null, "A temperatura do split = " + temperatura);
        JOptionPane.showMessageDialog(null, "O modo do Model.Split = " + modo);
        JOptionPane.showMessageDialog(null, "O modelo do Model.Split = " + modelo);
        JOptionPane.showMessageDialog(null, "A velocidade do vento = " + velocidadeVento);
    }

}
