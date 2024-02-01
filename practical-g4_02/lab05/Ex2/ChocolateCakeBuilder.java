public class ChocolateCakeBuilder extends AbstractCakeBuilder {
    
    public ChocolateCakeBuilder() {
        super("Soft Chocolate");
    }

    public void addCreamLayer() {
        cake.setMidLayerCream(null);
    }

    public void addTopLayer() {
        cake.setTopLayerCream(Cream.WHIPPED_CREAM);
    }

    public void addTopping() {
        cake.setTopping(Topping.FRUIT);
    }    
}
