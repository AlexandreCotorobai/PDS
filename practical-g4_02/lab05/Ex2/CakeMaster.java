public class CakeMaster {
    private CakeBuilderInterface cakeBuilder;

    public CakeMaster() {
    }

    public void setCakeBuilder(CakeBuilderInterface cakeBuilder) {
        this.cakeBuilder = cakeBuilder;
    }

    public Cake getCake(){
        return this.cakeBuilder.getCake();
    }

    public void createCake(Shape shape, int numLayer, String message){
        this.cakeBuilder.createCake();
        this.cakeBuilder.setCakeShape(shape);
        for (int i = 0; i < numLayer; i++) {
            this.cakeBuilder.addCakeLayer();
        }
        this.cakeBuilder.addMessage(message);
    }

    public void createCake(int numLayer, String message){
        this.createCake(Shape.Circle, numLayer, message);
    }

    public void createCake(String message){
        this.createCake(1, message);
    } 
}
