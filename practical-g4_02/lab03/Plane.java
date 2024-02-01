
import java.util.ArrayList;

public class Plane {
    private int number_exclusive_seats; // number of exclusive seats
    private int number_touristic_seats;  // number of touristic seats
    private String flight_code;         // fligth code
    private int[] total_dim;            // total dimensions of the plane
    private int[][] exec_seats;         // executive seats zone
    private int[][] tourist_seats;       // touristic seats zone
    private int ordem_chegada = 1;   // order of the reservation
    private ArrayList<Reservation> Reservations = new ArrayList<Reservation>();
    // private int ordem_da_reserva = 1;


    // constructor for the plane
    public Plane(String flight_code, int[] executive_dim, int[] touristic_dim) {
        this.flight_code = flight_code;
        this.exec_seats = new int[executive_dim[0]][executive_dim[1]];
        this.tourist_seats = new int[touristic_dim[0]][touristic_dim[1]];
        // may be usefull??
        this.number_exclusive_seats = executive_dim[0] * executive_dim[1];
        this.number_touristic_seats = touristic_dim[0] * touristic_dim[1];
        if (touristic_dim[1] > executive_dim[1]) {
            this.total_dim = new int[] {executive_dim[0] + touristic_dim[0], touristic_dim[1]}; 
        } else {
            this.total_dim = new int[] {executive_dim[0] + touristic_dim[0], executive_dim[1]}; // may be useless since touristic should always be more
        }
    }

    public String getFlightCode(){
        return this.flight_code;
    }

    public void printTotalDim(){
        System.out.println("Total dim: " + total_dim[0] + "x" + total_dim[1]);
        // System.out.println("exec_seats: " + exec_seats.length + "x" + exec_seats[1].length);
    }


    // method that receives a class name and the number of reservations and
    // distributes it through the empty lines first and then through the 
    // remaining empty seats
    public void ocupySeat(String type, int number_of_revervations){
        if (number_of_revervations < 1){
            System.out.println("Número de lugares tem que ser um número positivo");
            return;
        }
        
        // in case the type is the executive class
        if(type.equals("E") && number_of_revervations <= number_exclusive_seats){
            Reservation res = new Reservation(flight_code,ordem_chegada, number_of_revervations, 'E');
            number_exclusive_seats-=number_of_revervations;
            int length_of_col = exec_seats[0].length;
            //System.out.println("RESERVA EXECUTIVA");
            //System.out.println("E " + number_of_revervations + " ordem_chegada: " + ordem_chegada);
            int col = findValidLine(exec_seats, number_of_revervations);
            if(col != -1){
                // iterator all seats of that line and seat there people
                for (int i = 0; i < number_of_revervations; i++) {
                    exec_seats[col][i%length_of_col] = ordem_chegada;
                    res.updateSeats(col, i%length_of_col, i);
                    if((i+1)%length_of_col == 0) col++;
                }
                ordem_chegada++;
            } else {
                // iterates all executive seats and puts people in the first empty seat
                int seatsplaced = 0;
                for (int i = 0; i < exec_seats.length*exec_seats[0].length; i++) {
                    if(exec_seats[i/length_of_col][i%length_of_col] == 0){
                        exec_seats[i/length_of_col][i%length_of_col] = ordem_chegada;
                        res.updateSeats(i/length_of_col, i%length_of_col, seatsplaced);
                        seatsplaced++;
                        if (number_of_revervations == seatsplaced) {
                            ordem_chegada++;
                            break;
                        }
                    }
                }
            }
            Reservations.add(res); 
            return;
        // in case the class is Turistic class
        } else if(type.equals("T") && number_of_revervations <= number_touristic_seats){
            Reservation res = new Reservation(flight_code, ordem_chegada, number_of_revervations, 'T');
            number_touristic_seats-=number_of_revervations;
            int length_of_col = tourist_seats[0].length;
            // iterator all lines of that zone
            int col = findValidLine(tourist_seats, number_of_revervations);
            if(col != -1){
                // iterator all seats of that line and seat there people
                for (int i = 0; i < number_of_revervations; i++) {
                    tourist_seats[col][i%length_of_col] = ordem_chegada;
                    res.updateSeats(exec_seats.length+col, i%length_of_col, i);
                    if((i+1)%length_of_col == 0) col++;
                }
                ordem_chegada++;
            } else {        
                // iterates all executive seats and puts people in the first empty seat
                int seatsplaced = 0;
                for (int i = 0; i < tourist_seats.length*tourist_seats[0].length; i++) {
                    if(tourist_seats[i/length_of_col][i%length_of_col] == 0){
                        tourist_seats[i/length_of_col][i%length_of_col] = ordem_chegada;
                        res.updateSeats(exec_seats.length+(i/length_of_col), i%length_of_col, seatsplaced);
                        seatsplaced++;
                        if (number_of_revervations == seatsplaced) {
                            ordem_chegada++;
                            break;
                        }
                    }
                }
            }
            Reservations.add(res); 
            return;
        }
        System.out.println("Não foi encontrado lugar para " + number_of_revervations + " pessoas na classe " + type);
    }
    
