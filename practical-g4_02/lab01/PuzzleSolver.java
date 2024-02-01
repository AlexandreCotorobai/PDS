import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
/**
 * PuzzleSolver
 */
public class PuzzleSolver {

    public static Grid solveGrid(Grid grid, WordInfo[] words) {
        // get first letter of every word
        char[][] puzzleSolved = new char[grid.getSize()][grid.getSize()];
        Map<Character, ArrayList<Integer>> letterDic = new HashMap<Character, ArrayList<Integer>>();
        for (int i = 0; i < words.length; i++) {
            ArrayList<Integer> index = new ArrayList<Integer>();
            char letter = words[i].getWord().charAt(0);
            if (letterDic.containsKey(letter)) {
                index = letterDic.get(letter);
                index.add(i);
                letterDic.put(words[i].getWord().charAt(0), index);  
            } else {
                index.add(i);
                letterDic.put(words[i].getWord().charAt(0), index);  
            }
        }
        
        
        //Loop through grid rows
        for(int row = 0; row < grid.getSize(); row++){
            // loop through grid cols
            for (int col = 0; col < grid.getSize(); col++) {
                //Check if letter is in firstLetter
                if (letterDic.containsKey(grid.getElement(row, col))){
                    // get indexes of words that start with that letter
                    ArrayList<Integer> wordsIndex = letterDic.get(grid.getElement(row, col));
                    // for each direction get word formed by the letters in grid
                    for (Direction dir : Direction.values()) {
                        for (Integer index : wordsIndex) {
                            String wordInDir = grid.getWord(row, col, words[index].getWordLength(), dir);
                            if (wordInDir == null) continue; // if something goes wrong when getting the word continue. ie out of bounds
                            
                            if (wordInDir.equals(words[index].getWord())) { // if we found word
                                if(words[index].getFound()) { // check if it has already been found
                                    System.out.println("Word " + words[index].getWord() + " found in multiple places.");
                                    System.exit(1); // exit error
                                }
                                words[index].found(); // Update wordInfo 
                                words[index].setDir(dir);
                                int[] coords = {row,col};
                                words[index].setCoords(coords);
                                int[][] coordsArr = GridWalker.walk(row, col, words[index].getWordLength(), dir, grid.getSize());
                                for (int j = 0; j < coordsArr.length; j++) {
                                    int[] coord = coordsArr[j];
                                    puzzleSolved[coord[0]][coord[1]] = wordInDir.charAt(j);
                                }
                                break;
                            }
                        }
                    }
                }
            }
        }
        // fill all remaining positions with .
        for (int i = 0; i < puzzleSolved.length; i++) {
            for (int j = 0; j < puzzleSolved.length; j++) {
                if (puzzleSolved[i][j] == '\0') {
                    puzzleSolved[i][j] = '.';
                }
            }
        }
        Grid solvedGrid = new Grid(puzzleSolved, grid.getSize());
        return solvedGrid;
    }
}   