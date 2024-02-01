public class TupperWare extends Container{
    private Portion portion;

    public TupperWare(Portion portion) {
        this.portion = portion;
    }

    @Override
    public String toString() {
        return "TupperWare with portion = " + portion;
    }

}
