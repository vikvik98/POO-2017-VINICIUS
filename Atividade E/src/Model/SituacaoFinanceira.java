package Model;

public class SituacaoFinanceira {
    private double valorCreditos;
    private double valorDebitos;

    public double saldo(){
        return valorCreditos - valorDebitos;
    }

    public void setValorCreditos(double valorCreditos) {
        this.valorCreditos = valorCreditos;
    }

    public void setValorDebitos(double valorDebitos) {
        this.valorDebitos = valorDebitos;
    }
}
