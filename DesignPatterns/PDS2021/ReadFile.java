import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ReadFile implements Strategy {
    String path;

    public ReadFile(String path) {
        this.path = path;
    }

    public List<Product> readProducts() {
        // read file path
        List<Product> products = new ArrayList<>();

        try {
            Scanner scan = new Scanner(new File(path));

            while (scan.hasNextLine()) {
                
                String line = scan.nextLine().strip();
                if (line.equals("")){
                    continue;
                }
                
                String[] parts = line.split("\t");
                String type = parts[0];
                String code = parts[1];
                String description = parts[2];
                double points = Double.parseDouble(parts[3]);
                Product temp = null;

                if (type.equals("Car")) {
                    temp = new Car(code, description, points);
                } else if (type.equals("Van")) {
                    temp = new Van(code, description, points);
                } else if (type.equals("Motorcycle")) {
                    temp = new Motorcycle(code, description, points);
                }
                products.add(temp);
            }

            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        return products;

    }

}
