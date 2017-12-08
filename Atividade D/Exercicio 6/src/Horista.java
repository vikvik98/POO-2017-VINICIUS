public class Horista extends Diarista {

    @Override
    public double calcSalario() {
        return super.calcSalario()/24;
    }
}
