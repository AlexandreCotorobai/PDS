public enum Cream {
    WHIPPED_CREAM("Whipped_Cream"),
    RED_BERRIES("Red_Berries"),
    VANILLA("Vanilla"),
    CREAM_CHEESE("Cream_Cheese"),
    CHOCOLATE("Chocolate");

    private final String str;
    Cream(String str) { 
        this.str = str;
    }

    public String getString() { return str; } 
}
