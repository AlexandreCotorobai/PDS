package org.example;
import java.util.Vector;

public class Puzzle {
    char[][] grid;
    Vector<String> word_list;

    Puzzle(char[][] puzzle, Vector<String> word_list) {
        this.grid = grid;
        this.word_list = word_list;
    }

    public void solve() {
        for (String word: word_list) {
            traverse(word);
        }
    }
    public void traverse(String word) {
        boolean wordFound = false;
        int size = grid[0].length;
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                if (wordFound == false && grid[row][column] == word.charAt(0)) {

                }
            }
        }
        if (wordFound == false)
            System.out.println(word + " not found");
    }

}
