public class Carros {
    String cor;
    String modelo;
    double velocidadeAtual;
    double velocidadeMaxima;
    Motor motor = new Motor();

    void ligar(){
        System.out.println("O carro esta ligado!!");
    }

    void acelerar(double quantidade){
        this.velocidadeAtual += quantidade;
    }

    int marcha(){
        if (this.velocidadeAtual < 0){
            return -1;
        }
        if (this.velocidadeAtual >= 0 && this.velocidadeAtual < 40){
            return 1;
        }
        if (this.velocidadeAtual >= 40 && this.velocidadeAtual < 60){
            return 2;
        }
        return 3;
        }
}
