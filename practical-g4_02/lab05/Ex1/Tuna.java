public class Tuna implements Portion{
    private Temperature temperature;
    private State state;

    public Tuna(){
        this.temperature = Temperature.COLD;
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
        return "Tuna: Temperature " + this.getTemperature() + ", State " + this.getState();
    }
    
}