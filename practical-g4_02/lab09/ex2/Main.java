package ex2;

public class Main {
    public static void main(String[] args) {
        ChefInterface chef1 = new Chef("PizzaChef", FoodType.PIZZA);
        ChefInterface chef2 = new Chef("PastChef", FoodType.PASTA);
        ChefInterface chef3 = new Chef("SushiChef", FoodType.SUSHI);
        ChefInterface chef4 = new Chef("BurgerChef", FoodType.BURGER);
        chef1.setNextChef(chef2);
        chef2.setNextChef(chef3);
        chef3.setNextChef(chef4);

        orderFood(FoodType.PIZZA, chef1);
        orderFood(FoodType.PASTA, chef1);
        orderFood(FoodType.SUSHI, chef1);
        orderFood(FoodType.BURGER, chef1);
        orderFood(FoodType.DESSERT, chef1);
        orderFood(FoodType.STEW, chef1);
        
        ChefInterface chef5 = new Chef("DessertChef", FoodType.DESSERT);

        chef4.setNextChef(chef5);

        orderFood(FoodType.PIZZA, chef1);
        orderFood(FoodType.PASTA, chef1);
        orderFood(FoodType.SUSHI, chef1);
        orderFood(FoodType.BURGER, chef1);
        orderFood(FoodType.DESSERT, chef1);
        orderFood(FoodType.STEW, chef1);
    }

    public static void orderFood(FoodType food, ChefInterface chef1) {
        boolean cooked = chef1.cook(food);
        if (!cooked) {
            System.out.println("We're sorry but that request can't be satisfied by our service!");
        }
    }
}
