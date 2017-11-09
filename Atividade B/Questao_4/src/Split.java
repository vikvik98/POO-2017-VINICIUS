/**
 * Created by aluno on 09/11/17.
 */
public class Split {

    String modelo;
    double potencia;
    int temperatura;
    boolean ligado;
    String modo;

    void ligar(){
        this.ligado = true;
        System.out.println("O Ar foi ligado!!");
    }

    void definirTemperatura(int valor){
        this.temperatura = valor;
    }

    void definirModo(String modo){
        this.modo = modo;
    }

    void informarSplit(){

        System.out.println("O modelo do Split é = " + this.modelo);
        System.out.println("A potencia do Split é = " + this.potencia);
        System.out.println("A temperatura atual é = " + this.temperatura);
        System.out.println("O modo Atual é = " + this.modo);

    }
}
