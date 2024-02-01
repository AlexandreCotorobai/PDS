/**
 * Phone
 */
public class Phone {

    private String processor;
    private String camera;
    private int price;
    private int storage;

    public Phone(String processor, String camera, int price, int storage) {
        this.processor = processor;
        this.camera = camera;
        this.price = price;
        this.storage = storage;
    }



    public String getProcessor() {
        return processor;
    }

    public String getCamera() {
        return camera;
    }

    public int getPrice() {
        return price;
    }

    public int getStorage() {
        return storage;
    }

    @Override
    public String toString() {
        return String.format("Processor %-15s | Storage %-10s GB | Camera %-15s | Price %-5s", getProcessor(), getStorage(), getCamera(), getPrice());
    }
}