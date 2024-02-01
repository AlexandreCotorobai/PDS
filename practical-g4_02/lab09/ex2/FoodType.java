package ex2;

public enum FoodType {
    BURGER("Burger"), SUSHI("Sushi"), PASTA("Pasta"), PIZZA("Pizza"), DESSERT("Dessert"), STEW("Stew");
    public final String label;

    private FoodType(String label) {
        this.label = label;
    }
}
