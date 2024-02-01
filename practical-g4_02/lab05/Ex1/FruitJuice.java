public class FruitJuice implements Portion {
    private Temperature temperature;
    private State state;
    private JuiceFlavor fruitName;

    public FruitJuice() {
        this.temperature = Temperature.COLD;
        this.state = State.Liquid;
        this.fruitName = JuiceFlavor.Orange;
    }

    public Temperature getTemperature() {
        return this.temperature;
    }

    public State getState() {
        return this.state;
    }

    public JuiceFlavor getFruitName() {
        return this.fruitName;
    }

    @Override
    public String toString(){
        return "FruitJuice: " + this.getFruitName() + ", Temperature " + this.getTemperature() + ", State " + this.getState();
    }
}
