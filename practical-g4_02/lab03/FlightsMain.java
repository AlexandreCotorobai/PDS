import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class FlightsMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  // Create a Scanner object
        
        HashMap<String, Plane> stored_planes = new HashMap<String, Plane>();

        Menu mn = new Menu();
        if (args.length == 0) {
            while (true) {
                mn.mainMenu();
                String userInput = sc.nextLine();
                usrInputHandler(userInput, mn, stored_planes);
            }
        } else { 
            for (String string : args) {
                String[] arr = readFile(string);
                for (String string2 : arr) {
                    usrInputHandler(string2, mn, stored_planes);
                }
            }
        }
        sc.close();
        
    }     


    //
    // this method handles all the user input and calls the respective methods
    //
    public static void usrInputHandler(String userInput, Menu mn, HashMap<String, Plane> stored_planes){
        String[] inputSplitted = userInput.split(" ");
        char usrOption = Character.toUpperCase(userInput.charAt(0));

        if (userInput == "" || userInput.toUpperCase().equals("H")) {

        }

        // switch case to check user input
        switch (usrOption) {
            case 'H': {
                mn.helpMenu();
                break;
            }

            case 'I': {
                if (inputSplitted.length == 1){
                    System.out.println("Insira o nome do ficheiro");
                    break;
                }

                String[] arr = readFile(inputSplitted[1]);
                Plane plane = createPlane(arr);
                
                if(plane == null) break;
                if (stored_planes.keySet().contains(plane.getFlightCode())) {
                    System.out.println("Plane already exists.");
                    break;
                }
                System.out.println(plane.planeCharacteristics());

                // ocupy plane's seats for each line of the file
                for (int i = 1; i < arr.length; i++) {
                    String[] reserves = arr[i].split(" ");
                    plane.ocupySeat(reserves[0], Integer.parseInt(reserves[1]));
                }

                // save plane in hashmap
                stored_planes.put(plane.getFlightCode(), plane);
                break;
            }

            case 'M': {
                if (inputSplitted.length == 1){
                    System.out.println("Insira o codigo do voo");
                    break;
                }

                String flight_code = inputSplitted[1];
                if (stored_planes.keySet().contains(flight_code)){
                    System.out.println(stored_planes.get(flight_code));
                } else {
                    System.out.println("Flight code does not exist.");
                }
                break;
            }

            case 'F': {
                String[] arr = {""};
                if (inputSplitted.length == 3) {
                    arr = new String[] {String.format(">%s %s", inputSplitted[1], inputSplitted[2])};
                } else if (inputSplitted.length == 4) {
                    arr = new String[] {String.format(">%s %s %s", inputSplitted[1], inputSplitted[2], inputSplitted[3])};
                } else {
                    System.out.println("Formato: flight_code [Opcional]num_seats_executive(4x3) num_seats_tourist(20x4)");
                    break;
                }

                Plane plane = createPlane(arr);
                
                if(plane == null) break;
                if (stored_planes.keySet().contains(plane.getFlightCode())) {
                    System.out.println("Plane already exists.");
                    break;
                }
                stored_planes.put(plane.getFlightCode(), plane);
                
                break;
            }

            case 'R': {
                if (inputSplitted.length != 4){
                    System.out.println("Formato: R flight_code class num_seats");
                    return;
                }
                // print splitted 2 and 3
                System.out.println(inputSplitted[2] + " " + inputSplitted[3]);
                Plane plane = stored_planes.get(inputSplitted[1]);
                plane.ocupySeat(inputSplitted[2], Integer.parseInt(inputSplitted[3]));
                int planeRessize = plane.getReservations().size();
                System.out.println(plane.getReservations().get(planeRessize-1));
                break;
            }

            case 'C': {
                if (inputSplitted.length != 3){
                    System.out.println("Formato: C flight_code sequencial_reservation_number");
                    break;
                }
                stored_planes.get(inputSplitted[1]).removeReservation(inputSplitted[2]);
                break;
            }

            case 'Q': {
                System.out.println("Closing Program..");
                System.exit(0);;
                break;
            }
            
            default: {
                mn.helpMenu();
                break;
            }
        }
        System.out.println();   
        return;
    }

    //
    // read file and saves each line in array
    //
    public static String[] readFile(String fileName) {
        Scanner scanner;
        ArrayList<String> lst = new ArrayList<String>();
        String[] arr = null;

        
        try {
            scanner = new Scanner(new File(fileName));
            while (scanner.hasNextLine()) {
            
                String line = scanner.nextLine();
                lst.add(line);
            }

            
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            System.exit(1);
            
		}
        
        arr = lst.toArray(new String[0]);
        
        return arr;
    }

    //
    // given the array of strings read before, creates a plane
    //
    public static Plane createPlane(String[] arr){
        // fligth information will be in the first line
        String[] fligth_info_arr = arr[0].split(" ");

        String fligth_code = fligth_info_arr[0].substring(1, fligth_info_arr[0].length());
        int[] exec_dim = {0,0};
        int[] tourist_dim = {0,0};

        // analize each class dimension
        if (fligth_info_arr.length == 3) {
            String[] temp = fligth_info_arr[1].split("x");
            exec_dim = new int[] {Integer.parseInt(temp[0]), Integer.parseInt(temp[1])};

            temp = fligth_info_arr[2].split("x");
            tourist_dim = new int[] {Integer.parseInt(temp[0]), Integer.parseInt(temp[1])};

        }else if (fligth_info_arr.length == 2){
            String[] temp = fligth_info_arr[1].split("x");
            tourist_dim = new int[] {Integer.parseInt(temp[0]), Integer.parseInt(temp[1])};
        }else{
            System.out.println("Invalid fligth code and/or dimensions");
            return null;
        }
        Plane plane = new Plane(fligth_code, exec_dim, tourist_dim);

        return plane;
    }


}