import java.util.*;

public class ReadVector implements Strategy {
    Product[] products;

    public ReadVector(Product[] p) {
        products = p;
    }

    public List<Product> readProducts() {
        return Arrays.asList(products);
    }

}
