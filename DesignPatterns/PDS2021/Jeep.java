public class Jeep implements Product{
    String code;
    String description;
    double points;

    // public Jeep(String code, String description, double points) {
    //     this.code = code;
    //     this.description = description;
    //     this.points = points;
    // }

    public Jeep(OldJeep oj){
        String[] parts = oj.getData().split(";");
        this.code = parts[0];
        this.description = parts[1];
        this.points = Double.parseDouble(parts[2]);
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
        return "Jeep " + code + " " + description;
    }

    

}
