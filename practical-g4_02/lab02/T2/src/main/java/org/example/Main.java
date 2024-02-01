package org.example;
import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;

public class Main {
    // Main driver method
    public static void main(String[] args) throws Exception
    {
        Vector<String> vec = new Vector<>();
        // Passing the path to the file as a parameter
        FileReader fr = new FileReader(
                "C:\\Users\\piotr\\IdeaProjects\\WSSolver\\target\\exa.txt");

        // Declaring loop variable
        int i;
        // Holds true till there is nothing to read
        while ((i = fr.read()) != -1){
            // Print all the content of a file
           // System.out.print((char)i);
        }
        while ((i = fr.read()) != -1){
            if(Character.isLowerCase((char)i)){
                vec.add(String.valueOf((char)i));
            }
            System.out.print((char)i);
        }
        for(int s=0;s< vec.size();s++){
            System.console().printf(vec.get(i));
        }

    }

    public static String getArg(String[] args){
        if (args.length == 1) {
            return args[0];
        }
        else {
          //  System.out.print("Launch the program with a single file name. ");
            System.exit(0);
            return null;
        }
    }
//    public static Puzzle readFile(String fileName) {
//        final int maxSize = 40;
//        final int maxWords = 40;
//        File file = new File(fileName);
//        try {
//            Scanner scanner = new Scanner(file);
//            String firstLine = scanner.nextLine();
//            int size = firstLine.length();
//            char[][] puzzle = new char[size][size];
//            for (int col = 0; col < size; col++) {
//                puzzle[0][col] = firstLine.charAt(col);
//            }
//            int row = 1;
//            while (scanner.hasNextLine() && row < size) {
//                String line = scanner.nextLine();
//                for (int col = 0; col < size; col++) {
//                    puzzle[row][col] = line.charAt(col);
//                }
//                row++;
//            }
//            Vector<String> word_vector = new Vector<String>();
//            while (scanner.hasNextLine()) {
//                String word = scanner.nextLine();
//                if (word.length() > 0)
//                    word_vector.add(word);
//            }
//            if (firstLine.length() > maxSize || word_vector.size() > maxWords) {
//                System.out.println("TOO MANY WORDS!!!");
//                System.exit(0);
//            }
//            Puzzle p = new Puzzle(puzzle, word_vector);
//            scanner.close();
//            return p;
//        } catch (FileNotFoundException e) {
//            System.out.println("The file was not found.");
//            return null;
//        }
//    }

}