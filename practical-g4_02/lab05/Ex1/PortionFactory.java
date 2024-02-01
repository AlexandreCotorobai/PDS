public class PortionFactory {

    public static Portion create(String type, Temperature temperature){
        if(type.equals("Beverage") && temperature.equals(Temperature.WARM)){
            return new Milk();
        }
        if(type.equals("Beverage") && temperature.equals(Temperature.COLD)){
            return new FruitJuice();
        }
        if(type.equals("Meat") && temperature.equals(Temperature.COLD)){
            return new Tuna();
        }
        if(type.equals("Meat") && temperature.equals(Temperature.WARM)){
            return new Pork();
        }
        return null;
    }

}
