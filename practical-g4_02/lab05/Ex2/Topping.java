public enum Topping{
    FRUIT("Fruit"),
    CHOCOLATE("Chocolate"),
    STRAWBERRIES("Strawberries");

    private final String str;
    Topping(String str) { 
       this.str = str;
    }

    public String getString() { return str; } 
}