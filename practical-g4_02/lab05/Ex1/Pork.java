public class Pork implements Portion{
    private Temperature temperature;
    private State state;

    public Pork(){
        this.temperature = Temperature.WARM;
        this.state = State.Solid;
    }

    public Temperature getTemperature(){
        return this.temperature;
    }

    public State getState(){
        return this.state;
    }

    @Override
    public String toString(){
        return "Pork: Temperature " + this.getTemperature() + ", State " + this.getState();
    }
}
