import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Generate {
    public static void main(String[] args) throws FileNotFoundException {
        String file = null;
        boolean file_used = false;
        int grid_size = 0;
        boolean grid_size_used = false;
        String writeFile = null;
        boolean writeFile_used = false;
        ArrayList<WordInfo> wordList = null;

        // detect flags and repective arguments
        for ( int i = 0; i < args.length; i++){
            String arg = args[i];

            if(arg.charAt(0) == '-'){
                switch (arg.charAt(1)) {
                    case 'i':
                        if (!file_used && args[i+1].endsWith(".txt")){
                            file = args[i+1];
                            file_used = true;
                        }else{
                            System.err.println("Invalid arguments: -i");
                            System.exit(1);
                        }
                        break;
                    
                    case 's':
                        try{
                            if (!grid_size_used) {
                                grid_size = Integer.parseInt(args[i+1]);
                                grid_size_used = true;
                            }
                            else{
                                System.err.println("Invalid arguments: -s");
                                System.exit(1);

                            }
                        }catch (NumberFormatException e) { 
                            System.out.println("not a valid integer"); 
                        } 
                        break;
                    case 'o':
                        if(!writeFile_used && args[i+1].endsWith(".txt")){
                            writeFile = args[i+1];
                            writeFile_used = true;
                        }else{
                            System.err.println("Invalid arguments: -o");
                            System.exit(1);

                        }
                        
                        break;
                    default:
                        break;
                }
            }
        }
        // System.out.printf("%s %d %s\n", file, grid_size, writeFile);



        try {
			Scanner scanner = new Scanner(new File(file));
			String line;
            wordList = new ArrayList<WordInfo>();


            while (scanner.hasNextLine()) {
				
				line = scanner.nextLine();

                String[] wordsInLine = line.split("[ ,;]");
                for(int j = 0; j < wordsInLine.length; j++){
                    // for each word checks if it is alfabetical with only down case or both (never only upper) and with min length of 3 
                    if(wordsInLine[j].matches("^[a-zA-Z]*$") && !wordsInLine[j].matches("^[A-Z]*$") && wordsInLine[j].length() >= 3 ){
                        WordInfo word = new WordInfo(wordsInLine[j].toUpperCase());
                        // to ignore duplicated words
                        if(!wordList.contains(word)){
                            wordList.add(word);
                        }
                    }else{
                        System.out.printf("Palavra *%s* encontrada, não cumpre requesitos de entrada..\nNão será adicionada à lista.\n",wordsInLine[j]);
                    }
                }

            }

        } catch (FileNotFoundException e) {
			System.err.println("File not Found..");
            System.exit(1);
		}

        // remove duplicated words
        wordList = WordInfo.listChecker(wordList);

        
        // print all words to be found in the soup
		System.out.print("Palavras detetadas: ");

		System.out.println();
        WordInfo[] wordsArr =  new WordInfo[wordList.size()];
        wordsArr = orderWords(wordList.toArray(wordsArr));

        gridGen(grid_size, wordsArr, writeFile);

        //Grid new_grid = new Grid(gridarr, grid_size);
    }

    public static void gridGen(int size, WordInfo[] words, String outputFile) throws FileNotFoundException{
        char[][] grid = new char[size][size];
        Random rng = new Random();
        ArrayList<WordInfo> removedString = new ArrayList<>();
        // For each word, evaluate the following logic
        for (WordInfo word : words) {
            // get all possible coordinates for the first letter i.e any space that hasnt been taken
            ArrayList<int[]> possibleCoords = generatePossibleCoords(word.getWordLength(), size, grid);
            // if no possible initial coordinates are available remove word from being placed
            if (possibleCoords == null) {
                removedString.add(word);
                //System.out.println("Word" + word.getWord() + " could not be adde because it's bigger than grid.");
            } else {
                boolean possible = false;
                // while word hasn't been place and there are still possible coordinates
                while (possibleCoords.size() > 0 && !possible) {
                    // get all possible directions
                    ArrayList<Direction> pDirections = new ArrayList<Direction>(Arrays.asList(Direction.values()));
                    // select a random starting coord from possibleCoords
                    int coordsindex = rng.nextInt(possibleCoords.size());
                    //while word hasn't been placed and there are still possible Directions
                    while(pDirections.size() > 0 && !possible) {
                        // choose random direction
                        int dirIndex = rng.nextInt(pDirections.size());
                        // check if word can be placed and update possible var with result
                        possible = tryPlaceWord(word, possibleCoords.get(coordsindex), grid, pDirections.get(dirIndex));
                        if(possible){
                            // if it's able to placed then place it
                            grid = placeWord(word, possibleCoords.get(coordsindex), grid, pDirections.get(dirIndex));
                        }
                        // remove direction used
                        pDirections.remove(dirIndex);
                    }
                    // remove initial coords used
                    possibleCoords.remove(coordsindex);
                }
                // if it wasnt possible to place the word after iterating through all the coordinates randomly then remove it
                if(!possible){
                    //System.out.println("Failed to place word" + word.getWord() + " in grid.");
                    removedString.add(word);
                }
                
            }
        }
        PrintStream myFile = new PrintStream(new File(outputFile));
        PrintStream console = System.out;
        System.setOut(myFile);
        // fill grid with random letters
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == '\0') {
                    grid[i][j] = (char)(rng.nextInt(26)+65);
                }
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
        // print the words that were placed i.e without the ones that were removed
        for (WordInfo wordInfo : words) {
            if (!removedString.contains(wordInfo)) {
                System.out.println(wordInfo.getWord().toLowerCase());
            }
        }
        System.setOut(console);
    }
    
    //given a word, init_coords and direction, it places in the grid
    public static char[][] placeWord(WordInfo word, int[] initial_coords, char[][] grid, Direction dir ){
        int[][] coords = GridWalker.walk(initial_coords[0], initial_coords[1], word.getWordLength(), dir, grid.length);
        for (int i = 0; i < coords.length; i++) {
            int[] is = coords[i];
            grid[is[0]][is[1]] = word.getWord().charAt(i);
        }
        return grid;
    }

    // check if its possible to put an word
    public static boolean tryPlaceWord(WordInfo word, int[] initial_coords, char[][] grid, Direction dir ){
        int[][] coords = GridWalker.walk(initial_coords[0], initial_coords[1], word.getWordLength(), dir, grid.length);
        if (coords == null) return false;
        
        for (int i = 0; i < coords.length; i++) {
            int[] is = coords[i];
            char c = grid[is[0]][is[1]];
            // only possible to put in a word, if in its coordinates positions are empty or have the same letter (allows overlaping words)
            if (c != '\0') {
                if (c != word.getWord().charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }


    public static ArrayList<int[]> generatePossibleCoords(int wordSize, int gridSize, char[][] grid){
        ArrayList<int[]> possibleCoords = new ArrayList<int[]>();
        if (wordSize > gridSize) {
            return null;
        } else if (wordSize == gridSize) {
            for (int row = 0; row < grid.length; row++) {
                if (grid[row][0] == '\0') {
                    possibleCoords.add(new int[] {row,0});
                } 
                if(grid[row][gridSize-1] == '\0'){
                    possibleCoords.add(new int[] {row,gridSize-1});
                }
            }

            for (int col = 1; col < grid.length-1; col++) {
                if (grid[0][col] == '\0') {

                    possibleCoords.add(new int[] {0,col});
                } 
                if(grid[gridSize-1][col] == '\0'){
                    possibleCoords.add(new int[] {gridSize-1,col});
                }
            }
        } else {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid.length; j++) {
                    if (grid[i][j] == '\0') {
                        possibleCoords.add(new int[] {i,j});
                    }
                }
           }
        }

        return possibleCoords;
    }

    public static WordInfo[] orderWords(WordInfo[] words){
        int count = words.length;
        int arraysize = words.length;
        WordInfo[] orderedWords = new WordInfo[count];
        while (count != 0) {
            int biggestindex = -1;
            WordInfo biggestWord = new WordInfo("");
            for (int i = 0; i < words.length; i++) {
                if (words[i].getWordLength() > biggestWord.getWordLength() && !words[i].getPlaced()) {
                    biggestWord = words[i];
                    biggestindex = i;
                }
            }
            words[biggestindex].setPlaced(true);;
            orderedWords[arraysize-count] = biggestWord;
            count--;
        }   
        return orderedWords;
    }
}
