
public class CarrotCakeBuilder extends AbstractCakeBuilder {
    public CarrotCakeBuilder() {
        super("Carrot");
    }

    @Override
    public void addCreamLayer() {
        this.cake.setMidLayerCream(null);
    }

    @Override
    public void addTopLayer() {
        this.cake.setTopLayerCream(Cream.CHOCOLATE);
    }
    
    @Override
    public void addTopping() {
        this.cake.setTopping(null);
    }
}
