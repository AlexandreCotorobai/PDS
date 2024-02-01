public class Motorcycle implements Product{
    String code;
    String description;
    double points;

    public Motorcycle(String code, String description, double points) {
        this.code = code;
        this.description = description;
        this.points = points;
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String description() {
        return description;
    }

    @Override
    public double points() {
        return points;
    }

    
    @Override
    public String toString() {
        return "Motorcycle " + code + " " + description;
    }
}
