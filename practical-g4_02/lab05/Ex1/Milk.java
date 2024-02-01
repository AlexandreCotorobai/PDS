public class Milk implements Portion{
    private Temperature temperature;
    private State state;
    
    public Milk(){
        this.temperature = Temperature.WARM;
        this.state = State.Liquid;
    }

    public Temperature getTemperature(){
        return this.temperature;
    }

    public State getState(){
        return this.state;
    }

    @Override
    public String toString(){
        return "Milk: Temperature " + this.getTemperature() + ", State " + this.getState();
    }

}
