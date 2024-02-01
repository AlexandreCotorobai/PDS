package ex2;

public class Chef implements ChefInterface {
    
    private String name;
    private ChefInterface nextChef;
    private FoodType cookableFood;

    public Chef(String name, FoodType cookableFood) {
        this.name = name;
        this.cookableFood = cookableFood;
    }

    public void setNextChef(ChefInterface chef) {
        this.nextChef = chef;
    }

    public boolean cook(FoodType food) {
        if (food == cookableFood) {
            // random numbger between 8 and 18
            int time = (int) (Math.random() * 10 + 8);
            System.out.println(name + ": Starting to cook " + food.label + ". Out in " + time + " minutes.");
            return true;
        } else if (nextChef != null) {
            return nextChef.cook(food);
        } else {;
            return false;
        }
    }
}
