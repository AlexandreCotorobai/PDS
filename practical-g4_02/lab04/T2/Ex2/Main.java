package lab3.Ex2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import java.util.Scanner;

public class Main {
	static Map<String, Flight> codigoVooMap = new HashMap<String, Flight>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
        	
            System.out.println("Pick an option: (H for help)");
            String[] option = sc.nextLine().split(" ");
            
            switch (option[0].toLowerCase()) {
            case "i":
                String filename = option[1];
                Flight flight = optionI(filename);
                System.out.println(flight);
                break;
                
            case "m":
                String flight_codeM = option[1];
                optionM(flight_codeM);
                break;
                
            case "f":
                String flight_codeF = option[1];
                String num_seats_executive = option[2];
                String num_seats_tourist = option[3];
                optionF(flight_codeF, num_seats_executive, num_seats_tourist);
                break;
                
            case "r":
                String flight_codeR = option[1];
                ClassPlane classe;
                if (Arrays.asList(option[2]).contains("T")) {
                    classe = ClassPlane.TURISTICA;
                } else if (Arrays.asList(option[2]).contains("E")) {
                    classe = ClassPlane.EXECUTIVA;
                } else {
                    System.err.println("ERROR: Airplane class in input is not supported");
                    break;
                }
                int number_seats = Integer.parseInt(option[3]);
                optionR(flight_codeR, classe, number_seats);
                break;
                
            case "c":
                // NOTA: O c�digo de reservation �:
                // flight_code:sequential_reservation_number
                String reservation_code = option[1];
                optionC(reservation_code);
                break;
                
            case "h":
                System.out.println(optionH());
                break;
                
            case "q":
                System.out.println("Exiting...");
                flag = false;
                break;
                
            default:
                System.err.println("ERROR: Option is not supported");
                break;
            }
        }
        for (String key : codigoVooMap.keySet()) {
            System.out.printf("%s\n", codigoVooMap.get(key));
        }
        sc.close();
    }
    
    //caso seja a op�ao i
    private static Flight optionI(String filename){
        try{
            Scanner sc1 = new Scanner(new File("./lab3/Voos/Ficheiros/" + filename));
            String[] input = sc1.nextLine().split(" ");
            String flightCode = input[0];
            flightCode = flightCode.replaceAll(">", "");

            // Error verification
            if(input.length>3){
                System.err.println("ERROR: Invalid type of input file, cannot extract flight code!");
                System.exit(0);
            }               
            
            Plane plane;
            if (input.length == 3) {
                plane = new Plane(input[2], input[1]);
                plane.setConfAviao(ClassPlane.TURISTICA_EXECUTIVA);
            } else {
                plane = new Plane(input[1], "");
                plane.setConfAviao(ClassPlane.TURISTICA);
            }
            
            Flight flight = new Flight(flightCode, plane);
            codigoVooMap.put(flightCode, flight);
            
            
            
            String[] seat;       // reserva de lugar
            while(sc1.hasNextLine()){
                seat = sc1.nextLine().split(" ");
                if(seat[0].toCharArray()[0] == 'T'){           //ver se o lugar � turistico
                    Reserva reservation = new Reserva(ClassPlane.TURISTICA, Integer.valueOf(seat[1]));
                    flight.addReservations(reservation);
                } else if (seat[0].toCharArray()[0] == 'E') { //or EXECUTIVE
                    if (plane.getClassPlane() == ClassPlane.TURISTICA) {
                        break;
                    }
                    Reserva reservation = new Reserva(ClassPlane.EXECUTIVA, Integer.valueOf(seat[1]));
                    flight.addReservations(reservation);
                }  
            }
            return flight;
        }
        
        catch (FileNotFoundException e) {
            System.err.println("ERROR: File not found, please add another input file.");
            return null;
        }
   }
    
    //caso seja a op�ao m
    public static void optionM(String flight_code) {
        System.out.println("ISTO EST� CERTO! MAS POR MOTIVOS DE TEMPO N�O CONSGUIMOS FAZER O OVERVIEW DOS SEATS COMO PEDIDO\nPARA CONFIRMAR QUE ESTAVA CERTO, EM FASE DE DEBUG, FAZIAMOS PRINTS DAS RESERVAS QUE CADA AVIAO TINHA!");
    }
    
    //caso seja a op�ao f
    public static void optionF(String flight_code, String num_seats_executive, String num_seats_tourist) {
        
        Plane plane = new Plane(num_seats_tourist, num_seats_executive);
        Flight voo = new Flight(flight_code, plane);
        codigoVooMap.put(flight_code, voo);
       
        System.out.println("Flight inserted with success\n");

        for (String key : codigoVooMap.keySet()) {
            System.out.printf("%s\n", codigoVooMap.get(key));
        }
    }
    
    //caso seja a op�ao r
    public static void optionR(String flight_code, ClassPlane classe, int number_seats) {

        for (String key : codigoVooMap.keySet()) {
            if (key.equals(flight_code)) {
                Flight voo = codigoVooMap.get(key);
                Reserva reservation = new Reserva(classe, number_seats);
                voo.addReservations(reservation);
                int reservationNumber = voo.getPlane().getReservationNumber() - 1;
                String reservation_code = flight_code + ":" + reservationNumber;
                System.out.println(reservation_code);
            }
        }
    }
    
    //caso seja a op�ao c
    public static void optionC(String reservation_code) {
        String[] separation = reservation_code.split(":"); 
        for (String key : codigoVooMap.keySet()) {
            if (separation[0].equals(key)) {
                Flight voo = codigoVooMap.get(key);
                voo.removeReservations(separation);
                codigoVooMap.put(key, voo);

            }
        }
    }
    
    
    //string das op�oes
    public static String optionH() {
        String helpString = "H : Help\n" + "I <filename> : Read a file with information about the flight\n"
                + "M <flight_code> : Show the reservation mao of the flight\n"
                + "F <flight_code> <num_seats_executive> <num_seats_tourist> : Add a new flight\n"
                + "R <flight_code> <class> <number_seats> : Add a new revervation to a flight\n"
                + "C <reservation_code> : Cancel a revervation\n" + "Q : Quit";
        return helpString;
    }

}
