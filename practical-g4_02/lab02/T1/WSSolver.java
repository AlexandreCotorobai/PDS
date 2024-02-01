import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

// import Utils.Utils;

public class WSSolver {
    public static void main(String[] args) throws Exception{
        if (args.length == 0) {
            System.out.println("Usage: lab01/java WSSolver [filename.txt]");
            System.exit(1);
        }

        String filename = args[0];
        // List<String> fileLines = Utils.readFile(filename);
        List<String> fileLines = Files.readAllLines(Paths.get(filename));
        SopaDeLetras sopa = new SopaDeLetras(fileLines); // validates file
        System.out.println(sopa.getResults());
    }
}
