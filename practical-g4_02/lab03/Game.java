
public class Game implements JGaloInterface{
    private char actualPlayer = 'X'; 
    private char[][] grid = new char[3][3];
    private boolean isWinner = false;
    public Game(){
    }
    
    public char getActualPlayer(){
        return actualPlayer;
    }
    
    public boolean setJogada(int lin, int col){
        boolean valid = false;
        lin--;
        col--;
        if (lin < 0 || lin >= 3 || col < 0 || col >= 3 || isWinner) return valid; // guard clause for invalid moves / end

        if (grid[lin][col] == '\0') {
            grid[lin][col] = actualPlayer;
            valid = true;
            if (isFinished()) return valid;
            changePlayer();
        }
    
        return valid;
    }

    public boolean isFinished(){
    // someone wons, or no empty positions
        isWinner = gotWinner(); // check if someone won?
        boolean isFull = checkIfFull();
        return (isWinner || isFull); // if is full or someone won, return true (is Finished)
    } 
	
    public char checkResult(){
    // wins the player that played last
        if (isWinner){
            return actualPlayer;
        } else {
            return ' ';
        }
    }
    
    private void changePlayer() {
        if (actualPlayer == 'X'){
            actualPlayer = 'O';
        } else {
            actualPlayer = 'X';
        }
    }

    private boolean checkIfFull(){
        boolean isFull = true;
        for(int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == '\0') {
                    isFull = false; // if its not full 
                }
            }
        }
        return isFull;
    }
    private boolean gotWinner(){

        // if(lin < 0 || lin >= 3 || col < 0 || lin >= 3){
        //     return
        // }
        boolean winner = false;
        for (int index = 0; index < grid.length; index++) { // check lines
            winner = checkLine(index, 0, new int[] {0,1});
            if (winner) return true;
        }
        for (int index = 0; index < grid.length; index++) { // check cols
            winner = checkLine(0, index, new int[] {1,0});
            if (winner) return true;
        }
        winner = checkLine(0, 0, new int[] {1,1});
        if (winner) return true;
        winner = checkLine(grid.length-1, 0, new int[] {-1,1});
        return winner;

    }

    private boolean checkLine(int lin, int col, int dir[]){
        char leadChar = grid[lin][col];
        char lastChar = '\0';
        for (int index = 0; index < grid.length-1; index++) {
            if (leadChar == '\0') return false;
            lastChar = leadChar;
            lin += dir[0];
            col += dir[1];

            leadChar = grid[lin][col];
            
            if (lastChar != leadChar) {
                return false;
            }
        }
        return true;
    }
}