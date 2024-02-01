public class Place {
    private final String name;
    private final String country;
    private final String state;

    public Place(String name, String country, String state) {
        this.name = name;
        this.country = country;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }

    @Override
    public String toString() {
        return name + " (" + state + ", " + country + ")";
    }
}
