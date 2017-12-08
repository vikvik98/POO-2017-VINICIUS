package Model;

public class Circulo {

    private double raio;

    public double calcularPerimetro(){
        return this.raio*2;
    }


    public void setRaio(double raio) {
        this.raio = raio;
    }

    public double getRaio() {
        return raio;
    }
}
