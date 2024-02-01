public class TermicBottle extends Container{
    private Portion portion;

    public TermicBottle(Portion portion) {
        this.portion = portion;
    }

    @Override
    public String toString() {
        return "TermicBottle with portion = " + portion;
    }
}
