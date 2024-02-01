public class CakeMain {
    public static void main(String[] args) {
        CakeMaster cakeMaster = new CakeMaster();

        CakeBuilderInterface chocolate = new ChocolateCakeBuilder();
        cakeMaster.setCakeBuilder(chocolate);
        cakeMaster.createCake("Congratulations"); // 1 cake layer
        Cake cake = cakeMaster.getCake();
        System.out.println("Your cake is ready: " + cake);

        CakeBuilderInterface sponge = new SpongeCakeBuilder();
        cakeMaster.setCakeBuilder(sponge);
        cakeMaster.createCake(Shape.Square, 2, "Well done"); // squared, 2 cake layers
        cake = cakeMaster.getCake();
        System.out.println("Your cake is ready: " + cake);

        CakeBuilderInterface yogurt = new YogurtCakeBuilder();
        cakeMaster.setCakeBuilder(yogurt);
        cakeMaster.createCake(3, "The best"); // 3 cake layers
        cake = cakeMaster.getCake();
        System.out.println("Your cake is ready: " + cake);

        // add more cake builders here
        
        CakeBuilderInterface velvet = new VelvetCakeBuilder();
        cakeMaster.setCakeBuilder(velvet);
        cakeMaster.createCake(Shape.Rectangle, 4, "Happy Birthday"); // rectangle, 4 cake layers
        cake = cakeMaster.getCake();
        System.out.println("Your cake is ready: " + cake);

        CakeBuilderInterface carrot = new CarrotCakeBuilder();
        cakeMaster.setCakeBuilder(carrot);
        cakeMaster.createCake(5, "Happy New Year"); // 5 cake layers
        cake = cakeMaster.getCake();
        System.out.println("Your cake is ready: " + cake);

        cakeMaster.setCakeBuilder(chocolate);
        cakeMaster.createCake("Testing second Choco Cake"); // 1 cake layer
        cake = cakeMaster.getCake();
        System.out.println("Your cake is ready: " + cake);

    }
}
