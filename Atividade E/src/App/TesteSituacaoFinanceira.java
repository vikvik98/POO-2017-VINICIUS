package App;

import Model.SituacaoFinanceira;

public class TesteSituacaoFinanceira {
    public static void main(String[] args) {
        SituacaoFinanceira x = new SituacaoFinanceira();
        x.setValorCreditos(100);
        x.setValorDebitos(50);

        System.out.println(x.saldo());
    }
}
