public class BalancoTrimestral {
    public static void main(String[] args) {

        int gastosJaneiro = 15000;
        int gastosFeveireiro = 23000;
        int gastosMarco = 17000;
        int gastosTrimestral = gastosFeveireiro + gastosJaneiro + gastosMarco;
        int mediaMensal = gastosTrimestral / 3;
        System.out.println(gastosTrimestral);
        System.out.println("Valor da media mensal = " + mediaMensal);
    }
}
