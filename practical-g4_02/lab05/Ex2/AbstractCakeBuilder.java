abstract class AbstractCakeBuilder implements CakeBuilderInterface {
    protected Cake cake;

    public AbstractCakeBuilder(String cakeLayer) {
        cake = new Cake(cakeLayer);
    }
    
    public void createCake(){
        this.addCreamLayer();
        this.addTopLayer();
        this.addTopping();
    }

    public Cake getCake() {
        Cake returnCake = cake;
        cake = new Cake(cake.getCakeLayer());
        // this is to make sure that the cake is not changed after it is returned
        return returnCake;
    }



    public void setCakeShape(Shape shape){
        cake.setShape(shape);
    }

    public void addCakeLayer(){
        cake.addCakeLayer();
    }

    public void addMessage(String message){
        cake.setMessage(message);
    }

    public abstract void addCreamLayer();
    public abstract void addTopLayer();
    public abstract void addTopping();

}

