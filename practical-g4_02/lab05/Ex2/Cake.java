public class Cake {
    private Shape shape;
    private String cakeLayer;
    private int numCakeLayer;
    private Cream midLayerCream;
    private Cream topLayerCream;
    private Topping topping;
    private String message;

    public Cake(String cakeLayer) {
        this.cakeLayer = cakeLayer;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public void setCakeLayer(String cakeLayer) {
        this.cakeLayer = cakeLayer;
    }

    public void setNumCakeLayer(int numCakeLayer) {
        this.numCakeLayer = numCakeLayer;
    }

    public void setMidLayerCream(Cream midLayerCream) {
        this.midLayerCream = midLayerCream;
    }

    public void setTopLayerCream(Cream topLayerCream) {
        this.topLayerCream = topLayerCream;
    }

    public void setTopping(Topping topping) {
        this.topping = topping;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public void addCakeLayer(){
        this.numCakeLayer++;
    }
    
    public String getCakeLayer() {
        return cakeLayer;
    }
    
    @Override
    public String toString(){
        String str = shape + " " + cakeLayer + " cake with " + numCakeLayer + " layers";
        if (midLayerCream != null) str += " and " + midLayerCream.getString() + " cream";
        if (topLayerCream != null) str += ", topped with " + topLayerCream.getString() + " cream";
        if (topping != null) str += " and " + topping.getString();
        str += ". Message says : \"" + message + "\".";
        return str;
    }
}
