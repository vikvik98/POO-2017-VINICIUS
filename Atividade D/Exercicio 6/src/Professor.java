public class Professor extends Funcionario {
    private String titualacao;

    public void setTitualacao(String titualacao) {
        this.titualacao = titualacao;
    }


    public String getTitualacao() {
        return titualacao;
    }

    @Override
    public double getPrimeiraParcela() {
        return super.getSalario();
    }

    @Override
    public double getSegundaParcela() {
        return 0;
    }
}