    // method used to cancel a reservation
    public void removeReservation(String seq_res_number){
        int res_numb = Integer.parseInt(seq_res_number);
        for (Reservation reservation : Reservations) {
            if (reservation.getCode() == res_numb) {
                System.out.println(reservation);
                removeSeats(reservation.getSeats_occupied(), reservation.getTypeRes());
                Reservations.remove(reservation);
                return;
            }
        }
        System.out.println("Reservation not found.");
    }

    // implemented in removeReservation method
    // reveices coords and the class, and proceeds to remove that reserve in that spot
    private void removeSeats(int[][] seatCoords, char typeRes){
        if (typeRes == 'E') {
            for (int[] is : seatCoords) {
                exec_seats[is[0]][is[1]] = 0;
            }
            number_exclusive_seats+= seatCoords.length;
        } else if (typeRes == 'T'){
            for (int[] is : seatCoords) {
                tourist_seats[is[0]-exec_seats.length][is[1]] = 0;
            }
            number_touristic_seats+= seatCoords.length;
        } else {
            System.out.println("Something went wrong with creating the reservation and now it has a invalid type.");
        }
    }

    // receives the zone grid and the collumn to check if is empty
    public int findValidLine(int[][] zone, int n_reservations){
        // iterates all seats of that line and check if it's all empty
        int valid_col = -1;
        for(int col = 0; col < zone.length; col++){
            boolean empty = true;
            for(int i = 0; i < zone[0].length; i++){
                if (zone[col][i] != 0) {
                    empty = false;
                }
            }
            if (empty){
                valid_col = col;
                break;
            }
        }
        // check if there are enough seats for the reservations
        // we assume that if there's a empty line, every seat behind it is empty.
        if (valid_col + ((n_reservations-1)/zone[0].length) >= zone.length) return -1; 
        return valid_col;
    }

    public String planeCharacteristics(){
        if (exec_seats.length != 0) {
            return String.format("Código de voo %s. Lugares disponíveis: %d lugares em classe Executiva; %d lugares em classe Turística.", flight_code, exec_seats[0].length*exec_seats.length, tourist_seats[0].length*tourist_seats.length);
        } else {
            return String.format("Código de voo %s. Lugares disponíveis: %d lugares em classe Turística.\nClasse executiva não disponível neste voo.",flight_code, tourist_seats[0].length*tourist_seats.length);
        }
        
    }

    @Override
    public String toString() {
        int letter = 65;
        String str = String.format("%4s", " ");
        
        // first line with numbers
        for(int i = 1; i <= total_dim[0]; i++){
            str += String.format("%4d", i);
        }
        
        str += "\n";
        
        for (int i = 0; i < total_dim[1]; i++) {
            str = str + String.format("%4s", (char)letter);
            letter++;
            for (int j = 0; j < exec_seats.length; j++) {
                if (i >= exec_seats[0].length) {
                    str += String.format("%4s", "");  
                } else {
                    str += String.format("%4s", exec_seats[j][i]);  
                }
            }
            for (int j = 0; j < tourist_seats.length; j++) {
                if (i >= tourist_seats[0].length) {
                    str += String.format("%4s", "");  
                } else {
                    str += String.format("%4s", tourist_seats[j][i]);  
                }
            }
            str += "\n";
        }

        return str;
    }



    public int getNumber_exclusive_seats() {
        return this.number_exclusive_seats;
    }

    public void setNumber_exclusive_seats(int number_exclusive_seats) {
        this.number_exclusive_seats = number_exclusive_seats;
    }

    public int getNumber_touristic_seats() {
        return this.number_touristic_seats;
    }

    public void setNumber_touristic_seats(int number_touristic_seats) {
        this.number_touristic_seats = number_touristic_seats;
    }

    public String getFlight_code() {
        return this.flight_code;
    }

    public void setFlight_code(String flight_code) {
        this.flight_code = flight_code;
    }

    public int[] getTotal_dim() {
        return this.total_dim;
    }

    public void setTotal_dim(int[] total_dim) {
        this.total_dim = total_dim;
    }

    public int[][] getExec_seats() {
        return this.exec_seats;
    }

    public void setExec_seats(int[][] exec_seats) {
        this.exec_seats = exec_seats;
    }

    public int[][] getTourist_seats() {
        return this.tourist_seats;
    }

    public void setTourist_seats(int[][] tourist_seats) {
        this.tourist_seats = tourist_seats;
    }

    public int getOrdem_chegada() {
        return this.ordem_chegada;
    }

    public void setOrdem_chegada(int ordem_chegada) {
        this.ordem_chegada = ordem_chegada;
    }

    public ArrayList<Reservation> getReservations() {
        return this.Reservations;
    }

    public void setReservations(ArrayList<Reservation> Reservations) {
        this.Reservations = Reservations;
    }

}
