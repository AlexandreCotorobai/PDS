package ex2;

public interface ChefInterface {
    public void setNextChef(ChefInterface chef);
    public boolean cook(FoodType food);
}