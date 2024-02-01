public class Reservation {
    private String flight_code;
    private int code;
    private int[][] seats_occupied;
    private char typeRes;
    public Reservation(String flight_code, int code, int n_of_People, char typeRes){
        this.flight_code = flight_code;
        this.code = code;
        this.seats_occupied = new int[n_of_People][2];
        this.typeRes = typeRes;
    }


    public String getFlight_code() {
        return this.flight_code;
    }

    public void setFlight_code(String flight_code) {
        this.flight_code = flight_code;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int[][] getSeats_occupied() {
        return this.seats_occupied;
    }

    public void setSeats_occupied(int[][] seats_occupied) {
        this.seats_occupied = seats_occupied;
    }

    public char getTypeRes() {
        return this.typeRes;
    }

    public void setTypeRes(char typeRes) {
        this.typeRes = typeRes;
    }

    public void updateSeats(int x, int y, int PersonNumber){
        seats_occupied[PersonNumber] = new int[] {x,y};
        return;
    }

    @Override
    public String toString() {
        int letter = 65;
        String str = flight_code;
        str += String.format(":%d =", code);
        for (int i = 0; i < seats_occupied.length-1; i++) {
            str+= String.format(" %d%c |", seats_occupied[i][0]+1, (char)(letter+seats_occupied[i][1]));
        }
        str+= String.format(" %d%c\n", seats_occupied[seats_occupied.length-1][0]+1, (char)(letter+seats_occupied[seats_occupied.length-1][1]));
        return str;
    }
}
