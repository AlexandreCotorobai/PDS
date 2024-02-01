public abstract class Container {

    
    public final static Container create(Portion portion){

        if(portion.getState().equals(State.Liquid) && portion.getTemperature().equals(Temperature.COLD)){
            return new PlasticBottle(portion);
        }

        if(portion.getState().equals(State.Solid) && portion.getTemperature().equals(Temperature.COLD)){
            return new PlasticBag(portion);
        }

        if(portion.getState().equals(State.Liquid)){
            return new TermicBottle(portion);
        }

        if(portion.getState().equals(State.Solid)){
            return new TupperWare(portion);
        }
        return null;

    }

    public abstract String toString();

}
