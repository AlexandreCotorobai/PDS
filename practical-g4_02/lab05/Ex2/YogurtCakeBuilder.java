public class YogurtCakeBuilder extends AbstractCakeBuilder {
    public YogurtCakeBuilder() {
        super("Yogurt");
    }

    @Override
    public void addCreamLayer() {
        this.cake.setMidLayerCream(Cream.VANILLA);
    }

    @Override
    public void addTopLayer() {
        this.cake.setTopLayerCream(Cream.RED_BERRIES);
    }
    
    @Override
    public void addTopping() {
        this.cake.setTopping(Topping.CHOCOLATE);
    }
}