public class SpongeCakeBuilder extends AbstractCakeBuilder{
    
    public SpongeCakeBuilder() {
        super("Sponge");
    }

    public void addCreamLayer() {
        cake.setMidLayerCream(Cream.RED_BERRIES);
    }

    public void addTopLayer() {
        cake.setTopLayerCream(Cream.WHIPPED_CREAM);
    }

    public void addTopping() {
        cake.setTopping(Topping.FRUIT);
    }
}
