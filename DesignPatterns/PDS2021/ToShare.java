import java.util.*;

public class ToShare {
    ArrayList<Product> cars;
    ArrayList<Product> sharedCars;
    Strategy strategy;


    public ToShare() {
        cars = new ArrayList<>();
        sharedCars = new ArrayList<>();
    }

    public void setStrategy(Strategy s) {
        strategy = s;
    }

    public void executeStrategy() {
        List<Product> tempCars = strategy.readProducts();

        for (Product p : tempCars) {
            cars.add(p);
        }
    }

    public boolean add(Product p) {
        if (p == null)
            return false;
        cars.add(p);
        return true;
    }

    public Product remove(String code) {
        for (Product p : cars) {
            if (p.code().equals(code)) {
                cars.remove(p);
                return p;
            }
        }
        return null;
    }

    public Product remove(Product p) {
        if (p == null)
            return null;
        cars.remove(p);
        return p;
    }

    public boolean share(String code, Client user) {
        // product with code will be shared with user and will be unavailable until
        // giveBack
        for (Product p : cars) {
            if (p.code().equals(code)) {
                sharedCars.add(p);
                cars.remove(p);
                return true;
            }
        }
        return false;
    }

    public boolean share(Product p, Client user) {
        if (cars.contains(p)) {
            sharedCars.add(p);
            cars.remove(p);
            return true;
        }
        return false;
    }

    public boolean giveBack(String code){
        for(Product p: sharedCars){
            if(p.code().equals(code)){
                cars.add(p);
                sharedCars.remove(p);
                return true;
            }
        }
        return false;
    

    }

    public boolean giveBack(Product p){
        if(sharedCars.contains(p)){
            cars.add(p);
            sharedCars.remove(p);
            return true;
        }
        return false;

    }

    public int totalProducts() {
        return cars.size();
    }

    public ArrayList<Product> getProducts() {
        ArrayList<Product> temp = new ArrayList<>(cars);

        for(Product shared: sharedCars){
            temp.add(shared);
        }

        return temp;
    }

    public String sharedProducts() {
        String s = "";
        for (Product p : sharedCars) {
            s += p.toString() + "\n";
        }
        return s;
    }
}
